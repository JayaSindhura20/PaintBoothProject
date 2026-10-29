
package com.paintbooth.paint_job_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PaintJobServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaintJobServiceApplication.class, args);
    }
}
