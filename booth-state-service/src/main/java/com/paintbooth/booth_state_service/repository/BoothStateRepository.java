
package com.paintbooth.booth_state_service.repository;

import com.paintbooth.booth_state_service.entity.BoothState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoothStateRepository extends JpaRepository<BoothState, Long> {
}
