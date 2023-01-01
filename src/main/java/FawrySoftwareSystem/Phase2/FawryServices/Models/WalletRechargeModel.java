package FawrySoftwareSystem.Phase2.FawryServices.Models;

import java.util.Date;

public class WalletRechargeModel {
    double amount;
    String Date;
    String creditCardNumber;
    String creditCardOwnerName;
    String creditCardExpirationDate;
    String creditCardCVV;
    public WalletRechargeModel(double amount, String creditCardNumber, String creditCardOwnerName, String creditCardExpirationDate, String creditCardCVV) {
        this.amount = amount;
        this.creditCardNumber = creditCardNumber;
        this.creditCardOwnerName = creditCardOwnerName;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.creditCardCVV = creditCardCVV;
        this.Date=new Date().toString();
    }
    public double getAmount() {
        return amount;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public String getCreditCardOwnerName() {
        return creditCardOwnerName;
    }
    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }
    public String getCreditCardCVV() {
        return creditCardCVV;
    }


}
