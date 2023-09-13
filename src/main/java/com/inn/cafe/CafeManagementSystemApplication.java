package com.inn.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CafeManagementSystemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CafeManagementSystemApplication.class, args);
	}

}
