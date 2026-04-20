package dev.scx.serialize;

import dev.scx.object.x.mapper.NumberConversionPolicy;
import dev.scx.object.x.mapper.primitive.PrimitiveNullPolicy;

public class FromXmlOptions extends NodeToObjectOptions {

    @Override
    public FromXmlOptions useAnnotations(boolean useAnnotations) {
        return (FromXmlOptions) super.useAnnotations(useAnnotations);
    }

    @Override
    public FromXmlOptions numberConversionPolicy(NumberConversionPolicy numberConversionPolicy) {
        return (FromXmlOptions) super.numberConversionPolicy(numberConversionPolicy);
    }

    @Override
    public FromXmlOptions primitiveNullPolicy(PrimitiveNullPolicy primitiveNullPolicy) {
        return (FromXmlOptions) super.primitiveNullPolicy(primitiveNullPolicy);
    }

    @Override
    public FromXmlOptions singleValueArrayCompatibility(boolean singleValueArrayCompatibility) {
        return (FromXmlOptions) super.singleValueArrayCompatibility(singleValueArrayCompatibility);
    }

}
