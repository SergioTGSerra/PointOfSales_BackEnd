package com.luxrest.rm.PaymentMethod;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> getAllPaymentMethod(){
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod getPaymentMethodById(Integer id){
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment Method not found: " + id));
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod){
        if(paymentMethod.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod(Integer id, PaymentMethod paymentMethod){
        paymentMethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment Method not found"));
        paymentMethod.setId(id);
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod deletePaymentMethod(Integer id){
        PaymentMethod deletedPaymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment Method not found"));
        deletedPaymentMethod.setIsDeleted(true);
        return paymentMethodRepository.save(deletedPaymentMethod);
    }
}