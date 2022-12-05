import java.util.*;

public class Admin extends IRole implements AdminServices {
    @Override
    public String GetRoleName() {
        return "Admin";
    }
    public void start(boolean isAdmin) {
        super.start(isAdmin);
        while (true) {
            System.out.println("\nWelcome " + Authentication.CurrentUser.getUsername());
            System.out.println("1- Add Discount");
            System.out.println("2- Remove Discount");
            System.out.println("3- Get All Discounts");
            System.out.println("4- set Payment Method status");
            System.out.println("5- set Cash for each service");
            System.out.println("6- Check All Not Checked Refunds Requests");
            System.out.println("7- Logout");
            int choice=InputDataHandle.UserInput(1,7);
            switch (choice) {
                case 1:
                    AddDiscount();
                    break;
                case 2:
                    RemoveDiscount();
                    break;
                case 3:
                    getAllDiscounts();
                    break;
                case 4:
                    setPaymentActivate();
                    break;
                case 5:
                    setCashForEachService();
                    break;
                case 6:
                    getNotCheckedRefundsRequests();
                    break;
                case 7:
                    Authentication.Logout();
                default:
                    break;
            }
        }
    }
    @Override
    public void AddDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. is Overall Discount");
        System.out.println("2. is Service Discount");
        System.out.println("3. Go Back");
        int isOverAll = InputDataHandle.UserInput(1, 3);
        if (isOverAll == 3) {
            return;
        }
        boolean isOverAllBool = isOverAll == 1;
        String NameOfFeature = "";
        if (isOverAllBool) {
            NameOfFeature = "for First Transaction regardless the service";
        } else {
            int i=1;
            FawryFactory fawryFactory = new FawryFactory();
            List<String> features = fawryFactory.GetFeatures();
            for (String feature : features) {
                if (i==4)
                    break;
                System.out.println(i+". "+feature);
                i++;
            }
            int feature = InputDataHandle.UserInput(1, i-2);
            NameOfFeature = features.get(feature-1);
        }
        System.out.println("Enter the discount percentage: ");
        int discountPercentage = scanner.nextInt();
        System.out.println("Enter the discount id:");
        int discountID = scanner.nextInt();
        for (DiscountModel dis : Model.getDiscounts()) {
            if (dis.getDiscountID() == discountID) {
                System.out.println("Discount ID is already used");
                System.out.println("Enter The discount ID:");
                discountID = scanner.nextInt();
            }
        }
        Model.AddDiscount(new DiscountModel(NameOfFeature, discountPercentage, isOverAllBool, discountID));
        System.out.println("Discount added successfully");
        return;
    }
    @Override
    public void RemoveDiscount() {
    	boolean found = false;
        List<DiscountModel> discounts = Model.getDiscounts();
        for (DiscountModel discountModel : discounts) {
            found = true;
            System.out.println("Feature Name: " + discountModel.getFeatureName());
            System.out.println("Discount Percentage: " + discountModel.getDiscountPercentage() + " %");
            System.out.println("Date: " + discountModel.getDiscountDescription());
            System.out.println("Discount Id: " + discountModel.getDiscountID());
            System.out.println("-----------------------");
        }
        if (!found) {
            System.out.println("No discounts found");
        } else {

            boolean foundDiscount = false;
            do{
            System.out.println("Enter the discount id to remove or -1 to Go Back: ");
            Scanner scanner = new Scanner(System.in);
            int discountID = scanner.nextInt();
            if (discountID == -1) {
                return;
            }
            for (DiscountModel discountModel : discounts) {
                if (discountModel.getDiscountID() == discountID) {
                    foundDiscount = true;
                    Model.RemoveDiscount(discountModel);
                    System.out.println("Discount removed successfully");
                    return;
                }
            }
            if (!foundDiscount) {
                System.out.println("Invalid discount ID");
            }}while(!foundDiscount);
  
        }

    }
    @Override
    public void getAllDiscounts() {
        boolean found = false;
        for (DiscountModel discountModel : Model.getDiscounts()) {
            found = true;
            System.out.println("Service Name: " + discountModel.getFeatureName());
            System.out.println("Discount Percantage:  " + discountModel.getDiscountPercentage() + " %");
            System.out.println("Date: " + discountModel.getDiscountDescription());
            System.out.println("Discount Id: " + discountModel.getDiscountID());
            System.out.println("Just to first transaction: " + discountModel.isOverAll());
            System.out.println("-----------------------");
        }
        if (!found) {
            System.out.println("No discounts found");
        }
        return;

    }
    @Override
    public void setPaymentActivate() {
        System.out.print("");
        int counter = 1;
        IPaymentFactory paymentFactory = new PaymentFactory();
        IPayment temp=paymentFactory.GetPayment(counter);
        while (temp != null) {
            System.out.println(counter + ". " + temp.GetPaymentName()+"   is active: "+temp.isActivated());
            counter++;
            temp=paymentFactory.GetPayment(counter);
        }
        int choicee = InputDataHandle.UserInput(1, counter - 1);
        while (choicee == 3) {
            System.out.print("!!!! You cannot change status of cash here please go back and set cash for each service\n");
            System.out.println("Enter the number of the payment method you want to activate or 0 to back:");
            choicee = InputDataHandle.UserInput(0, counter - 1);
            if (choicee == 0) {
                return;
            }
        }
        System.out.println("1. Activate");
        System.out.println("2. Deactivate");
        System.out.println("3. Go Back");
        int choice = InputDataHandle.UserInput(1, 3);
        System.out.print("");
        if (choice == 1) {
            paymentFactory.GetPayment(choicee).setActivated(true);
            System.out.println("Payment method activated successfully");
        } else if (choice == 2) {
            paymentFactory.GetPayment(choicee).setActivated(false);
            System.out.println("Payment method deactivated successfully");
        } else {
            return;
        }
    }
