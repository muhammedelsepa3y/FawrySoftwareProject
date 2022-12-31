package com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods;

import com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods.IPaymentFactory;

public class PaymentFactory implements IPaymentFactory {

    @Override
    public IPayment getPaymentMethod(String paymentMethod) {
        if (paymentMethod.equals("Cash")) {
            return new Cash();
        } else if (paymentMethod.equals("Credit Card")) {
            return new CreditCard();
        } else if (paymentMethod.equals("Wallet")) {
            return new Wallet();
        } else {
            return null;
        }
    }


}
