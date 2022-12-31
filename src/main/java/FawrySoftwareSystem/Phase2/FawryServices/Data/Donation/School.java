package FawrySoftwareSystem.Phase2.FawryServices.Data.Donation;

public class School extends Donations {

        public School(String MobileNumber, double amount) {
            super(MobileNumber, amount, "School");
        }

        public String getName() {
            return "School";
        }

}
