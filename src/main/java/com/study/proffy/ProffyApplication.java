package com.study.proffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProffyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProffyApplication.class, args);
    }

}
