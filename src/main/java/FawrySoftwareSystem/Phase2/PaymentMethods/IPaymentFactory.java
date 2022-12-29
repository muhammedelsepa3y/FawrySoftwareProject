package FawrySoftwareSystem.Phase2.PaymentMethods;

import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;

public interface IPaymentFactory {
    public IPayment getPaymentMethod(String paymentMethod);
}

