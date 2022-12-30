package FawrySoftwareSystem.Phase2.UserServices.Data.InternetPayment;

public class OrangeInternetPayment extends InternetPayment {
    public OrangeInternetPayment(String PhoneNumber, double amount) {
        super(PhoneNumber, amount,"Orange");
    }
    public String getName() {
        return "Orange";
    }

}