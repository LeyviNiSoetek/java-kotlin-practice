package org.example.parking.kotlin

import java.time.Duration
import java.time.LocalDateTime

fun main() {
    val enterTime: LocalDateTime =
        LocalDateTime.of(2024, 3, 5, 11, 0, 0)
    val leaveTime: LocalDateTime =
        enterTime.plus(Duration.ofHours(11).plus(Duration.ofMinutes(35)))

    val car = ParkingCar("ELITE-1135", enterTime)
    car.leaveTime = leaveTime // NOTE: this implicitly calls setter function
    val parkingHours: Int = Math.ceil(car.getDuration().toMinutes() / 60.0).toInt()
    val parkingFee: Int = parkingHours * 30
    println("Hours parked: $parkingHours, fee: \$$parkingFee.")
}
