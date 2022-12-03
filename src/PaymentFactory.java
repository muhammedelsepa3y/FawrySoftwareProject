import java.util.ArrayList;
import java.util.List;

public class PaymentFactory implements IPaymentFactory
{

    public IPayment GetPayment(int PaymentID) {
        // Singleton PATTERN

        switch (PaymentID) {
            case 1:
                return CreditCardPay.getInstance();
            case 2:
                return WalletPay.getInstance() ;
            case 3:
                return CashPayment.getInstance();

            default:
                return null;
        }
    }


}
