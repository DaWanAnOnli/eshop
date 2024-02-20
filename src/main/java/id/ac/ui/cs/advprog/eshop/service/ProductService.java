package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        CreateProduct.createProduct(productRepository, product);
        return product;
    }

    public Product findProductById(String productId){
        return(FindProduct.findProductById(productRepository, productId));
    }

    public void delete(String productId) {
        DeleteProduct.deleteProductById(productRepository, productId);
    }


    public List<Product> findAll(){
        return(FindProduct.findAllProducts(productRepository));
    }

    public void update(String productId, Product product) {
        UpdateProduct.updateProductById(productRepository, productId, product);
    }
}



abstract class CreateProduct{
    static Product createProduct(ProductRepository productRepository, Product product) {
        productRepository.create(product);
        return product;
    }
}

abstract class FindProduct{
    static List<Product> findAllProducts(ProductRepository productRepository){
        Iterator<? extends AbstractProduct> productIterator = productRepository.findAll();
        List<Product> allCars = new ArrayList<>();
        productIterator.forEachRemaining(product -> {
            if (product instanceof Product) {
                allCars.add((Product) product);
            }
        });
        return allCars;
    }
    static Product findProductById(ProductRepository productRepository, String productId){
        return (Product )productRepository.findById(productId);
    };
}

abstract class DeleteProduct{
    static void deleteProductById(ProductRepository productRepository, String productId){
        productRepository.delete(productId);
    }
}

abstract class UpdateProduct{
    static void updateProductById(ProductRepository productRepository, String productId, Product product){
        productRepository.update(productId, product);
    }
}



