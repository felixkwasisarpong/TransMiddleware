package com.kafka.TansMiddleware.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketServer implements WebSocketHandler {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.visa.port}")
    private int serverPort;

    @Value("${spring.kafka.producer.topic}")
    private String topic;


    @Autowired
    public WebSocketServer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("WebSocket connection established: " + session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        String transactionMessage = message.getPayload().toString();
        System.out.println("Received WebSocket message: " + transactionMessage);

        // Send the transaction message to Kafka
        kafkaTemplate.send(topic, transactionMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        System.err.println("WebSocket error: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        System.out.println("WebSocket connection closed: " + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
