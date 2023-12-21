package com.charthome.config;

import com.charthome.common.interceptor.BoardTypeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public BoardTypeInterceptor boardTypeInterceptor(){
        return new BoardTypeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(boardTypeInterceptor()).addPathPatterns("/**");
    }


}
