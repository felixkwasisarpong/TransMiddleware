package com.kafka.TansMiddleware.Component;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

@Component
public class SocketServer{
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic;

    private final int port;

    @Autowired
    public SocketServer(@Value("${spring.visa.port}") int port,KafkaTemplate<String, String> kafkaTemplate, @Value("${spring.kafka.producer.topic}") String kafkaTopic) {

        this.topic = kafkaTopic;
        this.port = port;
        this.kafkaTemplate = kafkaTemplate;
    }


        @PostConstruct
        public void startServer() {
            Thread serverThread = new Thread(() -> {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    System.out.println("Server started. Listening on port " + port);

                    while (true) {
                        Socket socket = serverSocket.accept();
                        System.out.println("Client connected: " + socket.getInetAddress());

                        // Handle incoming data
                        handleIncomingData(socket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            serverThread.start();
        }

        private void handleIncomingData(Socket socket) {
            Thread dataHandlerThread = new Thread(() -> {
                try (InputStream inputStream = socket.getInputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        String receivedData = new String(buffer, 0, bytesRead);
                        System.out.println("Received data from client: " + receivedData);
                    String JSonData = ConvertToJson.isoToJson(buffer);
                        kafkaTemplate.send(topic,JSonData);
                        // Process the received data as needed
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            dataHandlerThread.start();
        }

}
