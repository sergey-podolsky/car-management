package com.epam;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Detail {
	@Id
	@GeneratedValue
	private final Long id = null;
	private String name;
	private String Produceer;
	@ManyToMany(mappedBy = "details")
	private List<Car> cars = new ArrayList<>();

	public Detail() {
	}

	public Detail(String name, String produceer) {
		this.name = name;
		Produceer = produceer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduceer() {
		return Produceer;
	}

	public void setProduceer(String produceer) {
		Produceer = produceer;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Detail [id=" + id + ", name=" + name + ", Produceer="
				+ Produceer + "]";
	}
}
