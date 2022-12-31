package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation;

public class CancerHospitals extends Donations {

        public CancerHospitals(String MobileNumber, double amount) {
            super(MobileNumber, amount, "Cancer Hospitals");
        }

        public String getName() {
            return "Cancer Hospitals";
        }


}
