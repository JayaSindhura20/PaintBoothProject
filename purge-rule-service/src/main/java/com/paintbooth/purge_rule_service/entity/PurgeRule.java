
package com.paintbooth.purge_rule_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "purge_rules")
public class PurgeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String fromColor;

    @NotBlank
    private String toColor;

    private int purgeDurationSeconds;

    public PurgeRule() {
    }

    public Long getId() {
        return id;
    }

    public String getFromColor() {
        return fromColor;
    }

    public void setFromColor(String fromColor) {
        this.fromColor = fromColor;
    }

    public String getToColor() {
        return toColor;
    }

    public void setToColor(String toColor) {
        this.toColor = toColor;
    }

    public int getPurgeDurationSeconds() {
        return purgeDurationSeconds;
    }

    public void setPurgeDurationSeconds(int purgeDurationSeconds) {
        this.purgeDurationSeconds = purgeDurationSeconds;
    }
}
