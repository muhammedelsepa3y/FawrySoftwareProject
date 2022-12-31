package FawrySoftwareSystem.Phase2.FawryServices.Data.Factory;

import FawrySoftwareSystem.Phase2.FawryServices.Data.Donation.Donations;
import FawrySoftwareSystem.Phase2.FawryServices.Data.InternetPayment.InternetPayment;
import FawrySoftwareSystem.Phase2.FawryServices.Data.LandlinePayment.LandlinePayment;
import FawrySoftwareSystem.Phase2.FawryServices.Data.MobileRecharge.MobileRecharge;

public interface PaybillFactory {
    public MobileRecharge getMobileRecharge(String MobileNumber, double Amount, String CompanyName);
    public InternetPayment getInternetPayment(String PhoneNumber, double Amount, String CompanyName);
    public Donations getDonation(String MobileNumber, double Amount, String CompanyName);
    public LandlinePayment getLandlinePayment(String PhoneNumber, double Amount, String CompanyName);


}
