package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import id.ac.ui.cs.advprog.eshop.controller.ProductController;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MainControllerTest {
    Model model;
    MainController mainController;

    @BeforeEach
    void setUp(){
        model = new BindingAwareConcurrentModel();
        mainController = new MainController();
    }

    @Test
    void testMainPage(){
        String result = mainController.mainPage(model);
        assertEquals("Main", result);
    }
}
