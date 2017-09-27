package com.kco;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.templateresolver.TemplateResolver;

@Controller
@SpringBootApplication
public class Springbootdemo2Application {

	public static void main(String[] args) {
//		SpringApplication.run(Springbootdemo2Application.class, args);
		new SpringApplicationBuilder(Springbootdemo2Application.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

}
