public class InternetFactory implements IInternetFactory{
    @Override
    public IInternetPayment GetInternetPayment(int InternetPaymentID) {
        switch (InternetPaymentID) {
            case 1:
                return VodafoneInternet.getInstance();
            case 2:
                return EtisalatInternet.getInstance();
            case 3:
                return OrangeInternet.getInstance();
            case 4:
                return WeInternet.getInstance();
            default:
                return null;
        }
    }
}
