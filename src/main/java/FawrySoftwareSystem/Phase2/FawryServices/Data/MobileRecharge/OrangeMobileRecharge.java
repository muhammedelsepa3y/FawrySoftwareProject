package FawrySoftwareSystem.Phase2.FawryServices.Data.MobileRecharge;

public class OrangeMobileRecharge  extends MobileRecharge {


    public OrangeMobileRecharge(String mobileNumber, double amount) {
        super(mobileNumber, amount,"Orange");
    }
  public String getName() {
        return "Orange";
    }

}