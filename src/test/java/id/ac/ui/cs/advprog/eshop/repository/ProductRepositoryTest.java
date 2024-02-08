package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp(){
    }
    @Test
    void testCreateAndFind(){
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
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindProductByIdPositive(){
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product productFound = productRepository.findProductById("1");
        assertEquals(product2, productFound);
    }
    @Test
    void testFindProductByIdNegative() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);


        Product productFound = productRepository.findProductById(product.getProductId()+" ");
        assertNull(productFound);
    }

    @Test
    void testDelete(){
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.delete(product.getProductId());
        Product foundProduct = productRepository.findProductById(product.getProductId());
        assertNull(foundProduct);
    }

    @Test
    void testEdit(){
        Product old_product = new Product();
        old_product.setProductName("Sampo Cap Bambang");
        old_product.setProductQuantity(100);
        productRepository.create(old_product);

        Product new_product = new Product();
        new_product.setProductId(old_product.getProductId());
        new_product.setProductName("Sampo Cap Usep");
        new_product.setProductQuantity(50);
        productRepository.editProduct(new_product);

        Product product_found = productRepository.findProductById(old_product.getProductId());
        assertEquals(new_product, product_found);
        assertEquals(new_product.getProductId(), product_found.getProductId());
        assertEquals(new_product.getProductName(), product_found.getProductName());
        assertEquals(new_product.getProductQuantity(), product_found.getProductQuantity());
    }
}
