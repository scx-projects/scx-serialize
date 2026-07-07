package dev.scx.serialize;

import dev.scx.format.FormatToNodeException;
import dev.scx.format.NodeToFormatException;
import dev.scx.format.json.JsonNodeConverter;
import dev.scx.format.xml.XmlNodeConverter;
import dev.scx.node.Node;
import dev.scx.object.NodeToObjectException;
import dev.scx.object.ObjectToNodeException;
import dev.scx.object.x.DefaultObjectNodeConverter;
import dev.scx.reflect.TypeInfo;
import dev.scx.reflect.TypeReference;

import java.io.File;
import java.io.IOException;

import static dev.scx.format.json.JsonNodeConverter.DEFAULT_JSON_NODE_CONVERTER;
import static dev.scx.format.xml.XmlNodeConverter.DEFAULT_XML_NODE_CONVERTER;
import static dev.scx.object.x.DefaultObjectNodeConverter.DEFAULT_OBJECT_NODE_CONVERTER;

/// Serializer (允许继承 扩展功能)
///
/// @author scx567888
public class Serializer {

    public static final Serializer DEFAULT_SERIALIZER = new Serializer();

    // 不允许外部访问修改
    private static final SerializeOptions DEFAULT_SERIALIZE_OPTIONS;

    static {
        DEFAULT_SERIALIZE_OPTIONS = SerializeConfig.of();
    }

    private final DefaultObjectNodeConverter objectNodeConverter;
    private final JsonNodeConverter jsonNodeConverter;
    private final XmlNodeConverter xmlNodeConverter;

    public Serializer() {
        this(DEFAULT_OBJECT_NODE_CONVERTER, DEFAULT_JSON_NODE_CONVERTER, DEFAULT_XML_NODE_CONVERTER);
    }

    public Serializer(DefaultObjectNodeConverter objectNodeConverter) {
        this(objectNodeConverter, DEFAULT_JSON_NODE_CONVERTER, DEFAULT_XML_NODE_CONVERTER);
    }

    public Serializer(DefaultObjectNodeConverter objectNodeConverter, JsonNodeConverter jsonNodeConverter, XmlNodeConverter xmlNodeConverter) {
        this.objectNodeConverter = objectNodeConverter;
        this.jsonNodeConverter = jsonNodeConverter;
        this.xmlNodeConverter = xmlNodeConverter;
    }

    // ********************** XXXConverter **************************

    public DefaultObjectNodeConverter objectNodeConverter() {
        return objectNodeConverter;
    }

    public JsonNodeConverter jsonNodeConverter() {
        return jsonNodeConverter;
    }

    public XmlNodeConverter xmlNodeConverter() {
        return xmlNodeConverter;
    }

    // ********************** objectToNode **************************

    public Node objectToNode(Object value, SerializeOptions options) throws ObjectToNodeException {
        return objectNodeConverter.objectToNode(value, options.objectNodeConvertOptions());
    }

