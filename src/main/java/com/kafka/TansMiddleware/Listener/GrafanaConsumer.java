package com.kafka.TansMiddleware.Listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GrafanaConsumer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServers;
    @KafkaListener(topicPattern = "${spring.kafka.producer.topic}", groupId = "${spring.kafka.consumer.group_id}")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        // Process the message for Grafana
    }
}
