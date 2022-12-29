package FawrySoftwareSystem.Phase2.PaymentMethods;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;

public class Wallet implements IPayment {

    @Override
    public String pay(TransactionModel transactionModel, UserModel user) {
        if(user.getWallet()>=transactionModel.getAmount()){
            user.addTransaction(transactionModel);
            user.deductWallet(transactionModel.getAmount());
            return "you have successfully paid by wallet " + transactionModel.getAmount() + " $";
        }
        else{
            return "you don't have enough money in your wallet";
        }

    }

}