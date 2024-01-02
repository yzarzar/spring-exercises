package com.example.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.annotation.entity.Admin;
import com.example.annotation.repo.AdminRepo;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AnnotationApplication {

	private final AdminRepo adminRepo;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}

	@Bean 
	public Admin createAdmin() {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@gmial.com");
		return adminRepo.save(admin);
	}

}
