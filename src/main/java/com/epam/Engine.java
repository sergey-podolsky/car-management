package com.epam;

import javax.persistence.*;

@Entity
public class Engine {

	@Id
	@GeneratedValue
	private final Long id = null;
	private String model;
	private Integer power;
	private Integer displacement;
	private Integer numberOfCylinders;
	@OneToOne(mappedBy = "engine")
	private Car car;

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

	public Integer getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}

	public Integer getNumberOfCylinders() {
		return numberOfCylinders;
	}

	public void setNumberOfCylinders(Integer numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}

	public Long getId() {
		return id;
	}
}
