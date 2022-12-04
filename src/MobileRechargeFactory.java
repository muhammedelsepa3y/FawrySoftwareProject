public class MobileRechargeFactory implements IMobileRechargeFactory
{
    public IMobileRecharge GetMobileRecharge(int MobileRechargeID) {
        switch (MobileRechargeID) {
            case 1:
                return VodafoneMobile.getInstance();
            case 2:
                return EtisalatMobile.getInstance();
            case 3:
                return OrangeMobile.getInstance();
            case 4:
                return WeMobile.getInstance();
            default:
                return null;
        }
    }


}
