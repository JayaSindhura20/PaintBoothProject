
package com.paintbooth.paint_job_service.consumer;

import com.paintbooth.paint_job_service.entity.PaintJob;
import com.paintbooth.paint_job_service.event.PurgeCompleted;
import com.paintbooth.paint_job_service.repository.PaintJobRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PurgeCompletedConsumer {

    private final PaintJobRepository repository;

    public PurgeCompletedConsumer(PaintJobRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(
        topics = "soa.s07.t08.events",
        groupId = "paint-job-service"
    )
    @Transactional
    public void handlePurgeCompleted(PurgeCompleted event) {
        List<PaintJob> jobs = repository.findAll();

        for (PaintJob job : jobs) {
            if ("LOCKED".equalsIgnoreCase(job.getStatus())
                    && job.getTargetColor().equalsIgnoreCase(event.getNextColor())) {
                job.setStatus("READY");
                repository.save(job);
            }
        }
    }
}
