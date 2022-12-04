public class NonProfitableOrganizationDonation implements IDonation{
    private static NonProfitableOrganizationDonation instance = null;
    private boolean isAcceptedCash = true;
    private NonProfitableOrganizationDonation(){}
    public static NonProfitableOrganizationDonation getInstance(){
        if(instance == null){
            instance = new NonProfitableOrganizationDonation();
        }
        return instance;
    }





    @Override
    public void Recharge(UserModel user) {

    }

    @Override
    public String GetDonationName() {
        return "Non Profitable Organization Donation";
    }

    @Override
    public boolean isAcceptedCash() {
        return isAcceptedCash;
    }

    @Override
    public void setAcceptedCash(boolean isAcceptedCash) {
        this.isAcceptedCash = isAcceptedCash;
    }
}
