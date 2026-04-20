package dev.scx.serialize;

public class ConvertObjectOptions {

    private final ObjectToNodeOptions objectToNodeOptions;
    private final NodeToObjectOptions nodeToObjectOptions;

    public ConvertObjectOptions() {
        this.objectToNodeOptions = new ObjectToNodeOptions();
        this.nodeToObjectOptions = new NodeToObjectOptions();
    }

    public ObjectToNodeOptions objectToNodeOptions() {
        return objectToNodeOptions;
    }

    public NodeToObjectOptions nodeToObjectOptions() {
        return nodeToObjectOptions;
    }

}
