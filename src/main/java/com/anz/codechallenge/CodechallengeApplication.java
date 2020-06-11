package com.anz.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class CodechallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}

}
