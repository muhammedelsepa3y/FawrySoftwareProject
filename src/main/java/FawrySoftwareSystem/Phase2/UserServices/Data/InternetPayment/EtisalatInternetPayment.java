package FawrySoftwareSystem.Phase2.UserServices.Data.InternetPayment;


public class EtisalatInternetPayment extends InternetPayment {
    public EtisalatInternetPayment(String PhoneNumber, double amount) {
        super(PhoneNumber, amount,"Etisalat");
    }
    public String getName() {
        return "Etisalat";
    }

}