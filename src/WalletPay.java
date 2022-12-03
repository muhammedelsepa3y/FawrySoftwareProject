public class WalletPay implements IPayment {
    private static WalletPay instance=null;
    private WalletPay() {
    }
    public static WalletPay getInstance() {
        if(instance==null) {
            instance=new WalletPay();
        }
        return instance;
    }
    private  boolean isActivated = true;
    @Override
    public  boolean isActivated() {
        return isActivated;
    }
    @Override
    public  void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public boolean Pay(int amount, UserModel user) {
        if(user.getWallet() >= amount) {
            user.deductWallet(amount);
            return true;
        }else {
            System.out.println("Not enough money in your wallet");
            return false;
        }

    }

    @Override
    public String GetPaymentName() {
        return "Wallet";
    }

}
