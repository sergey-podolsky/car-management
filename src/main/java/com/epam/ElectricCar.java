package com.epam;

import org.joda.time.Duration;

import javax.persistence.Entity;

@Entity
public class ElectricCar extends Car {

    private Duration travelRangeKm;
    private Duration rechargingTime;

    public Duration getTravelRangeKm() {
        return travelRangeKm;
    }

    public void setTravelRangeKm(Duration travelRangeKm) {
        this.travelRangeKm = travelRangeKm;
    }

    public Duration getRechargingTime() {
        return rechargingTime;
    }

    public void setRechargingTime(Duration rechargingTime) {
        this.rechargingTime = rechargingTime;
    }
}
