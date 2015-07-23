package com.netease.esp.ecos.mainsite.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 防止重复提交注解，用于方法上
 * 在新建页面方法上，设置needSaveToken()为true，此时拦截器会在Session中保存一个token，
 * 同时需要在新建的页面中添加
 * <input type="hidden" name="submittoken" value="${submittoken}">
 * 保存方法需要验证重复提交的，设置needRemoveToken为true
 * 此时会在拦截器中验证是否重复提交
 * @author http://my.oschina.net/mushui/blog/143397
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleSubmitSession {
	boolean needSaveToken() default false;
    boolean needRemoveToken() default false;
}
