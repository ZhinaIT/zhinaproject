package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @title: NewEntryWangzhinaApplication
 * @projectName NewEntryWangZhina
 * @description: TODO
 * author Wang_Zhina
 * date 2022/3/28 17:44
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class NewEntryWangzhinaApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewEntryWangzhinaApplication.class,args);
    }
}
