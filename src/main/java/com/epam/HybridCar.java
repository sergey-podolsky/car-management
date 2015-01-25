package com.epam;

import org.joda.time.Duration;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class HybridCar extends Car {

    @Embedded
    private Engine engine;
    private int travelRangeKm;
    private Duration rechargingTime;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

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
