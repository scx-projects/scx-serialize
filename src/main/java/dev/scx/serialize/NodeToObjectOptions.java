package dev.scx.serialize;

public class NodeToObjectOptions {

    private boolean useAnnotations;

    public NodeToObjectOptions() {
        this.useAnnotations = true;
    }

    public boolean useAnnotations() {
        return this.useAnnotations;
    }

    public NodeToObjectOptions useAnnotations(boolean useAnnotations) {
        this.useAnnotations = useAnnotations;
        return this;
    }

}
