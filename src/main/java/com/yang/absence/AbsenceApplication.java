package com.yang.absence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/21 11:07
 */

@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.yang.absence.mapper")
public class AbsenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbsenceApplication.class, args);
    }

}
