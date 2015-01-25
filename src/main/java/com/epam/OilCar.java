package com.epam;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class OilCar extends Car {

    @Embedded
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
