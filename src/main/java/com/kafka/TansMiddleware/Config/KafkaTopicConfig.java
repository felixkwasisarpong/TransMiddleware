package com.kafka.TansMiddleware.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaTopicConfig {
    @Value("${spring.kafka.producer.topic}")
    private String topic;
    @Bean
    public NewTopic transTopic() {
        return TopicBuilder.name(topic)
                .build();
    }
}
