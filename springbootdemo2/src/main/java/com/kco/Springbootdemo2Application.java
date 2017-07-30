package com.kco;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springbootdemo2Application {

	public static void main(String[] args) {
//		SpringApplication.run(Springbootdemo2Application.class, args);
		new SpringApplicationBuilder(Springbootdemo2Application.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

}
