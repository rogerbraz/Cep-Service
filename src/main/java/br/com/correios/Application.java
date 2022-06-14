package br.com.correios;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
