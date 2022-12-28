package FawrySoftwareSystem.Phase2.Authentication.Model;

import java.util.Date;

public class TransactionModel {
    private String serviceName;
    private double amount;
    private String number;
    private String date;
    private String paymentMethod;
    private String creditCardNumber;
    private String creditCardOwnerName;
    private String creditCardExpirationDate;
    private String creditCardCVV;
    private String featureName;
    private int transactionid;
    public void setId(int transactionid) {
        this.transactionid = transactionid;
    }
    public TransactionModel(String serviceName,String featureName, double amount, String number,String PaymentMethod ,String creditCardNumber, String creditCardOwnerName, String creditCardExpirationDate, String creditCardCVV) {
        this.serviceName = serviceName;
        this.amount = amount;
        this.date = new Date().toString();
        this.number = number;
        this.transactionid=(int)Math.floor(Math.random()*(999999998-1+1)+1);
        this.paymentMethod=PaymentMethod;
        this.creditCardNumber=creditCardNumber;
        this.creditCardOwnerName=creditCardOwnerName;
        this.creditCardExpirationDate=creditCardExpirationDate;
        this.creditCardCVV=creditCardCVV;
        this.featureName=featureName;
    }

    public String getServiceName() {
        return serviceName;
    }
    public double getAmount() {
        return amount;
    }
    public String getNumber() {
        return number;
    }
    public String getDate() {
        return date;
    }
    public int getId() {
        return transactionid;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getFeatureName() {
        return featureName;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }



}
