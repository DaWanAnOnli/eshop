package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import id.ac.ui.cs.advprog.eshop.repository.CarRepositoryInterface;
import org.springframework.stereotype.Service;


@Service
public class CarService extends AbstractService<Car, CarRepository> implements CarServiceInterface{
}
