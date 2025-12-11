package dev.scx.serialize.test;

import dev.scx.serialize.ScxSerialize;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ScxSerializeTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    @Test
    public static void test1() {
        String json = ScxSerialize.toJson("123");
        String xml = ScxSerialize.toXml("123");
        Integer i = ScxSerialize.fromJson(json, int.class);
        Integer i1 = ScxSerialize.fromXml(xml, int.class);
        System.out.println(json);
        System.out.println(xml);
        System.out.println(i);
        System.out.println(i1);
    }

    @Test
    public static void test2() {
        String json = ScxSerialize.toJson(List.of("123", 456));
        var i = ScxSerialize.fromJson(json, int[].class);
        System.out.println(json);
        System.out.println(Arrays.toString(i));
    }

}
