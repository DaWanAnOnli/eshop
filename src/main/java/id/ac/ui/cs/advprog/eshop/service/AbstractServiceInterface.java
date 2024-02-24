package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.repository.AbstractRepository;
import id.ac.ui.cs.advprog.eshop.repository.AbstractRepositoryInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface AbstractServiceInterface<SpecificProduct extends AbstractProduct, SpecificRepository
        extends AbstractRepositoryInterface<SpecificProduct>>  {
    public SpecificProduct create(SpecificProduct specificProduct);
    public SpecificProduct findSpecificProductById(String id);
    public void delete(String id);
    public List<SpecificProduct> findAll();
    public void update(String id, SpecificProduct specificProduct);
}


interface CreateSpecificProductInterface{
    static <SpecificProduct extends AbstractProduct, SpecificRepository extends AbstractRepository<SpecificProduct>>
    SpecificProduct createSpecificProduct(SpecificRepository specificRepository, SpecificProduct specificProduct){
        specificRepository.create(specificProduct);
        return specificProduct;
    }
}

interface FindSpecificProductInterface{
    static <SpecificProduct extends AbstractProduct, SpecificRepository extends AbstractRepository<SpecificProduct>>
    List<SpecificProduct> findAllSpecificProducts(SpecificRepository specificRepository){
        Iterator<SpecificProduct> specificProductIterator = specificRepository.findAll();
        List<SpecificProduct> allSpecificProducts = new ArrayList<>();
        specificProductIterator.forEachRemaining(allSpecificProducts::add);
        return allSpecificProducts;
    }

    static <SpecificProduct extends AbstractProduct, SpecificRepository extends AbstractRepository<SpecificProduct>>
    SpecificProduct findSpecificProductById(SpecificRepository specificRepository, String id){
        return specificRepository.findById(id);
    }
}

interface DeleteSpecificProductInterface{
    static <SpecificProduct extends AbstractProduct, SpecificRepository extends AbstractRepository<SpecificProduct>>
    void deleteSpecificProductById(SpecificRepository specificRepository, String id){
        specificRepository.delete(id);
    }
}

interface UpdateSpecificProductInterface{
    static <SpecificProduct extends AbstractProduct, SpecificRepository extends AbstractRepository<SpecificProduct>>
    void updateSpecificProductById(SpecificRepository specificRepository, String id, SpecificProduct specificProduct){
        specificRepository.update(id, specificProduct);
    }
}