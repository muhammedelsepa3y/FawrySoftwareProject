public interface IInternetPayment {
    public void Recharge(UserModel user);
    public String GetInternetName();
    public boolean isAcceptedCash();
    public void  setAcceptedCash(boolean isAcceptedCash);
}
