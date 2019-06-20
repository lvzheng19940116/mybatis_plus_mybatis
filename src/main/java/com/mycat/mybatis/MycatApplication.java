package com.mycat.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("example.data.diversion.mapper")
public class MycatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatApplication.class, args);
    }
}
