package com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods;

public interface IPaymentFactory {
    public IPayment getPaymentMethod(String paymentMethod);
}

