package com.shawn.model.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {
    //APITODO 还没有测试结果
    @Bean
    public MethodBean getmethodBean() {
        MethodBean demo = new MethodBean();
        demo.setId(12345);
        demo.setName("methodBeanName");
        return demo;
    }
}
