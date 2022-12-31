package FawrySoftwareSystem.Phase2.FawryServices.Data.Donation;

public class NonProfitableOrganization extends Donations {


    public NonProfitableOrganization(String MobileNumber, double amount) {
        super(MobileNumber, amount, "Non Profitable Organization");
    }
    public String getName() {
        return "Non Profitable Organization";
    }
}
