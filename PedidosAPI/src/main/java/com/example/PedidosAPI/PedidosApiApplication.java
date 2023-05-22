package com.example.PedidosAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PedidosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosApiApplication.class, args);
	}

}
