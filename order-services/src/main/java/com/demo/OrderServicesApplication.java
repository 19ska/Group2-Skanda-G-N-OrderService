package com.demo;

import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class OrderServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServicesApplication.class, args);
	}
	
    @Bean
    ModelMapper createModelMapper() {
    	
		return new ModelMapper();
	}
	

}
