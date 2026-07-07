package dev.scx.serialize;

import dev.scx.format.json.JsonNodeConvertOptions;
import dev.scx.format.xml.XmlNodeConvertOptions;
import dev.scx.object.x.DefaultObjectNodeConvertOptions;

/// SerializeOptions
///
/// @author scx567888
public interface SerializeOptions {

    DefaultObjectNodeConvertOptions objectNodeConvertOptions();

    JsonNodeConvertOptions jsonNodeConvertOptions();

    XmlNodeConvertOptions xmlNodeConvertOptions();

}
