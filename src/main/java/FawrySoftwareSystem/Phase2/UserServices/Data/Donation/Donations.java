package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation;

import com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods.IPayment;
import com.fci.advanced.sw.fawrysoftwaresystem.PaymentMethods.PaymentFactory;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.TransactionModel;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.UserModel;

public abstract class Donations {
    String MobileNumber;
    double Amount;
    public  static boolean isAcceptCash=false;
    private String companyName;
    public Donations(String MobileNumber, double amount, String companyNamy){
        this.MobileNumber=MobileNumber;
        this.Amount=amount;
        this.companyName=companyNamy;
    }

    public String getName(){
        return "Donation";
    };

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String phoneNumber) {
        MobileNumber = phoneNumber;
    }

    public static void setAcceptCash(boolean acceptCash) {
        isAcceptCash = acceptCash;
    }

    public static boolean isAcceptCash() {
        return isAcceptCash;
    }
    public String pay(TransactionModel transaction, UserModel user){
        PaymentFactory paymentFactory = new PaymentFactory();
        IPayment payy=paymentFactory.getPaymentMethod(transaction.getPaymentMethod());
        if(transaction.getPaymentMethod().equals("Cash")){
            if(!isAcceptCash){
                return "Cash is not accepted";
            }
            return payy.pay(transaction, user) + " for " + transaction.getServiceName() ;
        }
        else{
            return payy.pay(transaction, user) + " for " + transaction.getServiceName() ;
        }
    }
}
