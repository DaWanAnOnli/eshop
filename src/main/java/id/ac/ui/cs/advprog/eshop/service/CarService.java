package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class CarService{
    @Autowired
    private CarRepository carRepository;


    public Car create(Car car){
        carRepository.create(car);
        return car;
    }


    public List<Car> findAll() {
        Iterator<? extends AbstractProduct> carIterator = carRepository.findAll();
        List<Car> allCars = new ArrayList<>();
        carIterator.forEachRemaining(product -> {
            if (product instanceof Car) {
                allCars.add((Car) product);
            }
        });
        return allCars;
    }


    public Car findById(String carId){
        Car car = (Car) carRepository.findById(carId);
        return car;
    }


    public void update(String carId, Car car){
        carRepository.update(carId, car);
    }


    public void deleteCarById(String carId){
        carRepository.delete(carId);
    }
}
