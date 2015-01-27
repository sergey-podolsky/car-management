package com.epam;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.joda.time.Duration;

@Entity
public class HybridCar extends Car {

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ENGINE_ID")
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