    public Node objectToNode(Object value) throws ObjectToNodeException {
        return objectToNode(value, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** nodeToObject **************************

    public <T> T nodeToObject(Node node, TypeInfo type, SerializeOptions options) throws NodeToObjectException {
        return objectNodeConverter.nodeToObject(node, type, options.objectNodeConvertOptions());
    }

    public <T> T nodeToObject(Node node, TypeReference<T> type, SerializeOptions options) throws NodeToObjectException {
        return objectNodeConverter.nodeToObject(node, type, options.objectNodeConvertOptions());
    }

    public <T> T nodeToObject(Node node, Class<T> type, SerializeOptions options) throws NodeToObjectException {
        return objectNodeConverter.nodeToObject(node, type, options.objectNodeConvertOptions());
    }

    public <T> T nodeToObject(Node node, TypeInfo type) throws NodeToObjectException {
        return nodeToObject(node, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T nodeToObject(Node node, TypeReference<T> type) throws NodeToObjectException {
        return nodeToObject(node, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T nodeToObject(Node node, Class<T> type) throws NodeToObjectException {
        return nodeToObject(node, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** convertObject **************************

    public <T> T convertObject(Object value, TypeInfo type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        var node = objectToNode(value, options);
        return nodeToObject(node, type, options);
    }

    public <T> T convertObject(Object value, TypeReference<T> type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        var node = objectToNode(value, options);
        return nodeToObject(node, type, options);
    }

    public <T> T convertObject(Object value, Class<T> type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        var node = objectToNode(value, options);
        return nodeToObject(node, type, options);
    }

    public <T> T convertObject(Object value, TypeInfo type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T convertObject(Object value, TypeReference<T> type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T convertObject(Object value, Class<T> type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** fromJson(Node) **************************

    public Node fromJson(String json, SerializeOptions options) throws FormatToNodeException {
        return jsonNodeConverter.formatToNode(json, options.jsonNodeConvertOptions());
    }

    public Node fromJson(File file, SerializeOptions options) throws FormatToNodeException, IOException {
        return jsonNodeConverter.formatToNode(file, null, options.jsonNodeConvertOptions());
    }

    public Node fromJson(String json) throws FormatToNodeException {
        return fromJson(json, DEFAULT_SERIALIZE_OPTIONS);
    }

    public Node fromJson(File file) throws FormatToNodeException, IOException {
        return fromJson(file, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** toJson(Node) **************************

    public String toJson(Node node, SerializeOptions options) throws NodeToFormatException {
        return jsonNodeConverter.nodeToFormatString(node, options.jsonNodeConvertOptions());
    }

    public String toJson(Node node) throws NodeToFormatException {
        return toJson(node, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** fromXml(Node) **************************

    public Node fromXml(String xml, SerializeOptions options) throws FormatToNodeException {
        return xmlNodeConverter.formatToNode(xml, options.xmlNodeConvertOptions());
    }

    public Node fromXml(File file, SerializeOptions options) throws FormatToNodeException, IOException {
        return xmlNodeConverter.formatToNode(file, null, options.xmlNodeConvertOptions());
    }

    public Node fromXml(String xml) throws FormatToNodeException {
        return fromXml(xml, DEFAULT_SERIALIZE_OPTIONS);
    }

    public Node fromXml(File file) throws FormatToNodeException, IOException {
        return fromXml(file, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** toXml(Node) **************************

    public String toXml(Node node, SerializeOptions options) throws NodeToFormatException {
        return xmlNodeConverter.nodeToFormatString(node, options.xmlNodeConvertOptions());
    }

    public String toXml(Node node) throws NodeToFormatException {
        return toXml(node, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** fromJson(Any) **************************

    public <T> T fromJson(String json, TypeInfo type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(File file, TypeInfo type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(String json, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(File file, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(String json, Class<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(File file, Class<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromJson(String json, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromJson(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromJson(String json, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromJson(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromJson(String json, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromJson(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** toJson(Any) **************************

    public String toJson(Object object, SerializeOptions options) throws ObjectToNodeException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toJson(node, options);
    }

    public String toJson(Object object) throws ObjectToNodeException, NodeToFormatException {
        return toJson(object, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** fromXml(Any) **************************

    public <T> T fromXml(String xml, TypeInfo type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(File file, TypeInfo type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(String xml, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(File file, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(String xml, Class<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(File file, Class<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public <T> T fromXml(String xml, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromXml(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromXml(String xml, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromXml(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromXml(String xml, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    public <T> T fromXml(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, type, DEFAULT_SERIALIZE_OPTIONS);
    }

    // ********************** toXml(Any) **************************

    public String toXml(Object object, SerializeOptions options) throws ObjectToNodeException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toXml(node, options);
    }

    public String toXml(Object object) throws ObjectToNodeException, NodeToFormatException {
        return toXml(object, DEFAULT_SERIALIZE_OPTIONS);
    }

}
