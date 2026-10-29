
package com.paintbooth.purge_rule_service.controller;

import com.paintbooth.purge_rule_service.entity.PurgeRule;
import com.paintbooth.purge_rule_service.repository.PurgeRuleRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purge-rules")
public class PurgeRuleController {

    private final PurgeRuleRepository repository;

    public PurgeRuleController(PurgeRuleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PurgeRule> getAllRules() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PurgeRule getRuleById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purge rule not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurgeRule createRule(@Valid @RequestBody PurgeRule rule) {
        rule.setFromColor(rule.getFromColor().trim());
        rule.setToColor(rule.getToColor().trim());
        return repository.save(rule);
    }

    @PutMapping("/{id}")
    public PurgeRule updateRule(
            @PathVariable Long id,
            @Valid @RequestBody PurgeRule updatedRule) {

        PurgeRule rule = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purge rule not found"));

        rule.setFromColor(updatedRule.getFromColor().trim());
        rule.setToColor(updatedRule.getToColor().trim());
        rule.setPurgeDurationSeconds(updatedRule.getPurgeDurationSeconds());

        return repository.save(rule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRule(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Purge rule not found");
        }
        repository.deleteById(id);
    }
}
