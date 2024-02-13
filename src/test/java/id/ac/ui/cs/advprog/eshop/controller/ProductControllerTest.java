package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    Model model;
    ProductController productController;
    Product product;

    @BeforeEach
    void setUp() {
        model = new BindingAwareConcurrentModel();
        productController = new ProductController();
        ProductServiceImpl service = new ProductServiceImpl();
        ProductRepository productRepository = new ProductRepository();

        ReflectionTestUtils.setField(service, "productRepository", productRepository);
        ReflectionTestUtils.setField(productController, "service", service);

        product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
    }

    @Test
    void testCreateProductPage(){
        String result = productController.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void testCreateProductPost(){
        String result = productController.createProductPost(product, model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testEditProductPage(){
        String result = productController.editProductPage(model, product.getProductId());
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPost(){
        String result = productController.editProductPost(product, model);
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testDeleteProduct(){
        String result = productController.deleteProduct(product.getProductId());
        assertEquals("redirect:/product/list", result);
    }


    @Test
    void testProductListPage(){
        String result = productController.productListPage(model);
        assertEquals("ListProduct", result);
    }


}