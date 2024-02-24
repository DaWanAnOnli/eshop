package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.model.Car;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util. UUID;


@Getter
public abstract class AbstractRepository <SpecificProduct extends AbstractProduct>
implements AbstractRepositoryInterface<SpecificProduct> {


    List<SpecificProduct> data = new ArrayList<>();

    public SpecificProduct create(SpecificProduct specificProduct){
        CreateSpecificProductInterface.createSpecificProduct(data, specificProduct);
        return specificProduct;
    }

    public Iterator<SpecificProduct> findAll(){
        return FindSpecificProductInterface.findAllSpecificProducts(data);
    }

    public SpecificProduct findById(String id){
        return FindSpecificProductInterface.findSpecificProductById(data, id);
    }


    public void delete(String id){
        DeleteSpecificProductInterface.deleteSpecificProduct(data, id);
    }

    public SpecificProduct update(String id, SpecificProduct updatedSpecificProduct){
        return UpdateSpecificProductInterface.updateSpecificProduct(data, id, updatedSpecificProduct);
    };


}
