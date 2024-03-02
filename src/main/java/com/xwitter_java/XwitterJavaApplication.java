package com.xwitter_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.xwitter_java.repositories")
public class XwitterJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(XwitterJavaApplication.class, args);
	}
}
