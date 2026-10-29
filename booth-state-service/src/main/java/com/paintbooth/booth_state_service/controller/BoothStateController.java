
package com.paintbooth.booth_state_service.controller;

import com.paintbooth.booth_state_service.entity.BoothState;
import com.paintbooth.booth_state_service.repository.BoothStateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booths")
public class BoothStateController {

    private final BoothStateRepository repository;

    public BoothStateController(BoothStateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BoothState> getAllBooths() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BoothState getBoothById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booth not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoothState createBooth(@RequestBody BoothState booth) {
        return repository.save(booth);
    }

    @PutMapping("/{id}")
    public BoothState updateBooth(
            @PathVariable Long id,
            @RequestBody BoothState updatedBooth) {

        BoothState booth = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booth not found"));

        booth.setBoothName(updatedBooth.getBoothName());
        booth.setCurrentColor(updatedBooth.getCurrentColor());
        booth.setStatus(updatedBooth.getStatus());

        return repository.save(booth);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooth(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Booth not found");
        }
        repository.deleteById(id);
    }
}
