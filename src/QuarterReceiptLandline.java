import java.util.ArrayList;
import java.util.List;
public class QuarterReceiptLandline implements ILandlinePayment,Form{

    private static QuarterReceiptLandline instance = null;
    private boolean isAcceptedCash = true;
    private List<TextFieldDecorator> TextFields= new ArrayList<TextFieldDecorator>();
    private List<DropDownDecorator> DropDowns= new ArrayList<DropDownDecorator>();
    private QuarterReceiptLandline(){
        Form form= new TextFieldDecorator(this);
        ((TextFieldDecorator) form).setName("Amount");
        ((TextFieldDecorator) form).setValueInt(0);
        this.TextFields.add((TextFieldDecorator) form);
        form= new TextFieldDecorator(form);
        ((TextFieldDecorator) form).setName("Landline Number");
        ((TextFieldDecorator) form).setValueString("");
        this.TextFields.add((TextFieldDecorator) form);
    }
    public static QuarterReceiptLandline getInstance(){
        if(instance == null){
            instance = new QuarterReceiptLandline();
        }
        return instance;
    }

    @Override
    public void GetDataFromUser() {
        System.out.println("Please Enter the Data of the next form for this service");
    }

    @Override
    public void Recharge(UserModel user) {
        this.TextFields.get(this.TextFields.size()-1).GetDataFromUser();
        int amount = this.TextFields.get(0).getValueInt();
        String Landline = this.TextFields.get(1).getValueString();
        int AllDiscount=0;
        int discountAmount=0;
        boolean disfound=false;
        for(DiscountModel dis : Model.getDiscounts()){
            if (dis.isOverAll() && Authentication.CurrentUser.getTransaction().size()==0) {
                disfound=true;
                System.out.println("You have a "+ dis.getDiscountPercentage()+" % discount for first transaction");
                discountAmount = (amount * dis.getDiscountPercentage() / 100);
                System.out.println("Now You will have discount "+(amount * dis.getDiscountPercentage() / 100)+ " $");
                AllDiscount+=discountAmount;
            }
            else if(!dis.isOverAll()){
                if(this.GetLandlineName().contains(dis.getFeatureName())){
                    disfound=true;
                    System.out.println("You have a "+ dis.getDiscountPercentage()+" % discount for this service");
                    discountAmount =(amount * dis.getDiscountPercentage() / 100);
                    System.out.println("Now You will have discount "+(amount * dis.getDiscountPercentage() / 100)+ " $");
                    AllDiscount+=discountAmount;
                }
            }
            System.out.println("----------------------------------------");
        }
        if(disfound){
            System.out.println("You will have discount "+AllDiscount+ " $");
            System.out.println("Now You will pay "+(amount-AllDiscount)+ " $ for this service instead of "+amount+" $");
            amount-=AllDiscount;
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
            choice3 = InputDataHandle.UserInput(1, count-1);
        }
        payment = paymentFactory.GetPayment(choice3);
        if(payment.Pay(amount,Authentication.CurrentUser)){
            System.out.println("You paid "+amount+" $ Successfully to "+this.GetLandlineName());
            Authentication.CurrentUser.addTransaction(new TransactionModel(this.GetLandlineName(),amount,Landline,Authentication.CurrentUser));
        }
        else{
            System.out.println("Payment is failed");
        };
    }

    @Override
    public String GetLandlineName() {
        return "Quarter Receipt Landline";
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
