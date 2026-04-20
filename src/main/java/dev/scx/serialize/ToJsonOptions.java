package dev.scx.serialize;

public class ToJsonOptions extends ObjectToNodeOptions {

    private boolean prettyPrint;

    public ToJsonOptions() {
        this.prettyPrint = false;
    }

    public boolean prettyPrint() {
        return prettyPrint;
    }

    public ToJsonOptions prettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }

    @Override
    public ToJsonOptions ignoreNullValue(boolean ignoreNullValue) {
        return (ToJsonOptions) super.ignoreNullValue(ignoreNullValue);
    }

    @Override
    public ToJsonOptions useAnnotations(boolean useAnnotations) {
        return (ToJsonOptions) super.useAnnotations(useAnnotations);
    }

}
