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

import static dev.scx.serialize.Serializer.DEFAULT_SERIALIZER;

/// ScxSerialize
///
/// @author scx567888
public final class ScxSerialize {

    public static Serializer serializer() {
        return DEFAULT_SERIALIZER;
    }

    // ********************** XXXConverter **************************

    public static DefaultObjectNodeConverter objectNodeConverter() {
        return DEFAULT_SERIALIZER.objectNodeConverter();
    }

    public static JsonNodeConverter jsonNodeConverter() {
        return DEFAULT_SERIALIZER.jsonNodeConverter();
    }

    public static XmlNodeConverter xmlNodeConverter() {
        return DEFAULT_SERIALIZER.xmlNodeConverter();
    }

    // ********************** objectToNode **************************

    public static Node objectToNode(Object value, SerializeOptions options) throws ObjectToNodeException {
        return DEFAULT_SERIALIZER.objectToNode(value, options);
    }

    public static Node objectToNode(Object value) throws ObjectToNodeException {
        return DEFAULT_SERIALIZER.objectToNode(value);
    }

    // ********************** nodeToObject **************************

    public static <T> T nodeToObject(Node node, TypeInfo type, SerializeOptions options) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type, options);
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type, SerializeOptions options) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type, options);
    }

    public static <T> T nodeToObject(Node node, Class<T> type, SerializeOptions options) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type, options);
    }

    public static <T> T nodeToObject(Node node, TypeInfo type) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type);
    }

    public static <T> T nodeToObject(Node node, TypeReference<T> type) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type);
    }

    public static <T> T nodeToObject(Node node, Class<T> type) throws NodeToObjectException {
        return DEFAULT_SERIALIZER.nodeToObject(node, type);
    }

    // ********************** convertObject **************************

    public static <T> T convertObject(Object value, TypeInfo type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type, options);
    }

    public static <T> T convertObject(Object value, TypeReference<T> type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type, options);
    }

    public static <T> T convertObject(Object value, Class<T> type, SerializeOptions options) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type, options);
    }

    public static <T> T convertObject(Object value, TypeInfo type) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type);
    }

    public static <T> T convertObject(Object value, TypeReference<T> type) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type);
    }

    public static <T> T convertObject(Object value, Class<T> type) throws ObjectToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.convertObject(value, type);
    }

    // ********************** fromJson(Node) **************************

    public static Node fromJson(String json, SerializeOptions options) throws FormatToNodeException {
        return DEFAULT_SERIALIZER.fromJson(json, options);
    }

    public static Node fromJson(File file, SerializeOptions options) throws FormatToNodeException, IOException {
        return DEFAULT_SERIALIZER.fromJson(file, options);
    }

    public static Node fromJson(String json) throws FormatToNodeException {
        return DEFAULT_SERIALIZER.fromJson(json);
    }

    public static Node fromJson(File file) throws FormatToNodeException, IOException {
        return DEFAULT_SERIALIZER.fromJson(file);
    }

    // ********************** toJson(Node) **************************

    public static String toJson(Node node, SerializeOptions options) throws NodeToFormatException {
        return DEFAULT_SERIALIZER.toJson(node, options);
    }

    public static String toJson(Node node) throws NodeToFormatException {
        return DEFAULT_SERIALIZER.toJson(node);
    }

    // ********************** fromXml(Node) **************************

    public static Node fromXml(String xml, SerializeOptions options) throws FormatToNodeException {
        return DEFAULT_SERIALIZER.fromXml(xml, options);
    }

    public static Node fromXml(File file, SerializeOptions options) throws FormatToNodeException, IOException {
        return DEFAULT_SERIALIZER.fromXml(file, options);
    }

    public static Node fromXml(String xml) throws FormatToNodeException {
        return DEFAULT_SERIALIZER.fromXml(xml);
    }

    public static Node fromXml(File file) throws FormatToNodeException, IOException {
        return DEFAULT_SERIALIZER.fromXml(file);
    }

    // ********************** toXml(Node) **************************

    public static String toXml(Node node, SerializeOptions options) throws NodeToFormatException {
        return DEFAULT_SERIALIZER.toXml(node, options);
    }

    public static String toXml(Node node) throws NodeToFormatException {
        return DEFAULT_SERIALIZER.toXml(node);
    }

    // ********************** fromJson(Any) **************************

    public static <T> T fromJson(String json, TypeInfo type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type, options);
    }

    public static <T> T fromJson(File file, TypeInfo type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type, options);
    }

    public static <T> T fromJson(String json, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type, options);
    }

    public static <T> T fromJson(File file, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type, options);
    }

    public static <T> T fromJson(String json, Class<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type, options);
    }

    public static <T> T fromJson(File file, Class<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type, options);
    }

    public static <T> T fromJson(String json, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type);
    }

    public static <T> T fromJson(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type);
    }

    public static <T> T fromJson(String json, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type);
    }

    public static <T> T fromJson(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type);
    }

    public static <T> T fromJson(String json, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(json, type);
    }

    public static <T> T fromJson(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromJson(file, type);
    }

    // ********************** toJson(Any) **************************

    public static String toJson(Object object, SerializeOptions options) throws ObjectToNodeException, NodeToFormatException {
        return DEFAULT_SERIALIZER.toJson(object, options);
    }

    public static String toJson(Object object) throws ObjectToNodeException, NodeToFormatException {
        return DEFAULT_SERIALIZER.toJson(object);
    }

    // ********************** fromXml(Any) **************************

    public static <T> T fromXml(String xml, TypeInfo type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type, options);
    }

    public static <T> T fromXml(File file, TypeInfo type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type, options);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type, options);
    }

    public static <T> T fromXml(File file, TypeReference<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type, options);
    }

    public static <T> T fromXml(String xml, Class<T> type, SerializeOptions options) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type, options);
    }

    public static <T> T fromXml(File file, Class<T> type, SerializeOptions options) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type, options);
    }

    public static <T> T fromXml(String xml, TypeInfo type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type);
    }

    public static <T> T fromXml(File file, TypeInfo type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type);
    }

    public static <T> T fromXml(String xml, TypeReference<T> type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type);
    }

    public static <T> T fromXml(File file, TypeReference<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type);
    }

    public static <T> T fromXml(String xml, Class<T> type) throws FormatToNodeException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(xml, type);
    }

    public static <T> T fromXml(File file, Class<T> type) throws FormatToNodeException, IOException, NodeToObjectException {
        return DEFAULT_SERIALIZER.fromXml(file, type);
    }

    // ********************** toXml(Any) **************************

    public static String toXml(Object object, SerializeOptions options) throws ObjectToNodeException, NodeToFormatException {
        return DEFAULT_SERIALIZER.toXml(object, options);
    }

    public static String toXml(Object object) throws ObjectToNodeException, NodeToFormatException {
        return DEFAULT_SERIALIZER.toXml(object);
    }

}
