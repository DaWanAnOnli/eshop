package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.PaymentData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp(){
        paymentRepository = new PaymentRepository();

        payments = new ArrayList<>();

        HashMap<String, String> paymentData1 = PaymentData.getNewVoucherCodeData("ESHOP12345678abc");
        Payment payment1 = new Payment("id-1", "VOUCHER_CODE", paymentData1);
        HashMap<String, String> paymentData2 = PaymentData.getNewCashOnDeliveryData
                ("address-1", "deliveryFee-1");
        Payment payment2 = new Payment("id-2", "CASH_ON_DELIVERY", paymentData2);

        payments.add(payment1);
        payments.add(payment2);
    }

    @Test
    void testAddPayment(){
        Payment payment = payments.get(1);
        Payment result = paymentRepository.addPayment(payment);

        Payment findResult = paymentRepository.getPayment(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testSetStatus(){
        Payment payment = payments.get(1);
        paymentRepository.addPayment(payment);

        Payment result = paymentRepository.setStatus(payment, PaymentStatus.SUCCESS.getValue());
        assertEquals(payment.getId(), result.getId());
        assertEquals(PaymentStatus.SUCCESS.getValue(), result.getStatus());
    }

    @Test
    void testSetStatusWithInvalidPayment(){
        HashMap<String, String> paymentData3 = PaymentData.getNewCashOnDeliveryData
                ("address-1", "deliveryFee-1");
        Payment payment3 = new Payment("id-3", "CASH_ON_DELIVERY", paymentData3);

        assertThrows(IllegalArgumentException.class, () -> {
            Payment result = paymentRepository.setStatus(payment3, PaymentStatus.SUCCESS.getValue());
        });
    }

    @Test
    void testGetPayment(){
        for (Payment payment : payments){
            paymentRepository.addPayment(payment);
        }

        Payment findResult = paymentRepository.getPayment(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
        assertEquals(payments.get(1).getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testGetPaymentInvalidId() {
        for (Payment payment : payments) {
            paymentRepository.addPayment(payment);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            Payment result = paymentRepository.getPayment("HELLO");
        });
    }

    @Test
    void testGetAllPaymentsIfEmpty(){
        Iterator<Payment> paymentIterator = paymentRepository.getAllPayments();
        assertFalse(paymentIterator.hasNext());
    }

    @Test
    void testGetAllPaymentsIfMoreThanOne(){
        int i = 0;
        for (Payment payment : payments){
            paymentRepository.addPayment(payment);
            i += 1;
        }

        Iterator<Payment> paymentIterator = paymentRepository.getAllPayments();
        assertTrue(paymentIterator.hasNext());
        Payment savedPayment = paymentIterator.next();
        assertEquals(payments.getFirst().getId(), savedPayment.getId());
        savedPayment = paymentIterator.next();
        assertEquals(payments.get(1).getId(), savedPayment.getId());
        assertFalse(paymentIterator.hasNext());
    }



}