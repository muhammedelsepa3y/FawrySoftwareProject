package com.fci.advanced.sw.fawrysoftwaresystem.UserServices.Data.Donation;

public class School extends Donations {

        public School(String MobileNumber, double amount) {
            super(MobileNumber, amount, "School");
        }

        public String getName() {
            return "School";
        }

}
