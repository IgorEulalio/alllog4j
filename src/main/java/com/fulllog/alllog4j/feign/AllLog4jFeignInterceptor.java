package com.fulllog.alllog4j.feign;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;


public class AllLog4jFeignInterceptor {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
