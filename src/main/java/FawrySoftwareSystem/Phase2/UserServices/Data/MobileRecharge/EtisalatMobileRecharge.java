package FawrySoftwareSystem.Phase2.UserServices.Data.MobileRecharge;

public class EtisalatMobileRecharge extends MobileRecharge {
    public EtisalatMobileRecharge(String mobileNumber, double amount) {
        super(mobileNumber, amount,"Etisalat");
    }

    public String getName() {
        return "Etisalat";
    }

}