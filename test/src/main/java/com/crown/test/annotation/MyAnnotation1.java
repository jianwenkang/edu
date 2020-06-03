package com.crown.test.annotation;

import java.lang.annotation.*;

/**
 * @ClassName MyAnnotation
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 15:34
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented()
@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
public @interface MyAnnotation1 {
}
