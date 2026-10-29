
package com.paintbooth.paint_job_service.controller;

import com.paintbooth.paint_job_service.entity.PaintJob;
import com.paintbooth.paint_job_service.repository.PaintJobRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class PaintJobController {

    private final PaintJobRepository repository;

    public PaintJobController(PaintJobRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PaintJob> getAllJobs() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PaintJob getJobById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paint job not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaintJob createJob(@RequestBody PaintJob job) {
        return repository.save(job);
    }

    @PutMapping("/{id}")
    public PaintJob updateJob(
            @PathVariable Long id,
            @RequestBody PaintJob updatedJob) {

        PaintJob job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paint job not found"));

        job.setJobName(updatedJob.getJobName());
        job.setTargetColor(updatedJob.getTargetColor());
        job.setStatus(updatedJob.getStatus());

        return repository.save(job);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJob(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Paint job not found");
        }
        repository.deleteById(id);
    }
}
