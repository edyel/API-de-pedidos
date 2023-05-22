package com.example.PedidosAPI.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PedidoAMQPConfiguration {
	
	@Bean
	public Queue criaFila() {
		return QueueBuilder.durable("pedido.realizado").build();
	}

	@Bean
	public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
		return new RabbitAdmin(conn);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
		return event -> rabbitAdmin.initialize();
	}
}
