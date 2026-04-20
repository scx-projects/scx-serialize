package dev.scx.serialize;

public class ToXmlOptions extends ObjectToNodeOptions {

    @Override
    public ToXmlOptions ignoreNullValue(boolean ignoreNullValue) {
        return (ToXmlOptions) super.ignoreNullValue(ignoreNullValue);
    }

    @Override
    public ToXmlOptions useAnnotations(boolean useAnnotations) {
        return (ToXmlOptions) super.useAnnotations(useAnnotations);
    }

}
