package com.epam;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Engine {

    @Column(name = "ENGINE_MODEL")
    private String model;

    private Integer volume;

    public Engine() {
    }

    public Engine(String model, Integer volume) {
        this.model = model;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
