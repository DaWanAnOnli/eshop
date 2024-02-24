package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;

public interface ProductRepositoryInterface extends AbstractRepositoryInterface<Product>{
    Product create(Product product);
    Iterator<Product> findAll();
    public Product findById(String id);
    public void delete(String id);
    public Product update(String id, Product updatedProduct);
}
