package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Factory;

import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation.Donations;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation.School;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.InternetPayment.*;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.LandlinePayment.LandlinePayment;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.LandlinePayment.MonthlyReceipt;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.LandlinePayment.QuarterReceipt;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.MobileRecharge.*;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation.CancerHospitals;
import com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation.NonProfitableOrganization;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayFactory implements PaybillFactory {

    @Override
    public MobileRecharge getMobileRecharge(String MobileNumber, double Amount, String CompanyName) {
        if(CompanyName.equals("Vodafone")){
            return new VodafoneMobileRecharge(MobileNumber,Amount);
        }
        else if(CompanyName.equals("Etisalat")){
            return new EtisalatMobileRecharge(MobileNumber,Amount);

        }else if(CompanyName.equals("Orange")){
            return new OrangeMobileRecharge(MobileNumber,Amount);
        }else if (CompanyName.equals("We")){
            return new WeMobileRecharge(MobileNumber,Amount);
        }
        return null;
    }

    @Override
    public InternetPayment getInternetPayment(String PhoneNumber, double Amount, String CompanyName) {
        if(CompanyName.equals("Vodafone")){
            return new VodafoneInternetPayment(PhoneNumber,Amount);
        }
        else if(CompanyName.equals("Etisalat")){
            return new EtisalatInternetPayment(PhoneNumber,Amount);

        }else if(CompanyName.equals("Orange")){
            return new OrangeInternetPayment(PhoneNumber,Amount);
        }else if (CompanyName.equals("We")){
            return new WeInternetPayment(PhoneNumber,Amount);
        }
        return null;
    }

    @Override
    public Donations getDonation(String MobileNumber, double Amount, String CompanyName) {
        if(CompanyName.equals("School")){
            return new School(MobileNumber,Amount);
        }else if (CompanyName.equals("Non Profitable Organization")){
            return new NonProfitableOrganization(MobileNumber,Amount);
        }else if (CompanyName.equals("Cancer Hospitals")){
            return new CancerHospitals(MobileNumber,Amount);
        }
        return null;
    }

    @Override
    public LandlinePayment getLandlinePayment(String PhoneNumber, double Amount, String CompanyName) {
        if(CompanyName.equals("Quarter Receipt")){
            return new QuarterReceipt(PhoneNumber,Amount);
        }
        else if(CompanyName.equals("Monthly Receipt")){
            return new MonthlyReceipt(PhoneNumber,Amount);

        }
        return null;
    }



    public List<String> getAllServices() {
        List<String> services = new ArrayList<String>();
        MobileRecharge temp=getMobileRecharge("01000000000", 10, "Vodafone");
        services.add("Mobile Recharge : "+ temp.getName());
        MobileRecharge temp2=getMobileRecharge("01000000000", 10, "Etisalat");
        services.add("Mobile Recharge : "+ temp2.getName());
        MobileRecharge temp3=getMobileRecharge("01000000000", 10, "Orange");
        services.add("Mobile Recharge : "+ temp3.getName());
        MobileRecharge temp4=getMobileRecharge("01000000000", 10, "We");
        services.add("Mobile Recharge : "+ temp4.getName());
        InternetPayment temp5=getInternetPayment("01000000000", 10, "Vodafone");
        services.add("Internet Payment : "+ temp5.getName());
        InternetPayment temp6=getInternetPayment("01000000000", 10, "Etisalat");
        services.add("Internet Payment : "+ temp6.getName());
        InternetPayment temp7=getInternetPayment("01000000000", 10, "Orange");
        services.add("Internet Payment : "+ temp7.getName());
        InternetPayment temp8=getInternetPayment("01000000000", 10, "We");
        services.add("Internet Payment : "+ temp8.getName());
        Donations temp9=getDonation("01000000000", 10, "School");
        services.add("Donation : "+ temp9.getName());
        Donations temp10=getDonation("01000000000", 10, "Non Profitable Organization");
        services.add("Donation : "+ temp10.getName());
        Donations temp11=getDonation("01000000000", 10, "Cancer Hospitals");
        services.add("Donation : "+ temp11.getName());
        LandlinePayment temp12=getLandlinePayment("01000000000", 10, "Quarter Receipt");
        services.add("Landline Payment : "+ temp12.getName());
        LandlinePayment temp13=getLandlinePayment("01000000000", 10, "Monthly Receipt");
        services.add("Landline Payment : "+ temp13.getName());
        return services;
    }


    public List<String> getAllFeatures() {
        List<String> features = new ArrayList<>();
        features.add("Mobile Recharge");
        features.add("Internet Payment");
        features.add("Donation");
        features.add("Landline Payment");
        return features;
    }


}
