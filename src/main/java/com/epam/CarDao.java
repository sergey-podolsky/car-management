package com.epam;

import java.util.List;
import javax.persistence.EntityManager;

public class CarDao {
	private final EntityManager entityManager;
	
	
	public CarDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// An implicit association join
	public List<Car> findByModelName(String modelName) {
		return entityManager
				.createQuery("from Car car where car.model.name = :modelName", Car.class)
				.setParameter("modelName", modelName)
				.getResultList();
	}
	
	// An ordinary join in the FROM clause
	public List<Car> findByPowerBetween(Integer start, Integer end) {
		return entityManager
				.createQuery("from Car car where car.engine.power between :start and :end", Car.class)
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
	}
	
	
	// A fetch join in the FROM clause
	public List<Car> findRepaired() {
		return entityManager
				.createQuery("from Car car join fetch TechRecord techRecord where tolower(techRecord.text) like 'repaired'", Car.class)
				.getResultList();
	}

	public List<Car> findWithoutTechRecords() {
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
