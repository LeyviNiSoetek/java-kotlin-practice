package org.example.parking.kotlin

import java.time.Duration
import java.time.LocalDateTime

class ParkingCar(private val identifier: String, private val enterTime: LocalDateTime) {
    var leaveTime: LocalDateTime? = null
        // NOTE: this is the syntax to declare a setter function
        // TODO: to know more details?
        // TODO: is it possible to expose only setter but not getter?
        set(newLeaveTime) {
            if (newLeaveTime == null) {
                println("No null allowed here.")
                return
            }
            if (!enterTime.isBefore(newLeaveTime)) {
                println("Invalid leave time.")
                return
            }
            // NOTE: field is the token to use to set the actual property,
            //       otherwise infinite recursive happens
            field = newLeaveTime
        }

    // TODO: null check/handling?
    fun getDuration() : Duration {
        return Duration.between(enterTime, leaveTime)
    }
}