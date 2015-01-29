package com.epam;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private CarModel model;

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

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
    		name = "detail_car",
    		joinColumns = {@JoinColumn(name = "VEHICLE_ID")},
    		inverseJoinColumns = {@JoinColumn(name = "DETAIL_ID")})
    @MapKey(name = "name")
    private Map<String, Detail> details = new HashMap<>();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

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

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
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
    
    public Map<String, Detail> getDetails() {
		return details;
	}

	public void setDetails(Map<String, Detail> details) {
		this.details = details;
	}

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
