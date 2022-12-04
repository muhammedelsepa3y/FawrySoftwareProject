public interface IMobileRecharge {
    public void Recharge(UserModel user);
    public String GetMobileRechargeName();
    public boolean isAcceptedCash();
    public void  setAcceptedCash(boolean isAcceptedCash);
}

