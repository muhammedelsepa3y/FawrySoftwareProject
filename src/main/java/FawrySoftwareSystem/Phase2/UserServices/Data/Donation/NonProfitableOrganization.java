package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation;

public class NonProfitableOrganization extends Donations {


    public NonProfitableOrganization(String MobileNumber, double amount) {
        super(MobileNumber, amount, "Non Profitable Organization");
    }
    public String getName() {
        return "Non Profitable Organization";
    }
}
