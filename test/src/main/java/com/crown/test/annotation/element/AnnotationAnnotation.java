package com.crown.test.annotation.element;

/**
 * @ClassName TYPE
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 15:59
 * @Version 1.0
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface AnnotationAnnotation {
}
