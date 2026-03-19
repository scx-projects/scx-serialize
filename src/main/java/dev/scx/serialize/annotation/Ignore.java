package dev.scx.serialize.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Ignore
///
/// @author scx567888
/// @version 0.0.1
@Target({ElementType.FIELD, ElementType.RECORD_COMPONENT, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {

    Mode value() default Mode.BOTH;

    enum Mode {
        BOTH,
        SERIALIZE,
        DESERIALIZE
    }

}
