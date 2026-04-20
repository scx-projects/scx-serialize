package dev.scx.serialize;

import dev.scx.object.x.mapper.NumberConversionPolicy;
import dev.scx.object.x.mapper.primitive.PrimitiveNullPolicy;

public class FromJsonOptions extends NodeToObjectOptions {

    @Override
    public FromJsonOptions useAnnotations(boolean useAnnotations) {
        return (FromJsonOptions) super.useAnnotations(useAnnotations);
    }

    @Override
    public FromJsonOptions numberConversionPolicy(NumberConversionPolicy numberConversionPolicy) {
        return (FromJsonOptions) super.numberConversionPolicy(numberConversionPolicy);
    }

    @Override
    public FromJsonOptions primitiveNullPolicy(PrimitiveNullPolicy primitiveNullPolicy) {
        return (FromJsonOptions) super.primitiveNullPolicy(primitiveNullPolicy);
    }

    @Override
    public FromJsonOptions singleValueArrayCompatibility(boolean singleValueArrayCompatibility) {
        return (FromJsonOptions) super.singleValueArrayCompatibility(singleValueArrayCompatibility);
    }

}
