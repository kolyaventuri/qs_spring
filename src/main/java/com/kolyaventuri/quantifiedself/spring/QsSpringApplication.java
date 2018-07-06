package com.kolyaventuri.quantifiedself.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QsSpringApplication.class, args);
	}
}
