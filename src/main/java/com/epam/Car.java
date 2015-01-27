package com.epam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "VEHICLE")
@SecondaryTable(name = "COMPANY")
public abstract class Car {

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

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Lob
    private byte[] image;

    @Transient
    private BigDecimal price;
    
    @Convert(converter=DoorNumberConverter.class)
    private DoorNumber doorNumber;
    
    @ElementCollection
    @CollectionTable(name = "TECH_RECORD", joinColumns = {@JoinColumn(name = "VEHICLE_ID")})
    private List<TechRecord> techRecords = new ArrayList<>();

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
    
    public List<TechRecord> getTechRecords() {
		return techRecords;
	}
    
    public void setTechRecords(List<TechRecord> techRecords) {
		this.techRecords = techRecords;
	}
}
