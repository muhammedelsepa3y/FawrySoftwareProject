package FawrySoftwareSystem.Phase2.UserServices.Data.MobileRecharge;

public class OrangeMobileRecharge  extends MobileRecharge {


    public OrangeMobileRecharge(String mobileNumber, double amount) {
        super(mobileNumber, amount,"Orange");
    }
  public String getName() {
        return "Orange";
    }

}