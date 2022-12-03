import java.util.Scanner;

public class CreditCardPay implements IPayment {
    private static CreditCardPay instance=null;
    private CreditCardPay() {

    }
    public static CreditCardPay getInstance() {
        if(instance==null) {
            instance=new CreditCardPay();
        }
        return instance;
    }
    private  boolean isActivated =true;
    @Override
    public  boolean isActivated() {
        return isActivated;
    }
    @Override
    public  void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }


    public boolean Pay(int amount, UserModel user) {

        System.out.println("Please enter your credit card Number");
        Scanner sc = new Scanner(System.in);
        String cardNumber = sc.nextLine();
        while (cardNumber.length() != 16) {
            System.out.println("Invalid card number");
            System.out.println("Please enter your credit card Number");
            cardNumber = sc.nextLine();

        }
        System.out.println("Please enter your credit card CVV");
        String cvv = sc.nextLine();
        while (cvv.length() != 3) {
            System.out.println("Invalid CVV");
            System.out.println("Please enter your credit card CVV");
            cvv = sc.nextLine();

        }
        System.out.println("Please enter your credit card Expiry Date");
        String expiryDate = sc.nextLine();
        while (expiryDate.length() != 5) {
            System.out.println("Invalid Expiry Date");
            System.out.println("Please enter your credit card Expiry Date");
            expiryDate = sc.nextLine();
        }
        System.out.println("Paying " + amount + " using Credit Card");
        return true;
    }

    @Override
    public String GetPaymentName() {
        return "Credit Card";
    }
}
