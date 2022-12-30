package FawrySoftwareSystem.Phase2.UserServices.Data.InternetPayment;

public class WeInternetPayment extends InternetPayment {
    public WeInternetPayment(String PhoneNumber, double amount) {
        super(PhoneNumber, amount,"We");
    }
    public String getName() {
        return "We";
    }

}
