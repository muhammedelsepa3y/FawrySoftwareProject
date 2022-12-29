package com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods;

import com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods.IPayment;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.TransactionModel;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.UserModel;


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