package com.epam;

import org.joda.time.Duration;

import javax.persistence.Entity;

@Entity
public class ElectricCar extends Car {

    private int travelRangeKm;
    private Duration rechargingTime;

    public int getTravelRangeKm() {
        return travelRangeKm;
    }

    public void setTravelRangeKm(int travelRangeKm) {
        this.travelRangeKm = travelRangeKm;
    }

    public Duration getRechargingTime() {
        return rechargingTime;
    }

    public void setRechargingTime(Duration rechargingTime) {
        this.rechargingTime = rechargingTime;
    }
}
