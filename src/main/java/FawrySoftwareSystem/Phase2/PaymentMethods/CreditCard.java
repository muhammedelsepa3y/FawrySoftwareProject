package com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods;

import com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods.IPayment;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.TransactionModel;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.UserModel;


public class CreditCard implements IPayment {
    @Override
    public String pay(TransactionModel transactionModel, UserModel user) {
        user.addTransaction(transactionModel);
        return "you have successfully paid by credit card "+transactionModel.getAmount()+" $";
    }

}