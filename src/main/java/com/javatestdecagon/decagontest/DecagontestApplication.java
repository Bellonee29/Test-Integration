package com.javatestdecagon.decagontest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class DecagontestApplication {
	public static void main(String[] args) {
		SpringApplication.run(DecagontestApplication.class, args);
	}

}
