
package com.paintbooth.paint_job_service.event;

import java.time.Instant;
import java.util.UUID;

public class PurgeCompleted {

    private UUID eventId;
    private Long aggregateId;
    private int schemaVersion;
    private Instant occurredAt;
    private String correlationId;
    private Long boothId;
    private String purgedColor;
    private String nextColor;

    public PurgeCompleted() {
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public int getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Long getBoothId() {
        return boothId;
    }

    public void setBoothId(Long boothId) {
        this.boothId = boothId;
    }

    public String getPurgedColor() {
        return purgedColor;
    }

    public void setPurgedColor(String purgedColor) {
        this.purgedColor = purgedColor;
    }

    public String getNextColor() {
        return nextColor;
    }

    public void setNextColor(String nextColor) {
        this.nextColor = nextColor;
    }
}
