package com.nxftl.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.nxftl"})
public class EduOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduOnlineApplication.class);
	}
}
