package com.guigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.guigu.mapper")
@SpringBootApplication
public class SpringbootMybaitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybaitsApplication.class, args);
    }
}
