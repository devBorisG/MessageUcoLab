package co.edu.uco.infrastructure.configuration;

import co.edu.uco.infrastructure.adapter.primary.interceptors.AcceptHeaderInterceptor;
import co.edu.uco.infrastructure.adapter.primary.interceptors.TokenHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoggingConfig loggingConfig;
    private final AcceptHeaderInterceptor acceptHeaderInterceptor;
    private final TokenHeaderInterceptor tokenHeaderInterceptor;

    public WebConfig(LoggingConfig loggingConfig, AcceptHeaderInterceptor acceptHeaderInterceptor, TokenHeaderInterceptor tokenHeaderInterceptor){
        this.loggingConfig=loggingConfig;
        this.acceptHeaderInterceptor = acceptHeaderInterceptor;
        this.tokenHeaderInterceptor = tokenHeaderInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingConfig);
        registry.addInterceptor(acceptHeaderInterceptor)
                .excludePathPatterns(
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/v3/api-docs/**",
                        "/webjars/**"
                );
        registry.addInterceptor(tokenHeaderInterceptor)
                .addPathPatterns(
                        "/messageucolab/v1/application/*/message/*",
                        "/messageucolab/v1/application/*/messages"
                );
    }
}
