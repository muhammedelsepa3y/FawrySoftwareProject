package FawrySoftwareSystem.Phase2.UserServices.Data.MobileRecharge;

import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;
import cFawrySoftwareSystem.Phase2.PaymentMethods.IPaymentFactory;
import FawrySoftwareSystem.Phase2.PaymentMethods.PaymentFactory;
import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import cFawrySoftwareSystem.Phase2.Authentication.Model.UserModel;

public abstract class MobileRecharge  {
    private String mobileNumber;
    private double amount;

    private String companyName;
    public static boolean isAcceptCash=false;
    public MobileRecharge(String mobileNumber,double amount,String companyNamy){
        this.mobileNumber=mobileNumber;
        this.amount=amount;
        this.companyName=companyNamy;
    }
    public String getName(){
        return "Mobile Recharge";
    };

    public double getAmount() {
        return amount;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMobileNumber(String number) {
        this.mobileNumber = number;
    }

    public void setAcceptCash(boolean acceptCash) {
        isAcceptCash = acceptCash;
    }

    public boolean isAcceptCash() {
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
