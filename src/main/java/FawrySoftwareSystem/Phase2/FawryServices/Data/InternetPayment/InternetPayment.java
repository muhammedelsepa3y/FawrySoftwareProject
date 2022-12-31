package FawrySoftwareSystem.Phase2.FawryServices.Data.InternetPayment;


import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.PaymentMethods.IPayment;
import FawrySoftwareSystem.Phase2.PaymentMethods.PaymentFactory;

public abstract class InternetPayment {
    String PhoneNumber;
    double Amount;
    public  static boolean isAcceptCash=false;
    private String companyName;
    public InternetPayment(String PhoneNumber,double amount,String companyNamy){
        this.PhoneNumber=PhoneNumber;
        this.Amount=amount;
        this.companyName=companyNamy;
    }

    public String getName(){
        return "Internet Payment";
    };

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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
