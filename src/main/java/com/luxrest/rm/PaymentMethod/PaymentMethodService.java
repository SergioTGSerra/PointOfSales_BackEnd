package com.luxrest.rm.PaymentMethod;

import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

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
        PaymentMethod existingPaymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment Method not found"));
        existingPaymentMethod.setName(paymentMethod.getName());
        existingPaymentMethod.setDescription(paymentMethod.getDescription());
        existingPaymentMethod.setIsActive(paymentMethod.getIsActive());
        return paymentMethodRepository.save(existingPaymentMethod);
    }

    public PaymentMethod deletePaymentMethod(Integer id){
        PaymentMethod deletedPaymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment Method not found"));
        deletedPaymentMethod.setIsDeleted(true);
        return paymentMethodRepository.save(deletedPaymentMethod);
    }
}