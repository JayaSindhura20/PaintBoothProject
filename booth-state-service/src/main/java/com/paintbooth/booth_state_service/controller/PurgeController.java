
package com.paintbooth.booth_state_service.controller;

import com.paintbooth.booth_state_service.service.PurgeEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/purge")
public class PurgeController {

    private final PurgeEventPublisher publisher;

    public PurgeController(PurgeEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/complete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> completePurge(
            @RequestBody PurgeRequest request) {

        publisher.publishPurgeCompleted(
                request.boothId(),
                request.purgedColor(),
                request.nextColor()
        );

        return Map.of(
                "message", "PurgeCompleted event submitted to Kafka",
                "status", "ACCEPTED"
        );
    }

    public record PurgeRequest(
            Long boothId,
            String purgedColor,
            String nextColor) {
    }
}
