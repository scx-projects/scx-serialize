package dev.scx.serialize;

import dev.scx.format.FormatToNodeException;
import dev.scx.format.NodeToFormatException;
import dev.scx.format.json.JsonNodeConverter;
import dev.scx.format.xml.XmlNodeConverter;
import dev.scx.node.Node;
import dev.scx.object.DefaultObjectNodeConverter;
import dev.scx.object.ObjectNodeConvertException;
import dev.scx.reflect.TypeInfo;
import dev.scx.reflect.TypeReference;

import java.io.File;
import java.io.IOException;

import static dev.scx.reflect.ScxReflect.typeOf;

/// ScxSerialize
///
/// @author scx567888
/// @version 0.0.1
public final class ScxSerialize {

    public static final DefaultObjectNodeConverter OBJECT_NODE_CONVERTER;
    public static final JsonNodeConverter JSON_NODE_CONVERTER;
    public static final XmlNodeConverter XML_NODE_CONVERTER;
    private static final ScxSerializeOptions DEFAULT_SCX_SERIALIZE_OPTIONS;

    static {
        OBJECT_NODE_CONVERTER = new DefaultObjectNodeConverter();
        JSON_NODE_CONVERTER = new JsonNodeConverter();
        XML_NODE_CONVERTER = new XmlNodeConverter();
        DEFAULT_SCX_SERIALIZE_OPTIONS = new ScxSerializeOptions();
    }

    //********************** objectToNode **************************

    public static Node objectToNode(Object value, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return OBJECT_NODE_CONVERTER.objectToNode(value, options.objectNodeConvertOptions());
    }

