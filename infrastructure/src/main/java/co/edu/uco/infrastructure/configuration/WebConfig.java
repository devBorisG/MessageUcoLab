package co.edu.uco.infrastructure.configuration;

import co.edu.uco.infrastructure.adapter.primary.interceptors.AcceptHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoggingConfig loggingConfig;
    private final AcceptHeaderInterceptor acceptHeaderInterceptor;

    public WebConfig(LoggingConfig loggingConfig, AcceptHeaderInterceptor acceptHeaderInterceptor){
        this.loggingConfig=loggingConfig;
        this.acceptHeaderInterceptor = acceptHeaderInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingConfig);
        registry.addInterceptor(acceptHeaderInterceptor);
    }


}
