package dev.scx.serialize;

import dev.scx.format.json.JsonNodeConvertOptions;
import dev.scx.format.xml.XmlNodeConverterOptions;
import dev.scx.object.x.DefaultObjectNodeConvertOptions;
import dev.scx.object.x.mapper.bean.BeanFieldReadResult;
import dev.scx.object.x.mapper.bean.BeanFieldWriteResult;
import dev.scx.object.x.mapper.bean.BeanNodeMapperOptions;
import dev.scx.object.x.mapper.map.MapNodeMapperOptions;
import dev.scx.object.x.mapper.record.RecordComponentWriteResult;
import dev.scx.object.x.mapper.record.RecordNodeMapperOptions;
import dev.scx.object.x.mapper.record.RecordParameterReadResult;
import dev.scx.serialize.annotation.Ignore;

final class OptionsResolver {

    public static DefaultObjectNodeConvertOptions resolve(ObjectToNodeOptions options) {
        var result = new DefaultObjectNodeConvertOptions();

        var ignoreNullValue = options.ignoreNullValue();
        var useAnnotations = options.useAnnotations();

        result.addMapperOptions(new BeanNodeMapperOptions().beanFieldWritePolicy((fieldInfo, fieldValue) -> {

            // 忽略 null 值.
            if (ignoreNullValue) {
                if (fieldValue == null) {
                    return BeanFieldWriteResult.ofSkip();
                }
            }

            if (useAnnotations) {
                // 忽略 SerializeIgnore 注解
                var annotation = fieldInfo.findAnnotation(Ignore.class);
                if (annotation != null) {

                    if (annotation.value() == Ignore.Mode.SERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                        return BeanFieldWriteResult.ofSkip();
                    }

                }
            }

            return null;
        }));

        result.addMapperOptions(new RecordNodeMapperOptions().recordComponentWritePolicy((fieldInfo, fieldValue) -> {

            // 忽略 null 值.
            if (ignoreNullValue) {
                if (fieldValue == null) {
                    return RecordComponentWriteResult.ofSkip();
                }
            }

            if (useAnnotations) {
                // 忽略 SerializeIgnore 注解
                var annotation = fieldInfo.findAnnotation(Ignore.class);
                if (annotation != null) {

                    if (annotation.value() == Ignore.Mode.SERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                        return RecordComponentWriteResult.ofSkip();
                    }

                }
            }

            return null;

        }));

        result.addMapperOptions(new MapNodeMapperOptions().ignoreNullValue(ignoreNullValue));

        return result;
    }

    public static DefaultObjectNodeConvertOptions resolve(NodeToObjectOptions options) {
        var result = new DefaultObjectNodeConvertOptions();

        var useAnnotations = options.useAnnotations();

        result.addMapperOptions(new BeanNodeMapperOptions().beanFieldReadPolicy((fieldInfo) -> {

            if (useAnnotations) {
                // 忽略 SerializeIgnore 注解
                var annotation = fieldInfo.findAnnotation(Ignore.class);
                if (annotation != null) {
                    if (annotation.value() == Ignore.Mode.DESERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                        return BeanFieldReadResult.ofSkip();
                    }
                }
            }

            return null;
        }));

        result.addMapperOptions(new RecordNodeMapperOptions().recordParameterReadPolicy((parameterInfo) -> {

            if (useAnnotations) {
                // 忽略 SerializeIgnore 注解
                var annotation = parameterInfo.findAnnotation(Ignore.class);
                if (annotation != null) {
                    if (annotation.value() == Ignore.Mode.DESERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                        return RecordParameterReadResult.ofSkip();
                    }
                }
            }

            return null;

        }));

        return result;
    }

    public static JsonNodeConvertOptions resolve(FromJsonOptions options) {
        // 我们其实没有什么需要设置的.
        return new JsonNodeConvertOptions();
    }

    public static JsonNodeConvertOptions resolve(ToJsonOptions options) {
        var result = new JsonNodeConvertOptions();
        result.prettyPrint(options.prettyPrint());
        return result;
    }

    public static XmlNodeConverterOptions resolve(FromXmlOptions options) {
        // 我们其实没有什么需要设置的.
        return new XmlNodeConverterOptions();
    }

    public static XmlNodeConverterOptions resolve(ToXmlOptions options) {
        // 我们其实没有什么需要设置的.
        return new XmlNodeConverterOptions();
    }

}
