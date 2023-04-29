package com.luxrest.rm.PaymentMethod;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/payment-methods")
public class PaymentMethodController {
    @GetMapping
    public List<Payment_Method> getPaymentMethods() {
        return Arrays.asList(Payment_Method.values());
    }
}
