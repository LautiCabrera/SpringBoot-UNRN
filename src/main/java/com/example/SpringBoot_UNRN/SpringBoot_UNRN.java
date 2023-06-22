package com.example.SpringBoot_UNRN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot_UNRN {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot_UNRN.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(ApplicationContext ctx){
		return args ->{
			System.out.println("Hola Mundo");
		};
	}

}
