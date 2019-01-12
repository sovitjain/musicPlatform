package com.embibe.musicPlatform.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.embibe.musicPlatform.dao.EmployeeRepository;
import com.embibe.musicPlatform.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			System.out.println("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			System.out.println("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}
}