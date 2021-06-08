package com.marlowe.whell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.marlowe.whell.mapper")
public class WhellApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhellApplication.class, args);
    }

}
