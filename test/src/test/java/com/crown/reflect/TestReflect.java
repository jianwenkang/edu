package com.crown.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 17:24
 * @Version 1.0
 */
public class TestReflect {

    @Test
    public void test() throws Exception {
        Class<?> aClass = Class.forName("com.crown.test.annotation.Demo");
        Annotation[] annotations = aClass.getAnnotations();
        List<Annotation> annotations1 = Arrays.asList(annotations);
        annotations1.forEach( ll -> {
            System.out.println(ll);
        } );

        Field[] fields = aClass.getDeclaredFields();
        Annotation[] annotatedType = fields[0].getAnnotations();
        Arrays.asList(annotatedType).forEach( ll -> {
            System.out.println(ll);
        } );
        Method[] methods = aClass.getDeclaredMethods();
        Annotation[] annotations2 = methods[0].getAnnotations();
        Arrays.asList(annotations2).forEach( ll -> {
            System.out.println(ll);
        } );
        Annotation[][] parameterAnnotations = methods[0].getParameterAnnotations();
        System.out.println(parameterAnnotations[0][0]);
    }
}
