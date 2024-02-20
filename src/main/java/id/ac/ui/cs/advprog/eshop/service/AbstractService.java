package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.repository.AbstractRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractService {

}





abstract class CreateAbstractProduct{
    static AbstractProduct createAbstractProduct(AbstractRepository abstractRepository, AbstractProduct abstractProduct){
        abstractRepository.create(abstractProduct);
        return abstractProduct;
    }
}

abstract class FindAbstractProduct{
    static List<AbstractProduct> findAllAbstractProducts(AbstractRepository abstractRepository){
        Iterator<AbstractProduct> abstractProductIterator = abstractRepository.findAll();
        List<AbstractProduct> allAbstractProducts = new ArrayList<>();
        abstractProductIterator.forEachRemaining(allAbstractProducts::add);
        return allAbstractProducts;
    }

    static AbstractProduct findAbstractProductById(AbstractRepository abstractRepository, String id){
        return abstractRepository.findById(id);
    }
}

abstract class DeleteAbstractProduct{
    static void deleteAbstractProductById(AbstractRepository abstractRepository, String id){
        abstractRepository.delete(id);
    }
}

abstract class UpdateAbstractProduct{
    static void updateAbstractProductById(AbstractRepository abstractRepository, String id, AbstractProduct abstractProduct){
        abstractRepository.update(id, abstractProduct);
    }
}
