package com.shawn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EnableSwagger2Doc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBoot15Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot15Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBoot15Application.class);
    }
}
