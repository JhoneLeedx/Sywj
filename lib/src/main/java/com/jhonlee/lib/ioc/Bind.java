package com.jhonlee.lib.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Bind {
    int value();
}
