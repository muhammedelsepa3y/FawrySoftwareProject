import java.util.Scanner;

public class Authentication {
    public static UserModel CurrentUser;

    public static boolean checkUsernameOrEmailAvailability(String data) {
        for (UserModel user : Model.getUsers()) {
            if (user.getUsername().equals(data) || user.getEmail().equals(data)) {
                return false;
            }
        }
        for (UserModel admin : Model.getAdmins()) {
            if (admin.getUsername().equals(data) || admin.getEmail().equals(data)) {
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
        while (!checkUsernameOrEmailAvailability(email) || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid Email or Email already exists");
            System.out.println("Enter your email");
            email = scanner.nextLine();
        }
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        while (!checkUsernameOrEmailAvailability(username) || username.length() < 5) {
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
        UserModel user;
        if (isAdmin) {
            user = new UserModel(name, email, password, phone, username, true);
            Model.AddAdmin(user);
        } else {
            user = new UserModel(name, email, password, phone, username, false);
            Model.AddUser(user);
        }
        System.out.println("You have been registered successfully");
        System.out.println("Please " +user.getName()+" Login first to Continue ");
        // then login and set current user to this user
    }

}
