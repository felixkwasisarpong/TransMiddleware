package com.kafka.TansMiddleware.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.TansMiddleware.Model.Transaction;
import com.kafka.TansMiddleware.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class PostgresConsumer {
    @Autowired
    private TransactionService transactionService;

    public PostgresConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServers;
    @KafkaListener(topicPattern = "${spring.kafka.producer.topic}", groupId = "${spring.kafka.consumer.group_id}")
    void consume(String message,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws Exception {
        transactionService.save(message);
    }
}
