package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository extends AbstractRepository{
//    private List<Product> productData = new ArrayList<>();
//
//
//
//    public Product create(Product product){
//        if(product.getProductId() == null){
//            UUID uuid = UUID.randomUUID();
//            product.setProductId(uuid.toString());
//        }
//        productData.add(product);
//        return product;
//    }
//
//    public Product findById(String id){
//        for (Product product : productData){
//            if (product.getProductId().equals(id)){
//                return product;
//            }
//        }
//        return null;
//    }
//
//    public void delete(String id){
//        productData.removeIf(product -> product.getProductId().equals(id));
//    }
//
//    public Iterator<Product> findAll(){
//        return productData.iterator();
//    }
//
//    public Product update(String id, Product updatedProduct) {
//        for (int i=0; i<productData.size(); i++){
//            Product productInList = productData.get(i);
//            if (productInList.getProductId().equals(id)){
//                productInList.setProductId(updatedProduct.getProductId());
//                productInList.setProductName(updatedProduct.getProductName());
//                productInList.setProductQuantity(updatedProduct.getProductQuantity());
//                return productInList;
//            }
//        }
//        return null;
//    }
}