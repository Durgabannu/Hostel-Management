package com.example.HstlMngmnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class HstlMngmntApplication {

	public static void main(String[] args) {
		SpringApplication.run(HstlMngmntApplication.class, args);
	}

}
