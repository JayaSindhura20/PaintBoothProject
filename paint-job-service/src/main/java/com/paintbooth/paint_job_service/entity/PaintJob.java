
package com.paintbooth.paint_job_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paint_jobs")
public class PaintJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobName;

    private String targetColor;

    private String status;

    public PaintJob() {
    }

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTargetColor() {
        return targetColor;
    }

    public void setTargetColor(String targetColor) {
        this.targetColor = targetColor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
