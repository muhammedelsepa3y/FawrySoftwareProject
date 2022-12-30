package FawrySoftwareSystem.Phase2.UserServices.Data.InternetPayment;

public class VodafoneInternetPayment extends InternetPayment {
    public VodafoneInternetPayment(String PhoneNumber, double amount) {
        super(PhoneNumber, amount,"Vodafone");
    }

    public String getName() {
        return "Vodafone";
    }

}