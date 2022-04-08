package com.relation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 */
@SpringBootApplication
//开启定时
@EnableScheduling
//mapper层指定
@MapperScan("com.relation.dao")
public class RelationApplication {
    public static void main(String[] args) {
        SpringApplication.run(RelationApplication.class,args);
    }
}
