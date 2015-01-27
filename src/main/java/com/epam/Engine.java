package com.epam;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Engine {

	@Id
	@GeneratedValue
	private final Long id = null;
	private String model;
	private Integer power;
	private Integer displacement;
	private Integer numberOfCylinders;

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
