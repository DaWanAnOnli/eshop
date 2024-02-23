package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.repository.AbstractRepository;
import id.ac.ui.cs.advprog.eshop.repository.AbstractRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class AbstractService<SpecificProduct extends AbstractProduct, SpecificRepository
        extends AbstractRepository<SpecificProduct>>
        implements AbstractServiceInterface<SpecificProduct, SpecificRepository> {

    //the error warning below can apparently be ignored
    // https://stackoverflow.com/questions/26889970/intellij-incorrectly-saying-no-beans-of-type-found-for-autowired-repository
    @Autowired
    private SpecificRepository specificRepository;

    public SpecificProduct create(SpecificProduct specificProduct){
        CreateSpecificProductInterface.createSpecificProduct(specificRepository, specificProduct);
        return specificProduct;
    }

    public SpecificProduct findSpecificProductById(String id){
        return(FindSpecificProductInterface.findSpecificProductById(specificRepository, id));
    }

    public void delete(String id){
        DeleteSpecificProductInterface.deleteSpecificProductById(specificRepository, id);
    }

    public List<SpecificProduct> findAll(){
        return(FindSpecificProductInterface.findAllSpecificProducts(specificRepository));
    }

    public void update(String id, SpecificProduct specificProduct){
        UpdateSpecificProductInterface.updateSpecificProductById(specificRepository, id, specificProduct);
    }
}


