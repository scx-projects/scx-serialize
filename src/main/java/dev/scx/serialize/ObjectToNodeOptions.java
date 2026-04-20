package dev.scx.serialize;

public class ObjectToNodeOptions {

    private boolean ignoreNullValue;
    private boolean useAnnotations;

    public ObjectToNodeOptions() {
        this.ignoreNullValue = false;
        this.useAnnotations = true;
    }

    public boolean ignoreNullValue() {
        return this.ignoreNullValue;
    }

    public ObjectToNodeOptions ignoreNullValue(boolean ignoreNullValue) {
        this.ignoreNullValue = ignoreNullValue;
        return this;
    }

    public boolean useAnnotations() {
        return this.useAnnotations;
    }

    public ObjectToNodeOptions useAnnotations(boolean useAnnotations) {
        this.useAnnotations = useAnnotations;
        return this;
    }

}
