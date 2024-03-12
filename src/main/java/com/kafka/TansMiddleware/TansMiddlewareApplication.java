package com.kafka.TansMiddleware;


import com.kafka.TansMiddleware.Component.WebSocketServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableWebSocket
public class TansMiddlewareApplication {
//	private final SocketServer socketServer;
//
//	public TansMiddlewareApplication(SocketServer socketServer) {
//		this.socketServer = socketServer;
//	}

//	@Override
//	public void run(String... args) {
//		socketServer.startSocketServer();
//	}
	public static void main(String[] args) {
		SpringApplication.run(TansMiddlewareApplication.class, args);
	}
	@Bean
	public WebSocketServer webSocketServer(KafkaTemplate<String, String> kafkaTemplate) {
		return new WebSocketServer(kafkaTemplate);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
