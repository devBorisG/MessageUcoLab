package co.edu.uco.infrastructure.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.*;

@Component
public final class LoggingConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler ){
        MDC.put(LOGGING_REQUEST_URI, request.getRequestURI());
        MDC.put(LOGGING_HTTP_METHOD, request.getMethod());
        MDC.put(LOGGING_SESSION_ID, request.getSession().getId());
        MDC.put(LOGGING_QUERY_STRING, request.getQueryString());
        MDC.put(LOGGING_PARAMETER_CODE_MESSAGE,request.getParameter(LOGGING_PARAMETER_CODE_MESSAGE));
        MDC.put(LOGGING_PARAMETER_APPLICATION,request.getParameter(LOGGING_PARAMETER_APPLICATION));
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response , Object handler , Exception exception){
        MDC.clear();
    }
}