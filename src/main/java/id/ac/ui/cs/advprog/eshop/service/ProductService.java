package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);

    public Product findProductById(String productId);

    public void delete(String productId);
    public List<Product> findAll();

    public Product editProduct(Product product);
}


