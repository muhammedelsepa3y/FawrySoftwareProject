package com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods;

import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.TransactionModel;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.UserModel;

public interface IPayment {
    public String pay(TransactionModel transactionModel, UserModel user);

}
