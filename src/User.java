import java.util.List;
import java.util.Scanner;
public class User extends IRole implements UserServices{

    @Override
    public String GetRoleName() {
        return "User";
    }
    @Override
    public void start(boolean isAdmin) {
        super.start(isAdmin);
        while(true){
            System.out.println("\nWelcome "+Authentication.CurrentUser.getUsername());
            System.out.println("1. Pay Bill");
            System.out.println("2. Search Service");
            System.out.println("3. Wallet Recharge");
            System.out.println("4. Print Discounts");
            System.out.println("5. Refund Service");
            System.out.println("6. Get Wallet Balance");
            System.out.println("7. Check Refund Status");
            System.out.println("8. Logout");
            int choice = InputDataHandle.UserInput(1, 8);
            switch (choice) {
                case 1:
                    this.payBill();
                    break;
                case 2:
                    this.searchService();
                    break;
                case 3:
                    this.walletRecharge();
                    break;
                case 4:
                    this.PrintDiscounts();
                    break;
                case 5:
                    this.refundService();
                    break;
                case 6:
                    this.getWalletBalanced();
                    break;
                case 7:
                    this.checkMyRefundsRequests();
                    break;
                case 8:
                    Authentication.Logout();
                    return;
            }
        }
    }
    @Override
    public void payBill() {
        FawryFactory fawryFactory = new FawryFactory();
        int i=0;
        List<String> features = fawryFactory.GetFeatures();
        for (String feature : features) {
            System.out.println(++i + ". " + feature);
        }
        System.out.println("0. Back");
        int choice=InputDataHandle.UserInput(0, features.size());

        switch (choice){
            case 0:
                return;
            case 1:
                int j=1;
                MobileRechargeFactory mobileRechargeFactory = new MobileRechargeFactory();
                IMobileRecharge temp=mobileRechargeFactory.GetMobileRecharge(j);
                while (temp != null) {
                    System.out.println(j + ". " + temp.GetMobileRechargeName());
                    j++;
                    temp = mobileRechargeFactory.GetMobileRecharge(j);
                }
                System.out.println("0. Back");
                int choice2=InputDataHandle.UserInput(0, j-1);
                if(choice2==0)
                    return;
                temp = mobileRechargeFactory.GetMobileRecharge(choice2);
                temp.Recharge(Authentication.CurrentUser);
                break;
            case 2:
                InternetFactory internetFactory = new InternetFactory();
                j=1;
                IInternetPayment temp3=internetFactory.GetInternetPayment(j);
                while (temp3 != null) {
                    System.out.println(j + ". " + temp3.GetInternetName());
                    j++;
                    temp3 = internetFactory.GetInternetPayment(j);
                }
                System.out.println("0. Back");
                choice2=InputDataHandle.UserInput(0, j-1);
                if(choice2==0)
                    return;
                temp3= internetFactory.GetInternetPayment(choice2);
                temp3.Recharge(Authentication.CurrentUser);
                break;
            case 3:
                LandlineFactory landlineFactory = new LandlineFactory();
                j=1;
                ILandlinePayment temp4=landlineFactory.GetLandLinePayment(j);
                while (temp4!= null) {
                    System.out.println(j + ". " + temp4.GetLandlineName());
                    j++;
                    temp4 = landlineFactory.GetLandLinePayment(j);
                }
                System.out.println("0. Back");
                choice2=InputDataHandle.UserInput(0, j-1);
                if(choice2==0)
                    return;
                temp4 = landlineFactory.GetLandLinePayment(choice2);
                temp4.Recharge( Authentication.CurrentUser);
                break;
            case 4:
                DonationFactory donationFactory = new DonationFactory();
                j=1;
                IDonation temp5=donationFactory.GetDonation(j);
                while (temp5 != null) {
                    System.out.println(j + ". " + temp5.GetDonationName());
                    j++;
                    temp5 = donationFactory.GetDonation(j);
                }
                System.out.println("0. Back");
                choice2=InputDataHandle.UserInput(0, j-1);
                if(choice2==0)
                    return;
                temp5 = donationFactory.GetDonation(choice2);
                temp5.Recharge(Authentication.CurrentUser);
                break;
        }
    }
	@Override
	public void searchService() {
        System.out.println("Enter the service name:");
        Scanner scanner = new Scanner(System.in);
        String serviceName = scanner.nextLine();
        FawryFactory fawryFactory = new FawryFactory();
        List<String> services = fawryFactory.GetServices();
        boolean found = false;
        for (String FE : services) {
            if (FE.contains(serviceName)) {
                System.out.println(FE+" is available");
            }
        }
        if (!found) {
            System.out.println("Service not found");
        }
        return;

    }
    @Override
    public void walletRecharge() {
        System.out.println("Enter the amount:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        PaymentFactory paymentFactory = new PaymentFactory();
        IPayment payment = paymentFactory.GetPayment(1);
        payment.Pay(amount,Authentication.CurrentUser);
        Authentication.CurrentUser.addWallet(amount);
    }
    @Override
    public void PrintDiscounts() {
        boolean flag = false;
        for(DiscountModel i : Model.getDiscounts()){
            flag = true;
            System.out.println("Feature Name: "+i.getFeatureName());
            System.out.println("Discount Percentage: "+i.getDiscountPercentage()+" %");
            System.out.println("Date: "+i.getDiscountDescription());
            if(i.isOverAll()){
                System.out.println("This discount For First Transaction");
            }
            System.out.println("-------------------------------------------------");
        }
        if(!flag){
            System.out.println("No Discounts Available");
        }
        return;
    }
    public TransactionModel GetTransactionById(int id){
        for(TransactionModel i :Authentication.CurrentUser.getTransaction()){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }
    @Override
    public void refundService() {
        boolean flag = false;
        for (TransactionModel i : Authentication.CurrentUser.getTransaction()) {
            flag = true;
            System.out.println("Transaction Id: "+i.getId());
            System.out.println(i.getServiceName());
            System.out.println(i.getAmount()+" $");
            System.out.println(i.getDate());
            System.out.println("-----------------------");
        }
        if(!flag){
            System.out.println("No Transactions Available");
            return;
        }
        System.out.println("Enter the transaction id or 0 to Go Back:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(id == 0){
            return;
        }
        System.out.println("Enter the Reason:");
        Scanner scanner1 = new Scanner(System.in);
        String reason = scanner1.nextLine();
        TransactionModel transaction = GetTransactionById(id);
        if(transaction != null){
            Model.AddNotCheckedRefunds(new RefundModel(transaction,reason));
            System.out.println("Refund Request is send successfully");
        }
        else{
            System.out.println("Invalid transaction id");
        }
        return;
    }
    @Override
    public void getWalletBalanced() {
        System.out.println("Your Wallet Balance is: "+Authentication.CurrentUser.getWallet()+" $");
        return;
    }
    @Override
    public void checkMyRefundsRequests() {
        boolean flag = false;
        for (RefundModel refund:Model.GetNotCheckedRefunds()) {
            if(refund.getTransaction().getUser()==Authentication.CurrentUser){
                flag = true;
                System.out.println("Refund for: "+refund.getTransaction().getServiceName()+"\nAmount: "+refund.getTransaction().getAmount());
                System.out.println("Refund Reason: "+refund.getReason());
                if (refund.isChecked()){
                    if(refund.isApproved()){
                        System.out.println("Refund Accepted");
                    }else {
                        System.out.println("Refund Rejected");
                    }
                }else{
                    System.out.println("Refund Status: Not Checked");
                }
                System.out.println("-------------------------------------------------");

            }
        }
        if(!flag){
            System.out.println("No Refunds");
        }
        return;

    }

}