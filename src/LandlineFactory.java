public class LandlineFactory implements ILandlineFactory
{
    public ILandlinePayment GetLandLinePayment(int LandLinePaymentID) {
        switch (LandLinePaymentID) {
            case 1:
                return QuarterReceiptLandline.getInstance();
            case 2:
                return MonthlyReceiptLandline.getInstance();
            default:
                return null;
        }
    }

}
