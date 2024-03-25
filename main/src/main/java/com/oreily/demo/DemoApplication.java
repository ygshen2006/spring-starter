package com.oreily.demo;

import com.oreily.demo.validate.startup.StartUpCheckAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@StartUpCheckAnnotation
//@ComponentScan(basePackages = "com.oreily.*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
