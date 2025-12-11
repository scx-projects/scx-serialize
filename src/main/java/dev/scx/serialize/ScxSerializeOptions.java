package dev.scx.serialize;

import dev.scx.format.json.JsonNodeConvertOptions;
import dev.scx.format.xml.XmlNodeConverterOptions;
import dev.scx.object.DefaultObjectNodeConvertOptions;

public class ScxSerializeOptions {

    private final DefaultObjectNodeConvertOptions objectNodeConvertOptions;
    private final JsonNodeConvertOptions jsonNodeConvertOptions;
    private final XmlNodeConverterOptions xmlNodeConverterOptions;

    public ScxSerializeOptions() {
        this.objectNodeConvertOptions = new DefaultObjectNodeConvertOptions();
        this.jsonNodeConvertOptions = new JsonNodeConvertOptions();
        this.xmlNodeConverterOptions = new XmlNodeConverterOptions();
    }

    public DefaultObjectNodeConvertOptions objectNodeConvertOptions() {
        return objectNodeConvertOptions;
    }

    public JsonNodeConvertOptions jsonNodeConvertOptions() {
        return jsonNodeConvertOptions;
    }

    public XmlNodeConverterOptions xmlNodeConverterOptions() {
        return xmlNodeConverterOptions;
    }

}
