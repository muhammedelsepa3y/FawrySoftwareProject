package FawrySoftwareSystem.Phase2.UserServices.Data.MobileRecharge;

public class VodafoneMobileRecharge  extends MobileRecharge {


    public VodafoneMobileRecharge(String mobileNumber, double amount) {

        super(mobileNumber, amount,"Vodafone");

    }
    public String getName() {
        return "Vodafone";
    }


}