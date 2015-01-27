package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CarModel {
    @Id
    @GeneratedValue
    private final Integer id = null;
    private String name;
    private Date originDate;
    @OneToMany(mappedBy = "model")
    private List<Car> cars = new ArrayList<>();

    public CarModel() {
    }

    public CarModel(String name, Date originDate) {
        this.name = name;
        this.originDate = originDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOriginDate() {
        return originDate;
    }

    public void setOriginDate(Date originDate) {
        this.originDate = originDate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
