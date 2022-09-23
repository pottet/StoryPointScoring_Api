package com.turksat.StoryPointScoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class StoryPointScoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryPointScoringApplication.class, args);
	}

}
