package com.aini.express.common.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionFilter implements Filter {
    
    protected final Log log = LogFactory.getLog(getClass());
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();
        request.setAttribute("baseURI", uri);
        if(!uri.startsWith("/login/") && !uri.startsWith("/intro/")) {
//            
//            //비로그인 처리
//            HttpSession session = ((HttpServletRequest)request).getSession();
//            
//            
//            if (ObjectUtils.isEmpty(session.getAttribute("uvo"))) {
//                
//                //임시 주석을 풀어 줘야 함 세션 체크 로직
//                if(isAjaxRequest(request)){
//                    ((HttpServletResponse)response).sendError(400);
//                }else{
//                    //((HttpServletResponse)response).sendRedirect("/intro/intro.do"); 
//                    ((HttpServletResponse)response).sendRedirect("/login/login.do"); 
//                }
//                return; 
//            }
//            
        } 
        
        uri = null;
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
    
    private boolean isAjaxRequest(ServletRequest request){
        
        String header = ((HttpServletRequest)request).getHeader("AJAX");
        if(StringUtils.isNotEmpty(header) && header.equals("true")){
            return true;
        }else{
            return false;
        }
    }

}
