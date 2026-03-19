package dev.scx.serialize.test;

import dev.scx.serialize.FromJsonOptions;
import dev.scx.serialize.ScxSerialize;
import dev.scx.serialize.ToJsonOptions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ScxSerializeTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
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

    @Test
    public static void test3() {
        var user = new User();
        user.name = "jack";
        user.password = "123456";
        user.age = null;
        String json = ScxSerialize.toJson(user, new ToJsonOptions().prettyPrint(true).ignoreNullValue(true));
        System.out.println(json);

        var student = new Student("jack", "123456", null);
        String json2 = ScxSerialize.toJson(student, new ToJsonOptions().prettyPrint(true).ignoreNullValue(true));
        System.out.println(json2);

        var map = new LinkedHashMap<>();
        map.put("name", "jack");
        map.put("age", null);
        String json3 = ScxSerialize.toJson(map, new ToJsonOptions().prettyPrint(true).ignoreNullValue(true));
        System.out.println(json3);

        var student2 = new Student("jack", "123456", null);
        String json4 = ScxSerialize.toJson(student2, new ToJsonOptions().prettyPrint(true).useAnnotations(false));
        System.out.println(json4);


        Student student3 = ScxSerialize.fromJson(json4, Student.class, new FromJsonOptions().useAnnotations(false));
        System.out.println(student3);

        Student student4 = ScxSerialize.fromJson(json4, Student.class, new FromJsonOptions().useAnnotations(true));
        System.out.println(student4);

        User user1 = ScxSerialize.fromJson(json4, User.class);
        System.out.println(user1);

    }

}
