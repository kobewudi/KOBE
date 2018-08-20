package com.wuxingfei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wuxingfei.dao")
/*@EnableScheduling*/
public class PersonalApplication {

	public static void main(String[] args) {

		SpringApplication.run(PersonalApplication.class, args);
	}
}
