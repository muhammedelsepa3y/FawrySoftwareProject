package FawrySoftwareSystem.Phase2.PaymentMethods;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;

public interface IPayment {
    public String pay(TransactionModel transactionModel, UserModel user);

}
