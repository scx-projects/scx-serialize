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

import static dev.scx.reflect.ScxReflect.typeOf;
import static dev.scx.serialize.OptionsResolver.resolve;

/// ScxSerialize
///
/// @author scx567888
/// @version 0.0.1
public final class ScxSerialize {

    private static final DefaultObjectNodeConverter OBJECT_NODE_CONVERTER;
    private static final JsonNodeConverter JSON_NODE_CONVERTER;
    private static final XmlNodeConverter XML_NODE_CONVERTER;
    private static final ObjectToNodeOptions DEFAULT_OBJECT_TO_NODE_OPTIONS;
    private static final NodeToObjectOptions DEFAULT_NODE_TO_OBJECT_OPTIONS;
    private static final ConvertObjectOptions DEFAULT_CONVERT_OBJECT_OPTIONS;
    private static final FromJsonOptions DEFAULT_FROM_JSON_OPTIONS;
    private static final ToJsonOptions DEFAULT_TO_JSON_OPTIONS;
    private static final FromXmlOptions DEFAULT_FROM_XML_OPTIONS;
    private static final ToXmlOptions DEFAULT_TO_XML_OPTIONS;

    static {
        OBJECT_NODE_CONVERTER = new DefaultObjectNodeConverter();
        JSON_NODE_CONVERTER = new JsonNodeConverter();
        XML_NODE_CONVERTER = new XmlNodeConverter();
        DEFAULT_OBJECT_TO_NODE_OPTIONS = new ObjectToNodeOptions();
        DEFAULT_NODE_TO_OBJECT_OPTIONS = new NodeToObjectOptions();
        DEFAULT_CONVERT_OBJECT_OPTIONS = new ConvertObjectOptions();
        DEFAULT_FROM_JSON_OPTIONS = new FromJsonOptions();
        DEFAULT_TO_JSON_OPTIONS = new ToJsonOptions();
        DEFAULT_FROM_XML_OPTIONS = new FromXmlOptions();
        DEFAULT_TO_XML_OPTIONS = new ToXmlOptions();
    }

    //********************** XXXConverter **************************

    public static DefaultObjectNodeConverter objectNodeConverter() {
        return OBJECT_NODE_CONVERTER;
    }

    public static JsonNodeConverter jsonNodeConverter() {
        return JSON_NODE_CONVERTER;
    }

    public static XmlNodeConverter xmlNodeConverter() {
        return XML_NODE_CONVERTER;
    }

    //********************** objectToNode **************************

    public static Node objectToNode(Object value, ObjectToNodeOptions options) throws ObjectToNodeException {
        return OBJECT_NODE_CONVERTER.objectToNode(value, resolve(options));
    }

    public static Node objectToNode(Object value) throws ObjectToNodeException {
        return objectToNode(value, DEFAULT_OBJECT_TO_NODE_OPTIONS);
    }

    //********************** nodeToObject **************************

    public static <T> T nodeToObject(Node node, TypeInfo type, NodeToObjectOptions options) throws NodeToObjectException {
        return OBJECT_NODE_CONVERTER.nodeToObject(node, type, resolve(options));
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type, NodeToObjectOptions options) throws NodeToObjectException {
        return nodeToObject(node, typeOf(type), options);
    }

    public static <T> T nodeToObject(Node node, Class<T> type, NodeToObjectOptions options) throws NodeToObjectException {
        return OBJECT_NODE_CONVERTER.nodeToObject(node, type, resolve(options));
    }

    public static <T> T nodeToObject(Node node, TypeInfo type) throws NodeToObjectException {
        return nodeToObject(node, type, DEFAULT_NODE_TO_OBJECT_OPTIONS);
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type) throws NodeToObjectException {
        return nodeToObject(node, typeOf(type), DEFAULT_NODE_TO_OBJECT_OPTIONS);
    }

    public static <T> T nodeToObject(Node node, Class<T> type) throws NodeToObjectException {
        return nodeToObject(node, type, DEFAULT_NODE_TO_OBJECT_OPTIONS);
    }

    //********************** convertObject **************************

    public static <T> T convertObject(Object value, TypeInfo type, ConvertObjectOptions options) throws ObjectToNodeException, NodeToObjectException {
        var node = objectToNode(value, options.objectToNodeOptions());
        return nodeToObject(node, type, options.nodeToObjectOptions());
    }

