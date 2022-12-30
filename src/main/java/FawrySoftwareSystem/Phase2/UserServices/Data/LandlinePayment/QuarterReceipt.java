package FawrySoftwareSystem.Phase2.UserServices.Data.LandlinePayment;

public class QuarterReceipt extends LandlinePayment {


    public QuarterReceipt(String PhoneNumber, double amount) {
        super(PhoneNumber, amount, "Quarter Receipt");
    }
    public String getName() {
        return "Quarter Receipt";
    }
}
