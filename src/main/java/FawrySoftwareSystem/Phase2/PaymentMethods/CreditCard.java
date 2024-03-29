package FawrySoftwareSystem.Phase2.PaymentMethods;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;

public class CreditCard implements IPayment {
    @Override
    public String pay(TransactionModel transactionModel, UserModel user) {
        user.addTransaction(transactionModel);
        return "you have successfully paid by credit card "+transactionModel.getAmount()+" $";
    }

}