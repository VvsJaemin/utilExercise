package com.aini.express.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@Component
@RequiredArgsConstructor
public class Interceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler) throws Exception {
        
        return super.preHandle(request, response, handler);
    }

}
