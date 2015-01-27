package com.epam;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.google.common.collect.Iterables;
import org.apache.commons.io.IOUtils;
import org.joda.time.Duration;

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

            // Restore last persisted car image onto disk
            @SuppressWarnings("unchecked")
            List<Car> cars = (List<Car>) entityManager.createQuery("from Car").getResultList();
            System.out.println("Number of cars in the database is " + cars.size());
            System.out.println(Iterables.getFirst(cars, null));
            //Files.write(Paths.get("C:/Users/sergey/Desktop/mercedes.jpg"), Iterables.getLast(cars).getImage());
        } catch (Exception e) {
            e.printStackTrace();
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
        return IOUtils.toByteArray(new URL(url).openStream());
    }
}
