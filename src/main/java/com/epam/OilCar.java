package com.epam;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OilCar extends Car {

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
