package com.shop.fruitable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class FruitableApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitableApplication.class, args);
	}

}
