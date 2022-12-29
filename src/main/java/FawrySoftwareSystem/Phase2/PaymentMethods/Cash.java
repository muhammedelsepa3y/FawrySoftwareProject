package FawrySoftwareSystem.Phase2.PaymentMethods;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;

public class Cash implements IPayment {
    @Override
    public String pay(TransactionModel transactionModel, UserModel user) {
        return "you will pay by cash when you receive your order " +transactionModel.getAmount()+" $";
    }


}
