package com.annotationtest.aspect;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类(接口描述信息)
 *
 * @author DaiHaijiao
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceParam {

    /**
     * 方法描述:参数名称
     *
     * @return String
     */
    String name() default "";

    /**
     * 方法描述:参数说明
     *
     * @return String
     */
    String desc() default "";

}

