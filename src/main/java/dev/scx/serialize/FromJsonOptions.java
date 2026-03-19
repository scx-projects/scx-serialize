package dev.scx.serialize;

public class FromJsonOptions extends NodeToObjectOptions {

    @Override
    public FromJsonOptions useAnnotations(boolean useAnnotations) {
        return (FromJsonOptions) super.useAnnotations(useAnnotations);
    }

}
