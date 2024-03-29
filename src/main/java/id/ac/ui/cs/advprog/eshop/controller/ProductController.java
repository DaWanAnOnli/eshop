package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;

import id.ac.ui.cs.advprog.eshop.service.CarService;
import id.ac.ui.cs.advprog.eshop.service.CarServiceInterface;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceInterface service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ListProduct";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(Model model, @PathVariable String productId){
        Product product = service.findSpecificProductById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model){
        service.update(product.getId(), product);
        return "redirect:/product/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId) {
        service.delete(productId);
        return "redirect:/product/list";
    }
}

@Controller
@RequestMapping("/car")
class CarController{

    @Autowired
    private CarServiceInterface carService;

    @GetMapping("/createCar")
    public String createCarPage(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model){
        carService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model){
        List<Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model){
        Car car = carService.findSpecificProductById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model){
        System.out.println(car.getId());
        carService.update(car.getId(), car);

        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId){
        carService.delete(carId);
        return "redirect:listCar";
    }
}

