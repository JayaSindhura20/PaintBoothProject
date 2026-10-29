
package com.paintbooth.paint_job_service.config;

import com.paintbooth.paint_job_service.event.PurgeCompleted;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, PurgeCompleted> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "paint-job-service");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        JsonDeserializer<PurgeCompleted> valueDeserializer =
                new JsonDeserializer<>(PurgeCompleted.class, false);

        valueDeserializer.addTrustedPackages(
                "com.paintbooth.paint_job_service.event"
        );

        return new DefaultKafkaConsumerFactory<>(
                properties,
                new StringDeserializer(),
                valueDeserializer
        );
    }

    @Bean(name = "kafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, PurgeCompleted>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, PurgeCompleted> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
