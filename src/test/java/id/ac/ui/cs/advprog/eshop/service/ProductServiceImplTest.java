package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    ProductServiceImpl productService;
    Product product;
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();
        productRepository = new ProductRepository();
        ReflectionTestUtils.setField(productService, "productRepository", productRepository);

        product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testCreate(){
        Product result = productService.create(product);
        assertEquals(product, result);
    }

    @Test
    void testFindProductById(){
        productService.create(product);
        Product result = productService.findProductById(product.getProductId());
        assertEquals(product, result);
    }

    @Test
    void testDelete(){
        productService.delete(product.getProductId());
        Product result = productRepository.findProductById(product.getProductId());
        assertNull(result);
    }

    @Test
    void testFindAll() {
        productService.create(product);
        List<Product> allProducts = productService.findAll();
        assertEquals(allProducts.getFirst(), product);
    }


    @Test
    void testEditProduct(){
        productService.create(product);
        Product result = productService.editProduct(product);
        assertEquals(product, result);
    }
}
