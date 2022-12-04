public class DonationFactory implements IDonationFactory{
    @Override
    public IDonation GetDonation(int DonationID) {
        switch (DonationID) {
            case 1:
                return CancerHospitalsDonation.getInstance();
            case 2:
                return NonProfitableOrganizationDonation.getInstance();
            case 3:
                return SchoolDonation.getInstance();
            default:
                return null;
        }
    }
}
