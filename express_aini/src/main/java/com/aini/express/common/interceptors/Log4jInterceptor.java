package com.aini.express.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SuppressWarnings("deprecation")
@Component
public class Log4jInterceptor extends HandlerInterceptorAdapter {
    
    private final Log log = LogFactory.getLog(Log4jInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (log.isDebugEnabled()) {
//            log.debug("====================================== START ======================================");
//            log.debug(" Request URI \t: " + request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            //log.debug("====================================== END ======================================\n");
        }
    }

}
