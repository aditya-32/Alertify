package com.projects.Alertify;

import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AlertifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertifyApplication.class, args);
	}
}
