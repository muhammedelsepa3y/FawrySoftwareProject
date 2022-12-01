import java.util.Scanner;

public class Authentication {
    public static UserModel CurrentUser;
    public static boolean checkEmailAvailability(String email) {
        for(UserModel user : Model.getUsers()) {
            if(user.getEmail().equals(email)) {
                return false;
            }
        }
        for (UserModel admin : Model.getAdmins()) {
            if(admin.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkUsernameAvailability(String username) {
        for(UserModel user : Model.getUsers()) {
            if(user.getUsername().equals(username)) {
                return false;
            }
        }
        for (UserModel admin : Model.getAdmins()) {
            if(admin.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public static void Register(boolean isAdmin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        while(!checkEmailAvailability(email) || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid Email or Email already exists");
            System.out.println("Enter your email");
            email = scanner.nextLine();
        }
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        while(!checkUsernameAvailability(username) || username.length() < 5) {
            System.out.println("Username should be more than 5 characters or Username already exists");
            System.out.println("Enter your username");
            username = scanner.nextLine();
        }
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        while (password.length() < 5) {
            System.out.println("Password should be more than 5 characters");
            System.out.println("Enter your password");
            password = scanner.nextLine();
        }
        System.out.println("Enter your phone number");
        String phone = scanner.nextLine();
        while (phone.length() != 11) {
            System.out.println("Phone number should be 11 characters");
            System.out.println("Enter your phone number");
            phone = scanner.nextLine();
        }
        if (  isAdmin) {
            UserModel user = new UserModel(name, email, password, phone, username,true);
            Model.AddAdmin(user);
        } else {
            UserModel user = new UserModel(name, email, password, phone, username,false);
            Model.AddUser(user);
        }
        System.out.println("User registered successfully");
        // then login
    }
}
