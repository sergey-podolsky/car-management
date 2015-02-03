package com.epam;

import java.util.List;
import javax.persistence.EntityManager;

public class CarDao {
	private final EntityManager entityManager;
	
	
	public CarDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Car> findByModelName(String modelName) {
		return entityManager
				.createQuery("from Car car where car.model.name = :modelName", Car.class)
				.setParameter("modelName", modelName)
				.getResultList();
	}
	
	public List<Car> findByPowerBetween(Integer start, Integer end) {
		return entityManager
				.createQuery("from Car car where car.engine.power between :start and :end", Car.class)
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
	}

	public List<Car> findWithoutTechRecors() {
		return entityManager.createQuery("from Car car where size(car.techRecords) = 0", Car.class).getResultList();
	}
		
	public List<Car> findWithDetail(String detailName) {
		return entityManager
				.createQuery("select car from Car car, in (car.details) detail where index(detail) = :detailName", Car.class)
				.setParameter("detailName", detailName)
				.getResultList();
	}
	
	public List<String> findAllManufacturers() {
		return entityManager.createQuery("select distinct car.manufacturer from Car car", String.class).getResultList();
	}
}
