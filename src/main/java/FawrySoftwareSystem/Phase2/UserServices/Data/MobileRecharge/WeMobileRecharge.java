package FawrySoftwareSystem.Phase2.UserServices.Data.MobileRecharge;

public class WeMobileRecharge extends MobileRecharge {


    public WeMobileRecharge(String mobileNumber, double amount) {

        super(mobileNumber, amount,"We");


    }
    public String getName() {
        return "We";
    }

}
