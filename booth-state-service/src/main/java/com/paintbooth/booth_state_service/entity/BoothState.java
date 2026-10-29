package com.paintbooth.booth_state_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "booth_states")
public class BoothState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boothName;

    private String currentColor;

    private String status;

    public BoothState() {
    }

    public Long getId() {
        return id;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
