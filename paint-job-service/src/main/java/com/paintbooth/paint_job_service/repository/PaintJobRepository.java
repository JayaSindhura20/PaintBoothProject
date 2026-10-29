
package com.paintbooth.paint_job_service.repository;

import com.paintbooth.paint_job_service.entity.PaintJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintJobRepository extends JpaRepository<PaintJob, Long> {
}