    public static Node objectToNode(Object value) throws ObjectNodeConvertException {
        return objectToNode(value, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** nodeToObject **************************

    public static <T> T nodeToObject(Node node, TypeInfo type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return OBJECT_NODE_CONVERTER.nodeToObject(node, type, options.objectNodeConvertOptions());
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return nodeToObject(node, typeOf(type), options);
    }

    public static <T> T nodeToObject(Node node, Class<T> type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return nodeToObject(node, typeOf(type), options);
    }

    public static <T> T nodeToObject(Node node, TypeInfo type) throws ObjectNodeConvertException {
        return nodeToObject(node, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type) throws ObjectNodeConvertException {
        return nodeToObject(node, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T nodeToObject(Node node, Class<T> type) throws ObjectNodeConvertException {
        return nodeToObject(node, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** convertObject **************************

    public static <T> T convertObject(Object value, TypeInfo type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        var node = objectToNode(value, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T convertObject(Object value, TypeReference<T> type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return convertObject(value, typeOf(type), options);
    }

    public static <T> T convertObject(Object value, Class<T> type, ScxSerializeOptions options) throws ObjectNodeConvertException {
        return convertObject(value, typeOf(type), options);
    }

    public static <T> T convertObject(Object value, TypeInfo type) throws ObjectNodeConvertException {
        return convertObject(value, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T convertObject(Object value, TypeReference<T> type) throws ObjectNodeConvertException {
        return convertObject(value, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T convertObject(Object value, Class<T> type) throws ObjectNodeConvertException {
        return convertObject(value, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** fromJson(Node) **************************

    public static Node fromJson(String json, ScxSerializeOptions options) throws FormatToNodeException {
        return JSON_NODE_CONVERTER.formatToNode(json, options.jsonNodeConvertOptions());
    }

    public static Node fromJson(File file, ScxSerializeOptions options) throws FormatToNodeException, IOException {
        return JSON_NODE_CONVERTER.formatToNode(file, null, options.jsonNodeConvertOptions());
    }

    public static Node fromJson(String json) throws FormatToNodeException {
        return fromJson(json, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static Node fromJson(File file) throws FormatToNodeException, IOException {
        return fromJson(file, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** toJson(Node) **************************

    public static String toJson(Node node, ScxSerializeOptions options) throws NodeToFormatException {
        return JSON_NODE_CONVERTER.nodeToFormatString(node, options.jsonNodeConvertOptions());
    }

    public static String toJson(Node node) throws NodeToFormatException {
        return toJson(node, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** fromXml(Node) **************************

    public static Node fromXml(String xml, ScxSerializeOptions options) throws FormatToNodeException {
        return XML_NODE_CONVERTER.formatToNode(xml, options.xmlNodeConverterOptions());
    }

    public static Node fromXml(File file, ScxSerializeOptions options) throws FormatToNodeException, IOException {
        return XML_NODE_CONVERTER.formatToNode(file, null, options.xmlNodeConverterOptions());
    }

    public static Node fromXml(String xml) throws FormatToNodeException {
        return fromXml(xml, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static Node fromXml(File file) throws FormatToNodeException, IOException {
        return fromXml(file, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** toXml(Node) **************************

    public static String toXml(Node node, ScxSerializeOptions options) throws NodeToFormatException {
        return XML_NODE_CONVERTER.nodeToFormatString(node, options.xmlNodeConverterOptions());
    }

    public static String toXml(Node node) throws NodeToFormatException {
        return toXml(node, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** fromJson(Any) **************************

    public static <T> T fromJson(String json, TypeInfo type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        var node = fromJson(json, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(File file, TypeInfo type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        var node = fromJson(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromJson(String json, TypeReference<T> type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        return fromJson(json, typeOf(type), options);
    }

    public static <T> T fromJson(File file, TypeReference<T> type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromJson(file, typeOf(type), options);
    }

    public static <T> T fromJson(String json, Class<T> type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        return fromJson(json, typeOf(type), options);
    }

    public static <T> T fromJson(File file, Class<T> type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromJson(file, typeOf(type), options);
    }

    public static <T> T fromJson(String json, TypeInfo type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromJson(json, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromJson(File file, TypeInfo type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromJson(file, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromJson(String json, TypeReference<T> type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromJson(json, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromJson(File file, TypeReference<T> type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromJson(file, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromJson(String json, Class<T> type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromJson(json, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromJson(File file, Class<T> type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromJson(file, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** toJson(Any) **************************

    public static String toJson(Object object, ScxSerializeOptions options) throws ObjectNodeConvertException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toJson(node, options);
    }

    public static String toJson(Object object) throws ObjectNodeConvertException, NodeToFormatException {
        return toJson(object, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** fromXml(Any) **************************

    public static <T> T fromXml(String xml, TypeInfo type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        var node = fromXml(xml, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(File file, TypeInfo type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        var node = fromXml(file, options);
        return nodeToObject(node, type, options);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        return fromXml(xml, typeOf(type), options);
    }

    public static <T> T fromXml(File file, TypeReference<T> type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromXml(file, typeOf(type), options);
    }

    public static <T> T fromXml(String xml, Class<T> type, ScxSerializeOptions options) throws FormatToNodeException, ObjectNodeConvertException {
        return fromXml(xml, typeOf(type), options);
    }

    public static <T> T fromXml(File file, Class<T> type, ScxSerializeOptions options) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromXml(file, typeOf(type), options);
    }

    public static <T> T fromXml(String xml, TypeInfo type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromXml(xml, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromXml(File file, TypeInfo type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromXml(file, type, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromXml(xml, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromXml(File file, TypeReference<T> type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromXml(file, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromXml(String xml, Class<T> type) throws FormatToNodeException, ObjectNodeConvertException {
        return fromXml(xml, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    public static <T> T fromXml(File file, Class<T> type) throws FormatToNodeException, IOException, ObjectNodeConvertException {
        return fromXml(file, typeOf(type), DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

    //********************** toXml(Any) **************************

    public static String toXml(Object object, ScxSerializeOptions options) throws ObjectNodeConvertException, NodeToFormatException {
        var node = objectToNode(object, options);
        return toXml(node, options);
    }

    public static String toXml(Object object) throws ObjectNodeConvertException, NodeToFormatException {
        return toXml(object, DEFAULT_SCX_SERIALIZE_OPTIONS);
    }

}
