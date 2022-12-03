import java.util.ArrayList;
import java.util.List;

public class Model {

    private static List<UserModel> users= new ArrayList<UserModel>();
    private static List<UserModel> admins= new ArrayList<UserModel>();

    private static List<DiscountModel> discounts= new ArrayList<DiscountModel>();

    public static void AddUser(UserModel user) {
        users.add(user);
    }
    public static void AddAdmin(UserModel admin) {
        admins.add(admin);
    }

    public static void AddDiscount(DiscountModel discount) {
        discounts.add(discount);
    }

    public static List<UserModel> getUsers() {
        return users;
    }

    public static List<UserModel> getAdmins() {
        return admins;
    }

    public static List<DiscountModel> getDiscounts() {
        return discounts;
    }

    public static void RemoveDiscount(DiscountModel discount) {discounts.remove(discount);}
}
