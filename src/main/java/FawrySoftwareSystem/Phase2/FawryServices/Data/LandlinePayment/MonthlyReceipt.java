package FawrySoftwareSystem.Phase2.FawryServices.Data.LandlinePayment;

public class MonthlyReceipt extends LandlinePayment {


    public MonthlyReceipt(String PhoneNumber, double amount) {
        super(PhoneNumber, amount, "Monthly Receipt");
    }
    public String getName() {
        return "Monthly Receipt";
    }
}
