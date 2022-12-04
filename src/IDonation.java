public interface IDonation {
    public void Recharge( UserModel user);
    public String GetDonationName();
    public boolean isAcceptedCash();
    public void  setAcceptedCash(boolean isAcceptedCash);
}
