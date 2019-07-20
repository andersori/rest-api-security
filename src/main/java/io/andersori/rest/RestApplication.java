package io.andersori.rest;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
	@Bean
	public DataSource database() {
		DataSourceBuilder<?> data = DataSourceBuilder.create();
		data.driverClassName("org.h2.Driver");
		data.password("sa");
		data.username("sa");
		data.url("jdbc:h2:mem:test?createDatabaseIfNotExist=true");
		return data.build();
	}
	
	@Bean
	public CommandLineRunner run() throws Exception{
		return (String[] args) -> {
			
		};
	}
	
	@Bean
	public BCryptPasswordEncoder crypt(){
		return new BCryptPasswordEncoder();
	}

}
