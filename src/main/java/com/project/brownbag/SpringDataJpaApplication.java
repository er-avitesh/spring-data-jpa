package com.project.brownbag;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories
@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Resource
	FileRepository fileRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DataFile file = new DataFile("Java Notes", "Java is awesome");
		fileRepository.saveAndFlush(file);

		file.setName("Linux Notes");
		fileRepository.saveAndFlush(file);
		
		DataFile file2 = new DataFile("PCF NOtes", "Cloud FOundry is Future");
		fileRepository.saveAndFlush(file2);


	}
}
