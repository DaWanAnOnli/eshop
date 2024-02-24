package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public interface AbstractRepositoryInterface<SpecificProduct extends AbstractProduct> {
    SpecificProduct create(SpecificProduct specificProduct);
    Iterator<SpecificProduct> findAll();
    public SpecificProduct findById(String id);
    public void delete(String id);
    public SpecificProduct update(String id, SpecificProduct updatedSpecificProduct);
}


interface CreateSpecificProductInterface{
    public static <SpecificProduct extends AbstractProduct> SpecificProduct
    createSpecificProduct(List<SpecificProduct> data, SpecificProduct specificProduct){
        if(specificProduct.getId() == null){
            UUID uuid = UUID.randomUUID();
            specificProduct.setId(uuid.toString());
        }
        data.add(specificProduct);
        return specificProduct;
    }
}
interface FindSpecificProductInterface{
    public static <SpecificProduct extends AbstractProduct> Iterator<SpecificProduct>
    findAllSpecificProducts(List<SpecificProduct> data){
        return data.iterator();
    }

    public static <SpecificProduct extends AbstractProduct> SpecificProduct
    findSpecificProductById(List<SpecificProduct> data, String id){
        for (SpecificProduct specificProduct : data){
            if (specificProduct.getId().equals(id)){
                return specificProduct;
            }
        }
        return null;
    }

}

interface DeleteSpecificProductInterface{
    public static <SpecificProduct extends AbstractProduct> void
    deleteSpecificProduct(List<SpecificProduct> data, String id){
        data.removeIf(specificProduct -> specificProduct.getId().equals(id));
    }
}


interface UpdateSpecificProductInterface{
    public static <SpecificProduct extends AbstractProduct> SpecificProduct
    updateSpecificProduct(List<SpecificProduct> data, String id, SpecificProduct updatedSpecificProduct){
        for (int i = 0; i < data.size(); i++){
            SpecificProduct oldSpecificProduct = data.get(i);
            if (oldSpecificProduct.getId().equals(id)) {
                data.set(i, updatedSpecificProduct);
                return updatedSpecificProduct;
            };
        };
        return null;
    };
}