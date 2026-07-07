package dev.scx.serialize.test;

import dev.scx.serialize.annotation.Ignore;

import static dev.scx.serialize.annotation.Ignore.Mode.SERIALIZE;

public class User {

    public String name;

    @Ignore(SERIALIZE)
    public String password;

    public Integer age;

}
