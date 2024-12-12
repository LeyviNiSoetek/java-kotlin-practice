package org.example.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingCar {
    private String identifier;
    private LocalDateTime enterTime;
    private LocalDateTime leaveTime;

    public ParkingCar(String identifier, LocalDateTime enterTime) {
        this.identifier = identifier;
        this.enterTime = enterTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        if (leaveTime == null) {
            System.out.println("No null allowed here.");
            return;
        }
        if (!enterTime.isBefore(leaveTime)) {
            System.out.println("Invalid leave time: " + leaveTime);
            return;
        }
        this.leaveTime = leaveTime;
    }

    public Duration getDuration() {
        if (leaveTime == null) {
            throw new RuntimeException("Trying to get parking duration before car leaving.");
        }
        return Duration.between(enterTime, leaveTime);
    }
}
