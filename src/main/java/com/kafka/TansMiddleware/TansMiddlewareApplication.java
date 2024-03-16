package com.kafka.TansMiddleware;


import com.kafka.TansMiddleware.Component.SocketServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class TansMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TansMiddlewareApplication.class, args);
	}
}
