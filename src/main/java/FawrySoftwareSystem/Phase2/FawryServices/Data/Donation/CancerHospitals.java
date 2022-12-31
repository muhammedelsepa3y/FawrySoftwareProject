package FawrySoftwareSystem.Phase2.FawryServices.Data.Donation;

public class CancerHospitals extends Donations {

        public CancerHospitals(String MobileNumber, double amount) {
            super(MobileNumber, amount, "Cancer Hospitals");
        }

        public String getName() {
            return "Cancer Hospitals";
        }


}
