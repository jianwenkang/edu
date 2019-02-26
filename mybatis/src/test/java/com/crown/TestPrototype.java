package com.crown;

import com.crown.entity.Student;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crown on 2018/12/21.
 */
public class TestPrototype {

    public static void main(String[] args) throws Exception {
        final Map<String, Object> map = new HashMap<>();
        Class<?> studentClass = Class.forName("com.crown.entity.Student");
        final Student student = (Student) studentClass.newInstance();
        Field[] declaredFields = studentClass.getDeclaredFields();

        for (Field field: declaredFields
             ) {
            field.setAccessible(true);
            Object o1 = field.get(student);
            System.out.println(o1);
            field.set(student,o1);
        }

    }
}
