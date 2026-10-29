
package com.paintbooth.purge_rule_service.repository;

import com.paintbooth.purge_rule_service.entity.PurgeRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurgeRuleRepository extends JpaRepository<PurgeRule, Long> {
}
