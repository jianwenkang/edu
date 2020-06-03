
package com.crown.test.annotation;

import com.crown.test.annotation.element.*;

/**
 * @ClassName demo
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 16:15
 * @Version 1.0
 */
@TypeAnnotation
public class Demo {

    @ConstructorAnnotation
    public Demo() {
    }

    @FieledAnnotation
    private String name;

    @MethodAnnotation
    public @TypeAnnotation String getString(@ParameterAnnotation String string,@ParameterAnnotation String str){
        @LocalAnnotation
        String name;
        return string;
    }
}
