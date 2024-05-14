package org.example.test.config;

import jakarta.annotation.Resource;
import org.example.test.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web自动配置类，配置web拦截器
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //除了 /api/auth/ 的全部拦截
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/auth/**");
    }
}
