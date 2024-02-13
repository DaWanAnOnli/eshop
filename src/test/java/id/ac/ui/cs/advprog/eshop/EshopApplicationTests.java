package id.ac.ui.cs.advprog.eshop;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EshopApplicationTests {

    @Test
    void contextLoads() {
        String args[] = new String[0];
        ConfigurableApplicationContext context = SpringApplication.run(EshopApplication.class, args);
        assertTrue(context.isRunning());
    }

}
