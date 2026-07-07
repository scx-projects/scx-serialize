package dev.scx.serialize.test;

import dev.scx.serialize.annotation.Ignore;

public record Student(
    String name,
    @Ignore
    String password,
    Integer age
) {

}
