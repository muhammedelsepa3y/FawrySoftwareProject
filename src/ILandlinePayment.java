public interface ILandlinePayment {
    public void Recharge( UserModel user);
    public String GetLandlineName();
    public boolean isAcceptedCash();
    public void  setAcceptedCash(boolean isAcceptedCash);
}
