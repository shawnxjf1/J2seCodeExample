package com.yxzn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableSwagger2Doc
@ComponentScan(basePackages = {"com.yxzn"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KaleidoscopeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(KaleidoscopeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KaleidoscopeApplication.class);
    }
}
