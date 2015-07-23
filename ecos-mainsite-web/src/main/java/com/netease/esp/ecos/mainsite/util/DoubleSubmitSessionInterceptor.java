package com.netease.esp.ecos.mainsite.util;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DoubleSubmitSessionInterceptor extends HandlerInterceptorAdapter{
	private static final Logger LOG = Logger.getLogger(DoubleSubmitSessionInterceptor.class);
	static final String SUBMIT_TOKEN_NAME="SubmitToken";
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        DoubleSubmitSession annotation = method.getAnnotation(DoubleSubmitSession.class);
        if (annotation != null) {
            boolean needSaveSession = annotation.needSaveToken();
            if (needSaveSession) {
                request.getSession(false).setAttribute(SUBMIT_TOKEN_NAME, UUID.randomUUID().toString());
                LOG.warn("SaveSession:"+request.getSession().getAttribute(SUBMIT_TOKEN_NAME));
            }

            boolean needRemoveSession = annotation.needRemoveToken();
            if (needRemoveSession) {
                if (isRepeatSubmit(request)) {
                    LOG.warn("RepeatSubmit!!");
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "RepeatSubmit!");
                    return false;
                }
                request.getSession(false).removeAttribute(SUBMIT_TOKEN_NAME);
            }
        }
        return true;
    }
 
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute(SUBMIT_TOKEN_NAME);
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter(SUBMIT_TOKEN_NAME);
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}
