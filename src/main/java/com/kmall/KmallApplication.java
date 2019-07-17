package com.kmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.kmall.dao"})
public class KmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmallApplication.class, args);
	}

}
