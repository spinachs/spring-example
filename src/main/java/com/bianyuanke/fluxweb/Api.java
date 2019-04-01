package com.bianyuanke.fluxweb;

import java.lang.annotation.*;

/**
 * @author 马良
 * @since 2019-03-26
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Api {
    String verify() default "";
}
