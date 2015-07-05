package com.epam;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    private static final String PERSISTENCE_UNIT = "HibernateMySQL";

    public static void main(String[] args) throws Exception {
        Car car = createCar();

        // Persist car
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
            
            CarDao carDao = new CarDao(entityManager);
            System.out.println(carDao.findAllManufacturers());
            System.out.println(carDao.findByModelName("S200"));
            System.out.println(carDao.findByPowerBetween(4000, 5000));
            System.out.println(carDao.findWithoutTechRecords());
            System.out.println(carDao.findWithDetail("tires"));

            transaction.begin();
            car.setPrice(car.getPrice().add(new BigDecimal("1.00")));
            car.getTechRecords().add(new TechRecord("Diagnosed", new Date(), "Uncle Bob"));
            transaction.commit();

            transaction.begin();
            entityManager.remove(car);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    private static Car createCar() throws IOException{
        Car car = new Car();
        car.setManufacturer("Mercedes Benz");
        car.setModel(new CarModel("S200", new Date()));
        car.setEngine(createEngine());
        car.setCarType(CarType.SPORTS);
        car.setImage(loadImage("http://goautomedia.cdn.on.net/gallery/mercedes-benz/c-class/2011_05_01_mercedes-benz-c-class-c200-sedan05.jpg"));
        car.setPrice(new BigDecimal("41999.99"));
        car.setDoorNumber(DoorNumber.THREE);
        car.getTechRecords().add(new TechRecord("Repaired.", new Date(), "Uncle Bob"));
        Detail detail = new Detail("Tires", "Nokian");
        car.getDetails().put(detail.getName(), detail);
        return car;
    }
    
    private static Engine createEngine() {
    	Engine engine = new Engine();
    	engine.setModel("Jaguar");
    	engine.setPower(4200);
    	engine.setNumberOfCylinders(256);
    	return engine;
    }

    private static byte[] loadImage(String url) throws IOException {
        //return IOUtils.toByteArray(new URL(url).openStream());
    	return new byte[] {1,2,3};
    }
}
