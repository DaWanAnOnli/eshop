package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {
    private List<Product> products;
    List<Order> orders;

    HashMap<String ,String> paymentDataVoucherCode = new HashMap<>();
    HashMap<String ,String> paymentDataCashOnDelivery = new HashMap<>();
    HashMap<String ,String> paymentDataBankTransfer = new HashMap<>();



    @BeforeEach
    void setUp(){
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(2);
        Product product2 = new Product();
        product2.setId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setName("Sabun Cap Usep");
        product2.setQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                products, 1708570000L, "Safira Sudrajat");
        orders.add(order2);

        paymentDataVoucherCode.put("voucherCode", "");
        paymentDataCashOnDelivery.put("address", "");
        paymentDataCashOnDelivery.put("deliveryFee", "");
        paymentDataBankTransfer.put("bankName", "");
        paymentDataBankTransfer.put("referenceCode", "");


    }

    @Test
    void testCreatePaymentDefaultStatus(){
        Payment payment = new Payment("id-1", "VOUCHER_CODE", paymentDataVoucherCode);

        assertEquals("id-1", payment.getId());
        assertEquals("VOUCHER_CODE", payment.getMethod());
        assertEquals("WAITING", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    void testCreatePaymentInvalidMethod(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("id-1", "VOUCHER_CODED", paymentDataVoucherCode);
        });
    }

    void testCreatePaymentInvalidPaymentData(){

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("id-1", "VOUCHER_CODE", paymentDataCashOnDelivery);
        });
    }

    void testCreatePaymentSuccessStatus(){
        Payment payment = new Payment("id-1", "VOUCHER_CODE", "SUCCESS", paymentDataVoucherCode);

        assertEquals("id-1", payment.getId());
        assertEquals("VOUCHER_CODE", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    void testCreatePaymentInvalidStatus(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("id-1", "VOUCHER_CODE", "MEOW", paymentDataCashOnDelivery);
        });
    }

    void testEditPaymentWithCancelledStatus(){
        Payment payment = new Payment("id-1", "VOUCHER_CODE", paymentDataVoucherCode);
        payment.setStatus("CANCELLED");
        assertEquals("CANCELLED", payment.getStatus());
    }

    void testEditPaymentWithCancelledStatus(){
        Payment payment = new Payment("id-1", "VOUCHER_CODE", paymentDataVoucherCode);
        payment.setStatus("MEOW");
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }





}