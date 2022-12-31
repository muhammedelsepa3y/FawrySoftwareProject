package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Factory;


import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation.Donations;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.InternetPayment.InternetPayment;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.LandlinePayment.LandlinePayment;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.MobileRecharge.MobileRecharge;

import java.util.List;
import java.util.Map;

public interface PaybillFactory {
    public MobileRecharge getMobileRecharge(String MobileNumber, double Amount, String CompanyName);
    public InternetPayment getInternetPayment(String PhoneNumber, double Amount, String CompanyName);
    public Donations getDonation(String MobileNumber, double Amount, String CompanyName);
    public LandlinePayment getLandlinePayment(String PhoneNumber, double Amount, String CompanyName);


}
