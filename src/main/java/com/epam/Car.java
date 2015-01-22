package com.epam;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "VEHICLE")
@SecondaryTable(name = "COMPANY")
public class Car {

    @Id
    @GeneratedValue
    private final Long id = null;

    @Version
    private final Integer version = null;

    @Column(table = "COMPANY")
    @Basic(optional = false)
    private String manufacturer;

    @Basic(optional = false)
    private String model;

    private Integer power;

    @Embedded
    private Engine engine;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Lob
    private byte[] image;

    @Transient
    private BigDecimal price;
    
    @Convert(converter=DoorNumberConverter.class)
    private DoorNumber doorNumber;

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public DoorNumber getDoorNumber() {
		return doorNumber;
	}
    
    public void setDoorNumber(DoorNumber doorNumber) {
		this.doorNumber = doorNumber;
	}
}
