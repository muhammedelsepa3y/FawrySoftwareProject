import java.util.ArrayList;
import java.util.List;
public class FawryFactory implements IFawryFactory{
    public List<String> GetFeatures() {
        List<String> features = new ArrayList<>();
        features.add("Mobile Recharge");
        features.add("Internet");
        features.add("Landline");
        features.add("Donation");
        return features;
    }

	@Override
	public List<String> GetServices() {
		List<String> services = new ArrayList<String>();
        DonationFactory donationFactory = new DonationFactory();
        InternetFactory internetFactory = new InternetFactory();
        MobileRechargeFactory mobileRechargeFactory = new MobileRechargeFactory();
        LandlineFactory landlineFactory = new LandlineFactory();

        int j=1;
        IMobileRecharge temp=mobileRechargeFactory.GetMobileRecharge(j);
        while (temp != null) {
            services.add(temp.GetMobileRechargeName());
            j++;
            temp = mobileRechargeFactory.GetMobileRecharge(j);
        }
        j=1;
        IInternetPayment temp3=internetFactory.GetInternetPayment(j);
        while (temp3 != null) {
            services.add(temp3.GetInternetName());
            j++;
            temp3 = internetFactory.GetInternetPayment(j);
        }
        j=1;
        IDonation temp2=donationFactory.GetDonation(j);
        while (temp2 != null) {
            services.add(temp2.GetDonationName());
            j++;
            temp2 = donationFactory.GetDonation(j);
        }
        j=1;
        ILandlinePayment temp4=landlineFactory.GetLandLinePayment(j);
        while (temp4!= null) {
            services.add(temp4.GetLandlineName());
            j++;
            temp4 = landlineFactory.GetLandLinePayment(j);
        }
        return services;
	}
}
