package dev.scx.serialize;

import dev.scx.format.json.JsonNodeConvertConfig;
import dev.scx.format.json.JsonNodeConvertOptions;
import dev.scx.format.xml.XmlNodeConvertConfig;
import dev.scx.format.xml.XmlNodeConvertOptions;
import dev.scx.object.x.DefaultObjectNodeConvertConfig;
import dev.scx.object.x.DefaultObjectNodeConvertOptions;
import dev.scx.object.x.adapter.CompositeNodeTypeAdapter;
import dev.scx.object.x.mapper.NumberConversionPolicy;
import dev.scx.object.x.mapper.TypeNodeMapperOptions;
import dev.scx.object.x.mapper.bean.BeanFieldReadResult;
import dev.scx.object.x.mapper.bean.BeanFieldWriteResult;
import dev.scx.object.x.mapper.bean.BeanNodeMapperOptions;
import dev.scx.object.x.mapper.map.MapNodeMapperOptions;
import dev.scx.object.x.mapper.primitive.PrimitiveNullPolicy;
import dev.scx.object.x.mapper.record.RecordComponentWriteResult;
import dev.scx.object.x.mapper.record.RecordNodeMapperOptions;
import dev.scx.object.x.mapper.record.RecordParameterReadResult;
import dev.scx.serialize.annotation.Ignore;

import java.util.HashMap;
import java.util.Map;

import static dev.scx.object.x.adapter.SingleElementArrayUnwrapAdapter.SINGLE_ELEMENT_ARRAY_UNWRAP_ADAPTER;
import static dev.scx.object.x.adapter.SingleValueWrapArrayAdapter.SINGLE_VALUE_WRAP_ARRAY_ADAPTER;

/// SerializeConfig
///
/// SerializeConfig 是 SerializeOptions 的便捷实现,
/// 只暴露 日常使用的 常见配置项.
/// 如需完整控制 JSON/XML/ObjectNode 底层配置,
/// 请自行实现 SerializeOptions.
///
/// @author scx567888
public final class SerializeConfig implements SerializeOptions {

    private boolean ignoreNullValue;
    private boolean useAnnotations;
    private NumberConversionPolicy numberConversionPolicy;
    private PrimitiveNullPolicy primitiveNullPolicy;
    private boolean singleValueArrayCompatibility;
    private Map<Class<? extends TypeNodeMapperOptions>, TypeNodeMapperOptions> mapperOptionsMap;
    private boolean prettyPrint;

    public SerializeConfig() {
        this.ignoreNullValue = false;
        this.useAnnotations = true;
        this.numberConversionPolicy = NumberConversionPolicy.DEFAULT;
        this.primitiveNullPolicy = PrimitiveNullPolicy.ERROR;
        this.singleValueArrayCompatibility = false;
        this.mapperOptionsMap = null;
        this.prettyPrint = false;
    }

    public static SerializeConfig of() {
        return new SerializeConfig();
    }

    public static SerializeConfig copyOf(SerializeConfig config) {
        var newConfig = new SerializeConfig();
        newConfig.ignoreNullValue(config.ignoreNullValue());
        newConfig.useAnnotations(config.useAnnotations());
        newConfig.numberConversionPolicy(config.numberConversionPolicy());
        newConfig.primitiveNullPolicy(config.primitiveNullPolicy());
        newConfig.singleValueArrayCompatibility(config.singleValueArrayCompatibility());
        newConfig.mapperOptionsMap(config.mapperOptionsMap());
        newConfig.prettyPrint(config.prettyPrint());
        return newConfig;
    }

    public boolean ignoreNullValue() {
        return this.ignoreNullValue;
    }

    public SerializeConfig ignoreNullValue(boolean ignoreNullValue) {
        this.ignoreNullValue = ignoreNullValue;
        return this;
    }

    public boolean useAnnotations() {
        return this.useAnnotations;
    }

    public SerializeConfig useAnnotations(boolean useAnnotations) {
        this.useAnnotations = useAnnotations;
        return this;
    }

    public NumberConversionPolicy numberConversionPolicy() {
        return numberConversionPolicy;
    }

    public SerializeConfig numberConversionPolicy(NumberConversionPolicy numberConversionPolicy) {
        this.numberConversionPolicy = numberConversionPolicy;
        return this;
    }

    public PrimitiveNullPolicy primitiveNullPolicy() {
        return primitiveNullPolicy;
    }

    public SerializeConfig primitiveNullPolicy(PrimitiveNullPolicy primitiveNullPolicy) {
        this.primitiveNullPolicy = primitiveNullPolicy;
        return this;
    }

    public boolean singleValueArrayCompatibility() {
        return singleValueArrayCompatibility;
    }

    /// 是否允许单值与单元素数组之间进行兼容转换.
    /// 例如:
    /// ["a"] -> "a"
    /// "a" -> ["a"]
    public SerializeConfig singleValueArrayCompatibility(boolean singleValueArrayCompatibility) {
        this.singleValueArrayCompatibility = singleValueArrayCompatibility;
        return this;
    }

