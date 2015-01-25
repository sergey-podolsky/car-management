package com.epam;

import org.joda.time.Duration;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class HybridCar extends Car {

    @Embedded
    private Engine engine;
    private Duration travelRange;
    private Duration rechargingTime;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

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
