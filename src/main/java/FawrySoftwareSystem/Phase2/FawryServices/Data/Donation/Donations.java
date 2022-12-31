package FawrySoftwareSystem.Phase2.FawryServices.Data.Donation;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;
import FawrySoftwareSystem.Phase2.PaymentMethods.PaymentFactory;

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
