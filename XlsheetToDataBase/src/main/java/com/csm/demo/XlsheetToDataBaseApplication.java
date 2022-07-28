package com.csm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class XlsheetToDataBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(XlsheetToDataBaseApplication.class, args);
	}

}
