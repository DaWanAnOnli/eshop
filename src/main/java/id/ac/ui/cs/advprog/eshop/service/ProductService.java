package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);

    Product findProductById(String productId);

    void delete(String productId);
    List<Product> findAll();

    Product editProduct(Product product);
}


