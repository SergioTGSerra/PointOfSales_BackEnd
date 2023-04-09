package com.luxrest.rm.PaymentMethod;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/paymentMethods")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;
    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethod();
    }

    @GetMapping("/{id}")
    public PaymentMethod getPaymentMethodById(@PathVariable Integer id){
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping
    public PaymentMethod createPaymentMethod(@RequestBody @Valid PaymentMethod paymentMethod){
        return paymentMethodService.createPaymentMethod(paymentMethod);
    }

    @PutMapping("/{id}")
    public PaymentMethod updatePaymentMethod(@PathVariable Integer id, @RequestBody @Valid PaymentMethod paymentMethod){
        return paymentMethodService.updatePaymentMethod(id, paymentMethod);
    }

    @DeleteMapping("/{id}")
    public PaymentMethod deletePaymentMethod(@PathVariable Integer id){
        return paymentMethodService.deletePaymentMethod(id);
    }
}