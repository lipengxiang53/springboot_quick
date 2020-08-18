package com.VTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Auther Lee53
 * @Date 2019-11-25 18:19
 */
@SpringBootApplication
public class TMydataApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TMydataApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TMydataApplication.class);
    }

}
