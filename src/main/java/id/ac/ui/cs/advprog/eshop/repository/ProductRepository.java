package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private long numberOfProductsCreated = 0;


    public Product create(Product product){
        productData.add(product);
        product.setProductId(Long.toString(numberOfProductsCreated));
        numberOfProductsCreated += 1;
        return product;
    }

    public Product findProductById(String productId){
        for (Product product : productData){
            if (product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product editProduct(Product product) {
        for (int i=0; i<productData.size(); i++){
            Product productInList = productData.get(i);
            if (productInList.getProductId().equals(product.getProductId())){
                productData.set(i, product);
                return product;
            }
        }
        return null;
    }
}