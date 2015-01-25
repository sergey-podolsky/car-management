package com.epam;

import org.joda.time.Duration;

import javax.persistence.Entity;

@Entity
public class ElectricCar extends Car {

    private Duration travelRange;
    private Duration rechargingTime;

    public Duration getTravelRange() {
        return travelRange;
    }

    public void setTravelRange(Duration travelRange) {
        this.travelRange = travelRange;
    }

    public Duration getRechargingTime() {
        return rechargingTime;
    }

    public void setRechargingTime(Duration rechargingTime) {
        this.rechargingTime = rechargingTime;
    }
}
