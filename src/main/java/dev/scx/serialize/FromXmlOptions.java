package dev.scx.serialize;

public class FromXmlOptions extends NodeToObjectOptions {

    @Override
    public FromXmlOptions useAnnotations(boolean useAnnotations) {
        return (FromXmlOptions) super.useAnnotations(useAnnotations);
    }

}
