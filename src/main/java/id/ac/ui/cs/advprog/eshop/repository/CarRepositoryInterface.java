package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.Iterator;

public interface CarRepositoryInterface extends AbstractRepositoryInterface<Car>{
    Car create(Car car);
    Iterator<Car> findAll();
    public Car findById(String id);
    public void delete(String id);
    public Car update(String id, Car updatedCar);
}
