
package com.paintbooth.booth_state_service.service;

import com.paintbooth.booth_state_service.event.PurgeCompleted;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PurgeEventPublisher {

    private static final String TOPIC = "soa.s07.t08.events";

    private final KafkaTemplate<String, PurgeCompleted> kafkaTemplate;

    public PurgeEventPublisher(
            KafkaTemplate<String, PurgeCompleted> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPurgeCompleted(
            Long boothId,
            String purgedColor,
            String nextColor) {

        PurgeCompleted event = new PurgeCompleted();
        event.setEventId(UUID.randomUUID());
        event.setAggregateId(boothId);
        event.setSchemaVersion(1);
        event.setOccurredAt(Instant.now());
        event.setCorrelationId(UUID.randomUUID().toString());
        event.setBoothId(boothId);
        event.setPurgedColor(purgedColor);
        event.setNextColor(nextColor);

        kafkaTemplate.send(TOPIC, boothId.toString(), event);
    }
}
