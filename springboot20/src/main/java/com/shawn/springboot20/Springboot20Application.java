package com.shawn.springboot20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Springboot20Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20Application.class, args);
    }

    @RequestMapping(value = "/products")
    public String getProductName() {
        return "Honey";
    }
}
