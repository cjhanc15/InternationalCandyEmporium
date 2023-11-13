package com.gcu.internationalcandyemporium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class InternationalcandyemporiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternationalcandyemporiumApplication.class, args);
	}

}