public void refundMoneyToUser(RefundModel refundModel){
    refundModel.getTransaction().getUser().addWallet(refundModel.getTransaction().getAmount());
    refundModel.getTransaction().getUser().RemoveTransaction(refundModel.getTransaction());
    return;
}

public void getNotCheckedRefundsRequests(){
    boolean found = false;
    List<RefundModel> refunds = Model.GetNotCheckedRefunds();
    for (RefundModel refundModel : refunds) {
        if (!refundModel.isChecked()) {
            found = true;
            System.out.println("Email: " + refundModel.getTransaction().getUser().getEmail());
            System.out.println("Username: " + refundModel.getTransaction().getUser().getUsername());
            System.out.println("Service Name: " + refundModel.getTransaction().getServiceName());
            System.out.println("Amount: " + refundModel.getTransaction().getAmount() + "$");
            System.out.println("Date: " + refundModel.getTransaction().getDate());
            System.out.println("Reason: " + refundModel.getReason());
            System.out.println("1. Accept");
            System.out.println("2. Reject");
            System.out.println("3. Go to next refund request");
            System.out.println("4. Back");
            System.out.println("-----------------------");
            int choice=InputDataHandle.UserInput(1,4);
            if (choice == 1) {
                refundModel.setChecked(true);
                refundMoneyToUser(refundModel);
                refundModel.setApproved(true);
                System.out.println(refundModel.getTransaction().getAmount() + "$ is refunded to " + refundModel.getTransaction().getUser().getUsername());
                System.out.println("Refund Accepted");
            } else if (choice == 2) {
                refundModel.setChecked(true);
                refundModel.setApproved(false);
                System.out.println("Refund Rejected");
            }else if(choice==3){
               continue;
            }
            else{
                return;
            }
            System.out.println("-----------------------");
        }

    }
    if (!found) {
        System.out.println("No Not Checked Refunds Requests");
    }
    return;


}

    public void setCashForEachService(){
        PaymentFactory paymentFactory=new PaymentFactory();
        paymentFactory.GetPayment(3).setActivated(true);
        System.out.print("");
        FawryFactory fawryFactory = new FawryFactory();

        int i=0;
        List<String> features = fawryFactory.GetFeatures();
        for (String feature : features) {
            System.out.println(++i + ". " + feature);
        }
        System.out.println("0. Back");
        int choice=InputDataHandle.UserInput(0, features.size());
        switch (choice) {
            case 0:
                return;
            case 1:
                int j = 1;
                MobileRechargeFactory mobileRechargeFactory = new MobileRechargeFactory();
                IMobileRecharge temp = mobileRechargeFactory.GetMobileRecharge(j);
                while (temp != null) {
                    System.out.println(j + ". " + temp.GetMobileRechargeName()+"   is accept cash: "+temp.isAcceptedCash());
                    j++;
                    temp = mobileRechargeFactory.GetMobileRecharge(j);
                }
                System.out.println("0. Back");
                int choice2 = InputDataHandle.UserInput(0, j - 1);
                if (choice2 == 0)
                    return;
                System.out.println("1. Accept Cash for this service");
                System.out.println("2. Reject Cash for this service");
                System.out.println("3. Back");
                int choice3 = InputDataHandle.UserInput(1, 3);
                if (choice3==3)
                    return;
                boolean acceptCash = choice3 == 1;
                mobileRechargeFactory.GetMobileRecharge(choice2).setAcceptedCash(acceptCash);
                System.out.println("Cash for this service is "+(acceptCash?"Accepted":"Rejected"));
                break;
            case 2:
                j = 1;
                InternetFactory internetFactory = new InternetFactory();
                IInternetPayment temp2 = internetFactory.GetInternetPayment(j);
                while (temp2 != null) {
                    System.out.println(j + ". " + temp2.GetInternetName()+"   is accept cash: "+temp2.isAcceptedCash());
                    j++;
                    temp2 = internetFactory.GetInternetPayment(j);
                }
                System.out.println("0. Back");
                choice2 = InputDataHandle.UserInput(0, j - 1);
                if (choice2 == 0)
                    return;
                System.out.println("1. Accept Cash for this service");
                System.out.println("2. Reject Cash for this service");
                System.out.println("3. Back");
                choice3 = InputDataHandle.UserInput(1, 3);
                if (choice3==3)
                    return;
                acceptCash = choice3 == 1;
                internetFactory.GetInternetPayment(choice2).setAcceptedCash(acceptCash);
                System.out.println("Cash for this service is "+(acceptCash?"Accepted":"Rejected"));
                break;
            case 3:
                j = 1;
                LandlineFactory landlineFactory = new LandlineFactory();
                ILandlinePayment temp3 = landlineFactory.GetLandLinePayment(j);
                while (temp3 != null) {
                    System.out.println(j + ". " + temp3.GetLandlineName()+"   is accept cash: "+temp3.isAcceptedCash());
                    j++;
                    temp3 = landlineFactory.GetLandLinePayment(j);
                }
                System.out.println("0. Back");
                choice2 = InputDataHandle.UserInput(0, j - 1);
                if (choice2 == 0)
                    return;
                System.out.println("1. Accept Cash for this service");
                System.out.println("2. Reject Cash for this service");
                System.out.println("3. Back");
                choice3 = InputDataHandle.UserInput(1, 3);
                if (choice3==3)
                    return;
                acceptCash = choice3 == 1;
                landlineFactory.GetLandLinePayment(choice2).setAcceptedCash(acceptCash);
                System.out.println("Cash for this service is "+(acceptCash?"Accepted":"Rejected"));
                break;
            case 4:
                j = 1;
                DonationFactory donationFactory = new DonationFactory();
                IDonation temp4 = donationFactory.GetDonation(j);
                while (temp4 != null) {
                    System.out.println(j + ". " + temp4.GetDonationName()+"   is accept cash: "+temp4.isAcceptedCash());
                    j++;
                    temp4 = donationFactory.GetDonation(j);
                }
                System.out.println("0. Back");
                choice2 = InputDataHandle.UserInput(0, j - 1);
                if (choice2 == 0)
                    return;
                System.out.println("1. Accept Cash for this service");
                System.out.println("2. Reject Cash for this service");
                System.out.println("3. Back");
                choice3 = InputDataHandle.UserInput(1, 3);
                if (choice3==3)
                    return;
                acceptCash = choice3 == 1;
                donationFactory.GetDonation(choice2).setAcceptedCash(acceptCash);
                System.out.println("Cash for this service is "+(acceptCash?"Accepted":"Rejected"));
                break;
        }
        return;

    }




}