package com.spimex.jdtesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ImportResource("classpath:jpa-context.xml")
public class JdTestTask {

    public static void main(String[] args) {
        SpringApplication.run(JdTestTask.class, args);
    }

}