    public static <T> T convertObject(Object value, TypeReference<T> type, ConvertObjectOptions options) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, typeOf(type), options);
    }

    public static <T> T convertObject(Object value, Class<T> type, ConvertObjectOptions options) throws ObjectToNodeException, NodeToObjectException {
        var node = objectToNode(value, options.objectToNodeOptions());
        return nodeToObject(node, type, options.nodeToObjectOptions());
    }

    public static <T> T convertObject(Object value, TypeInfo type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, type, DEFAULT_CONVERT_OBJECT_OPTIONS);
    }

    public static <T> T convertObject(Object value, TypeReference<T> type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, typeOf(type), DEFAULT_CONVERT_OBJECT_OPTIONS);
    }

    public static <T> T convertObject(Object value, Class<T> type) throws ObjectToNodeException, NodeToObjectException {
        return convertObject(value, type, DEFAULT_CONVERT_OBJECT_OPTIONS);
    }

    //********************** fromJson(Node) **************************

    public static Node fromJson(String json, FromJsonOptions options) throws FormatToNodeException {
        return JSON_NODE_CONVERTER.formatToNode(json, resolve(options));
    }

    public static Node fromJson(File file, FromJsonOptions options) throws FormatToNodeException, IOException {
        return JSON_NODE_CONVERTER.formatToNode(file, null, resolve(options));
    }

    public static Node fromJson(String json) throws FormatToNodeException {
        return fromJson(json, DEFAULT_FROM_JSON_OPTIONS);
    }

    public static Node fromJson(File file) throws FormatToNodeException, IOException {
        return fromJson(file, DEFAULT_FROM_JSON_OPTIONS);
    }

    //********************** toJson(Node) **************************

    public static String toJson(Node node, ToJsonOptions options) throws NodeToFormatException {
        return JSON_NODE_CONVERTER.nodeToFormatString(node, resolve(options));
    }

    public static String toJson(Node node) throws NodeToFormatException {
        return toJson(node, DEFAULT_TO_JSON_OPTIONS);
    }

    //********************** fromXml(Node) **************************

    public static Node fromXml(String xml, FromXmlOptions options) throws FormatToNodeException {
        return XML_NODE_CONVERTER.formatToNode(xml, resolve(options));
    }

    public static Node fromXml(File file, FromXmlOptions options) throws FormatToNodeException, IOException {
        return XML_NODE_CONVERTER.formatToNode(file, null, resolve(options));
    }

    public static Node fromXml(String xml) throws FormatToNodeException {
        return fromXml(xml, DEFAULT_FROM_XML_OPTIONS);
    }

    public static Node fromXml(File file) throws FormatToNodeException, IOException {
        return fromXml(file, DEFAULT_FROM_XML_OPTIONS);
    }

    //********************** toXml(Node) **************************

    public static String toXml(Node node, ToXmlOptions options) throws NodeToFormatException {
        return XML_NODE_CONVERTER.nodeToFormatString(node, resolve(options));
    }

    public static String toXml(Node node) throws NodeToFormatException {
        return toXml(node, DEFAULT_TO_XML_OPTIONS);
    }

    //********************** fromJson(Any) **************************

    public static <T> T fromJson(String json, TypeInfo type, FromJsonOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(File file, TypeInfo type, FromJsonOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(String json, TypeReference<T> type, FromJsonOptions options) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, typeOf(type), options);
    }

    public static <T> T fromJson(File file, TypeReference<T> type, FromJsonOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, typeOf(type), options);
    }

    public static <T> T fromJson(String json, Class<T> type, FromJsonOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(File file, Class<T> type, FromJsonOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(String json, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, type, DEFAULT_FROM_JSON_OPTIONS);
    }

    public static <T> T fromJson(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, type, DEFAULT_FROM_JSON_OPTIONS);
    }

    public static <T> T fromJson(String json, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, typeOf(type), DEFAULT_FROM_JSON_OPTIONS);
    }

    public static <T> T fromJson(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, typeOf(type), DEFAULT_FROM_JSON_OPTIONS);
    }

    public static <T> T fromJson(String json, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromJson(json, type, DEFAULT_FROM_JSON_OPTIONS);
    }

    public static <T> T fromJson(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromJson(file, type, DEFAULT_FROM_JSON_OPTIONS);
    }

    //********************** toJson(Any) **************************

    public static String toJson(Object object, ToJsonOptions options) throws ObjectToNodeException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toJson(node, options);
    }

    public static String toJson(Object object) throws ObjectToNodeException, NodeToFormatException {
        return toJson(object, DEFAULT_TO_JSON_OPTIONS);
    }

    //********************** fromXml(Any) **************************

    public static <T> T fromXml(String xml, TypeInfo type, FromXmlOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(File file, TypeInfo type, FromXmlOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type, FromXmlOptions options) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, typeOf(type), options);
    }

    public static <T> T fromXml(File file, TypeReference<T> type, FromXmlOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, typeOf(type), options);
    }

    public static <T> T fromXml(String xml, Class<T> type, FromXmlOptions options) throws FormatToNodeException, NodeToObjectException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(File file, Class<T> type, FromXmlOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(String xml, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, type, DEFAULT_FROM_XML_OPTIONS);
    }

    public static <T> T fromXml(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, type, DEFAULT_FROM_XML_OPTIONS);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, typeOf(type), DEFAULT_FROM_XML_OPTIONS);
    }

    public static <T> T fromXml(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, typeOf(type), DEFAULT_FROM_XML_OPTIONS);
    }

    public static <T> T fromXml(String xml, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return fromXml(xml, type, DEFAULT_FROM_XML_OPTIONS);
    }

    public static <T> T fromXml(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return fromXml(file, type, DEFAULT_FROM_XML_OPTIONS);
    }

    //********************** toXml(Any) **************************

    public static String toXml(Object object, ToXmlOptions options) throws ObjectToNodeException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toXml(node, options);
    }

    public static String toXml(Object object) throws ObjectToNodeException, NodeToFormatException {
        return toXml(object, DEFAULT_TO_XML_OPTIONS);
    }

}
