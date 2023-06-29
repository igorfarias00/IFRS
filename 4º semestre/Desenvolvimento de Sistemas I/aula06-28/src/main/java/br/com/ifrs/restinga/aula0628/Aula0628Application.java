package br.com.ifrs.restinga.aula0628;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Aula0628Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula0628Application.class, args);
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(Aula0628Application.class)
						.web(WebApplicationType.NONE)
						.run(args);


	}

}
