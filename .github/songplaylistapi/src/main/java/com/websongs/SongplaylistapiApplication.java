package com.websongs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SongplaylistapiApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(SongplaylistapiApplication.class, args);
		
		System.out.println("songs rest api play list");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("swagger-ui.html")
		      .addResourceLocations("classpath:/META-INF/resources/");
		    registry.addResourceHandler("/webjars/**")
		      .addResourceLocations("classpath:/META-INF/resources/webjars/");
		}


}
