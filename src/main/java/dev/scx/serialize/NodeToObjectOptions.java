package dev.scx.serialize;

import dev.scx.object.x.mapper.NumberConversionPolicy;
import dev.scx.object.x.mapper.primitive.PrimitiveNullPolicy;

public class NodeToObjectOptions {

    private boolean useAnnotations;
    private NumberConversionPolicy numberConversionPolicy;
    private PrimitiveNullPolicy primitiveNullPolicy;
    private boolean singleValueArrayCompatibility;

    public NodeToObjectOptions() {
        this.useAnnotations = true;
        this.numberConversionPolicy = NumberConversionPolicy.DEFAULT;
        this.primitiveNullPolicy = PrimitiveNullPolicy.ERROR;
        this.singleValueArrayCompatibility = false;
    }

    public boolean useAnnotations() {
        return this.useAnnotations;
    }

    public NodeToObjectOptions useAnnotations(boolean useAnnotations) {
        this.useAnnotations = useAnnotations;
        return this;
    }

    public NumberConversionPolicy numberConversionPolicy() {
        return numberConversionPolicy;
    }

    public NodeToObjectOptions numberConversionPolicy(NumberConversionPolicy numberConversionPolicy) {
        this.numberConversionPolicy = numberConversionPolicy;
        return this;
    }

    public PrimitiveNullPolicy primitiveNullPolicy() {
        return primitiveNullPolicy;
    }

    public NodeToObjectOptions primitiveNullPolicy(PrimitiveNullPolicy primitiveNullPolicy) {
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
    public NodeToObjectOptions singleValueArrayCompatibility(boolean singleValueArrayCompatibility) {
        this.singleValueArrayCompatibility = singleValueArrayCompatibility;
        return this;
    }

}
