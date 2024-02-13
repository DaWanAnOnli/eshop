package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
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
