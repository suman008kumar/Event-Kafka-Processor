package com.dem.eventprocessor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaEventConsumer {
    private final EventRepo repo;
    public KafkaEventConsumer(EventRepo repo){ this.repo = repo; }

    @KafkaListener(topics = {"test-topic"}, groupId = "dem-group")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        EventMessage e = new EventMessage();
        e.setTopicName(topic);
        e.setContent(message);
        e.setReceivedAt(LocalDateTime.now());
        repo.save(e);
        System.out.println("EVENT RECEIVED: " + topic + " -> " + message);
    }
}
