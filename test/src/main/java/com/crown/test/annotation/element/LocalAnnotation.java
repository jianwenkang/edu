package com.crown.test.annotation.element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName TYPE
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 15:59
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
public @interface LocalAnnotation {
}
