package com.parting_soul.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author parting_soul
 * @date 2019-11-18
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface ARouter {

    /**
     * 详情路由路径
     */
    String path();

    String group() default "";

}
