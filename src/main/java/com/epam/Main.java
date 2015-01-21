package com.epam;

import com.google.common.collect.Iterables;
import org.apache.commons.io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String PERSISTENCE_UNIT = "HibernateMySQL";

    public static void main(String[] args) throws Exception {
        Car car = createCar();

        // Persist car
        EntityManager entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(car);
        transaction.commit();

        // Restore last persisted car image onto disk
        @SuppressWarnings("unchecked")
        List<Car> cars = (List<Car>)entityManager.createQuery("from Car").getResultList();
        System.out.println("Number of cars in the database is " + cars.size());
        Files.write(Paths.get("C:/Users/Sergey/Desktop/mercedes.jpg"), Iterables.getLast(cars).getImage());

        entityManager.close();
    }

    private static Car createCar() throws IOException{
        Car car = new Car();
        car.setManufacturer("Mercedes Benz");
        car.setModel("S200");
        car.setPower(600);
        car.setEngine(new Engine("Jaguar", 4200));
        car.setCarType(CarType.SPORTS);
        car.setImage(loadImage("http://goautomedia.cdn.on.net/gallery/mercedes-benz/c-class/2011_05_01_mercedes-benz-c-class-c200-sedan05.jpg"));
        car.setPrice(new BigDecimal("41999.99"));
        return car;
    }

    private static byte[] loadImage(String url) throws IOException {
        return IOUtils.toByteArray(new URL(url).openStream());
    }
}
