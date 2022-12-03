public class CashPayment implements IPayment{
private static CashPayment instance=null;
    private CashPayment() {
    }
    public static CashPayment getInstance() {
        if(instance==null) {
            instance=new CashPayment();
        }
        return instance;
    }
    private  boolean isActivated = false;
    @Override
    public  boolean isActivated() {
        return isActivated;
    }
    @Override
    public  void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    @Override
    public boolean Pay(int Amount, UserModel user) {
        System.out.println("Paying " + Amount + " using Cash");
        return true;
    }

    @Override
    public String GetPaymentName() {
        return "Cash";
    }
}
