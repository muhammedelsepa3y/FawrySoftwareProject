import java.util.ArrayList;
import java.util.List;

public class EtisalatMobile implements IMobileRecharge,Form {
    private static EtisalatMobile instance=null;
    private boolean isAcceptedCash = false;
    private List<TextFieldDecorator> TextFields= new ArrayList<TextFieldDecorator>();
    private List<DropDownDecorator> DropDowns= new ArrayList<DropDownDecorator>();
    private EtisalatMobile() {
        Form form= new TextFieldDecorator(this);
        ((TextFieldDecorator) form).setName("Amount");
        ((TextFieldDecorator) form).setValueInt(0);
        this.TextFields.add((TextFieldDecorator) form);
        form= new TextFieldDecorator(form);
        ((TextFieldDecorator) form).setName("Mobile Number");
        ((TextFieldDecorator) form).setValueString("");
        this.TextFields.add((TextFieldDecorator) form);
    }
    public static EtisalatMobile getInstance() {
        if(instance==null) {
            instance=new EtisalatMobile();
        }
        return instance;
    }
    @Override
    public void GetDataFromUser() {
        System.out.println("Please Enter the Data of the next form for this service");
    }


    @Override
    public void Recharge( UserModel user) {
        this.TextFields.get(this.TextFields.size()-1).GetDataFromUser();
        int amount = this.TextFields.get(0).getValueInt();
        String MobileNumber = this.TextFields.get(1).getValueString();
        Integer lastamount;
        for(DiscountModel dis : Model.getDiscounts()){
            if (dis.isOverAll() && Authentication.CurrentUser.getTransaction().size()==0) {
                System.out.println("You have a "+ dis.getDiscountPercentage()+" % discount for first transaction");
                lastamount = amount - (amount * dis.getDiscountPercentage() / 100);
                System.out.println("Now You will have discount "+(amount * dis.getDiscountPercentage() / 100)+ " $");
                System.out.println("You will pay "+lastamount+" $ instead of "+amount+" $");
                amount=lastamount;
            }
            else if(!dis.isOverAll()){
                if(this.GetMobileRechargeName().contains(dis.getFeatureName())){
                    System.out.println("You have a "+ dis.getDiscountPercentage()+" % discount for this service");
                    lastamount = amount - (amount * dis.getDiscountPercentage() / 100);
                    System.out.println("Now You will have discount "+(amount * dis.getDiscountPercentage() / 100)+ " $");
                    System.out.println("You will pay "+lastamount+" $ instead of "+amount+" $");
                    amount=lastamount;
                }
            }
        }
        PaymentFactory paymentFactory = new PaymentFactory();
        Integer count=1;
        String last = "";
        IPayment payment = paymentFactory.GetPayment(count);
        while(payment != null){
            if(payment.isActivated()) {
                last=" ------ Activated";
            }
            else {
                last=" ------ Not Activated";
            }
            if(count==3) {
                if (!this.isAcceptedCash()) {
                    last = " ------ Not Activated";
                }
            }
            System.out.println(count+"- "+payment.GetPaymentName()+" "+last);
            count++;
            payment = paymentFactory.GetPayment(count);
        }
        int choice3 = InputDataHandle.UserInput(1, count-1);
        while (!paymentFactory.GetPayment(choice3).isActivated() || (choice3==3 &&!this.isAcceptedCash()) ) {
            System.out.println("This payment is not activated");
            System.out.println("Please enter your choice:");
            choice3 = InputDataHandle.UserInput(1, count-1);
        }
        payment = paymentFactory.GetPayment(choice3);
        if(payment.Pay(amount,Authentication.CurrentUser)){
            System.out.println("You paid "+amount+" $ Successfully to "+this.GetMobileRechargeName());
            Authentication.CurrentUser.deductWallet(amount);
            Authentication.CurrentUser.addTransaction(new TransactionModel(this.GetMobileRechargeName(),amount,MobileNumber,Authentication.CurrentUser));
        }
        else{
            System.out.println("Payment is failed");
        };

    }
    @Override
    public String GetMobileRechargeName() {
        return "Etisalat Mobile";
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
