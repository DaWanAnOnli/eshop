package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.AbstractProduct;
import id.ac.ui.cs.advprog.eshop.model.Car;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util. UUID;


abstract class CreateAbstractProduct{
    public static AbstractProduct createAbstractProduct(List<AbstractProduct> data, AbstractProduct abstractProduct){
        if(abstractProduct.getId() == null){
            UUID uuid = UUID.randomUUID();
            abstractProduct.setId(uuid.toString());
        }
        data.add(abstractProduct);
        return abstractProduct;
    }
}

abstract class FindAbstractProduct{
    public static Iterator<AbstractProduct> findAllAbstractProducts(List<AbstractProduct> data){
        return data.iterator();
    }

    public static AbstractProduct findAbstractProductById(List<AbstractProduct> data, String id){
        for (AbstractProduct abstractProduct : data){
            if (abstractProduct.getId().equals(id)){
                return abstractProduct;
            }
        }
        return null;
    }

}

abstract class DeleteAbstractProduct{
    public static void deleteAbstractProduct(List<AbstractProduct> data, String id){
        data.removeIf(car -> car.getId().equals(id));
    }
}

abstract class UpdateAbstractProduct{
    public static AbstractProduct updateAbstractProduct(List<AbstractProduct> data, String id, AbstractProduct updatedAbstractProduct){
        for (int i = 0; i < data.size(); i++){
            AbstractProduct oldAbstractProduct = data.get(i);
            if (oldAbstractProduct.getId().equals(id)) {
                data.set(i, updatedAbstractProduct);
                return updatedAbstractProduct;
            };
        };
        return null;
    };
}


@Getter
public abstract class AbstractRepository{
    List<AbstractProduct> data = new ArrayList<>();

    public AbstractProduct create(AbstractProduct abstractProduct){
        CreateAbstractProduct.createAbstractProduct(data, abstractProduct);
        return abstractProduct;
    }

    public Iterator<AbstractProduct> findAll(){
        return FindAbstractProduct.findAllAbstractProducts(data);
    }

    public AbstractProduct findById(String id){
        return FindAbstractProduct.findAbstractProductById(data, id);
    }


    public void delete(String id){
        DeleteAbstractProduct.deleteAbstractProduct(data, id);
    }

    public AbstractProduct update(String id, AbstractProduct updatedAbstractProduct){
        return UpdateAbstractProduct.updateAbstractProduct(data, id, updatedAbstractProduct);
    };


}
