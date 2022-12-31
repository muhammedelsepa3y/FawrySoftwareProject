package FawrySoftwareSystem.Phase2.FawryServices.Data.LandlinePayment;

public class QuarterReceipt extends LandlinePayment {


    public QuarterReceipt(String PhoneNumber, double amount) {
        super(PhoneNumber, amount, "Quarter Receipt");
    }
    public String getName() {
        return "Quarter Receipt";
    }
}
