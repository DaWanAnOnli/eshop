package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    /**
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run by Spring Framework's test context.
     */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createProductFunction_isCorrect(ChromeDriver driver) throws Exception{
        //Exercise
        driver.get(baseUrl + "/product/create");

        // input product name
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.clear();
        String productName = "Shampoo";
        productNameInput.sendKeys(productName);

        // input product quantity
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.clear();
        String productQuantity = "100";
        productQuantityInput.sendKeys(productQuantity);

        // submit
        WebElement checkInput = driver.findElement(By.id("submitForm"));
        checkInput.click();

        // check display value
        String productNameDisplayed = driver.findElement(By.id("productName")).getText();
        assertEquals(productName, productNameDisplayed);
        String productQuantityDisplayed = driver.findElement(By.id("productQuantity")).getText();
        assertEquals(productQuantity, productQuantityDisplayed);
    }

}


