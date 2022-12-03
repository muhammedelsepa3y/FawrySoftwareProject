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
                    //setCashForPaymentMethod();
                    break;
                case 6:
                    //getNotCheckedRefundsRequests();
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
                System.out.println(i+". "+feature);
                i++;
            }
            int feature = InputDataHandle.UserInput(1, i-1);
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
       

    }
    @Override
    public void setPaymentActivate() {
        
    }
    
public void refundMoneyToUser(RefundModel refundModel){

}

public void getNotCheckedRefundsRequests(){

}

public void setCashForPaymentMethod(){


}

    



}