    public Map<Class<? extends TypeNodeMapperOptions>, TypeNodeMapperOptions> mapperOptionsMap() {
        return mapperOptionsMap;
    }

    public SerializeConfig mapperOptionsMap(Map<Class<? extends TypeNodeMapperOptions>, TypeNodeMapperOptions> mapperOptionsMap) {
        if (mapperOptionsMap == null) {
            this.mapperOptionsMap = null;
        } else {
            this.mapperOptionsMap = new HashMap<>(mapperOptionsMap);
        }
        return this;
    }

    public SerializeConfig putMapperOptions(TypeNodeMapperOptions... optionsList) {
        if (mapperOptionsMap == null) {
            mapperOptionsMap = new HashMap<>();
        }
        for (var o : optionsList) {
            mapperOptionsMap.put(o.getClass(), o);
        }
        return this;
    }

    public boolean prettyPrint() {
        return prettyPrint;
    }

    public SerializeConfig prettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }

    @Override
    public DefaultObjectNodeConvertOptions objectNodeConvertOptions() {
        var result = DefaultObjectNodeConvertConfig.of();

        // 创建配置快照
        var _ignoreNullValue = this.ignoreNullValue;
        var _useAnnotations = this.useAnnotations;
        var _numberConversionPolicy = this.numberConversionPolicy;
        var _primitiveNullPolicy = this.primitiveNullPolicy;
        var _singleValueArrayCompatibility = this.singleValueArrayCompatibility;
        var _mapperOptionsMap = this.mapperOptionsMap;

        // 根据快捷配置 创建 BeanNodeMapperOptions
        result.putMapperOptions(new BeanNodeMapperOptions()
            .beanFieldWritePolicy((fieldInfo, fieldValue) -> {

                // 忽略 null 值.
                if (_ignoreNullValue) {
                    if (fieldValue == null) {
                        return BeanFieldWriteResult.ofSkip();
                    }
                }

                if (_useAnnotations) {
                    // 忽略 Ignore 注解
                    var annotation = fieldInfo.findAnnotation(Ignore.class);
                    if (annotation != null) {

                        if (annotation.value() == Ignore.Mode.SERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                            return BeanFieldWriteResult.ofSkip();
                        }

                    }
                }

                return null;
            })
            .beanFieldReadPolicy((fieldInfo) -> {

                if (_useAnnotations) {
                    // 忽略 Ignore 注解
                    var annotation = fieldInfo.findAnnotation(Ignore.class);
                    if (annotation != null) {
                        if (annotation.value() == Ignore.Mode.DESERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                            return BeanFieldReadResult.ofSkip();
                        }
                    }
                }

                return null;
            }));

        // 根据快捷配置 创建 RecordNodeMapperOptions
        result.putMapperOptions(new RecordNodeMapperOptions()
            .recordComponentWritePolicy((fieldInfo, fieldValue) -> {

                // 忽略 null 值.
                if (_ignoreNullValue) {
                    if (fieldValue == null) {
                        return RecordComponentWriteResult.ofSkip();
                    }
                }

                if (_useAnnotations) {
                    // 忽略 Ignore 注解
                    var annotation = fieldInfo.findAnnotation(Ignore.class);
                    if (annotation != null) {

                        if (annotation.value() == Ignore.Mode.SERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                            return RecordComponentWriteResult.ofSkip();
                        }

                    }
                }

                return null;

            })
            .recordParameterReadPolicy((parameterInfo) -> {

                if (_useAnnotations) {
                    // 忽略 Ignore 注解
                    var annotation = parameterInfo.findAnnotation(Ignore.class);
                    if (annotation != null) {
                        if (annotation.value() == Ignore.Mode.DESERIALIZE || annotation.value() == Ignore.Mode.BOTH) {
                            return RecordParameterReadResult.ofSkip();
                        }
                    }
                }

                return null;

            }));

        result.putMapperOptions(new MapNodeMapperOptions().ignoreNullValue(_ignoreNullValue));

        result.putMapperOptions(_numberConversionPolicy);
        result.putMapperOptions(_primitiveNullPolicy);

        if (_singleValueArrayCompatibility) {
            result.nodeTypeAdapter(new CompositeNodeTypeAdapter(SINGLE_VALUE_WRAP_ARRAY_ADAPTER, SINGLE_ELEMENT_ARRAY_UNWRAP_ADAPTER));
        }

        // 最后加入 用户指定的 mapperOptionsMap
        if (_mapperOptionsMap != null) {
            for (var o : _mapperOptionsMap.values()) {
                result.putMapperOptions(o);
            }
        }

        return result;
    }

    @Override
    public JsonNodeConvertOptions jsonNodeConvertOptions() {
        var result = JsonNodeConvertConfig.of();
        result.prettyPrint(this.prettyPrint);
        return result;
    }

    @Override
    public XmlNodeConvertOptions xmlNodeConvertOptions() {
        // 关于 XML 这里其实没有什么需要设置的.
        return XmlNodeConvertConfig.of();
    }

}
