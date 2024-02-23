package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepositoryInterface;

import java.util.List;

public interface ProductServiceInterface extends AbstractServiceInterface<Product, ProductRepository>{
    public Product create(Product product);
    public Product findSpecificProductById(String id);
    public void delete(String id);
    public List<Product> findAll();
    public void update(String id, Product specificProduct);
}
