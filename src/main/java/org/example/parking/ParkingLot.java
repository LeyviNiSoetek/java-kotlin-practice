package org.example.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingLot {
    public static void main(String[] args) {
        LocalDateTime enterTime =
                LocalDateTime.of(2024, 3, 5, 11, 0, 0);
        LocalDateTime leaveTime =
                enterTime.plus(Duration.ofHours(11).plus(Duration.ofMinutes(35)));
        ParkingCar car = new ParkingCar("ELITE-1135", enterTime);
        car.setLeaveTime(leaveTime);
        System.out.println(car.getDuration().toMinutes() + " minutes");
    }
}
