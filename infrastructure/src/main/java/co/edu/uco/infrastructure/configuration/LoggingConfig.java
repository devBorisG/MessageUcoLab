package co.edu.uco.infrastructure.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response , Object handler ){
        MDC.put("REQUEST_URI", request.getRequestURI());
        MDC.put("HTTP_METHOD", request.getMethod());
        MDC.put("SESSION_ID", request.getSession().getId());
        MDC.put("QUERY_STRING", request.getQueryString());
        MDC.put("codeMessage",request.getParameter("codeMessage"));
        MDC.put("application",request.getParameter("application"));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response , Object handler , Exception exception){
        MDC.clear();
    }
}
