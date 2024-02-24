package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import id.ac.ui.cs.advprog.eshop.repository.CarRepositoryInterface;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepositoryInterface;

import java.util.List;

public interface CarServiceInterface extends AbstractServiceInterface<Car, CarRepository>{
    public Car create(Car car);
    public Car findSpecificProductById(String id);
    public void delete(String id);
    public List<Car> findAll();
    public void update(String id, Car car);
}
