import java.util.Scanner;

public class Authentication {
    public static UserModel CurrentUser;

    public static boolean checkUsernameOrEmailNonAvailability(String data) {
        for (UserModel user : Model.getUsers()) {
            if (user.getUsername().equals(data) || user.getEmail().equals(data)) {
                return true;
            }
        }
        for (UserModel admin : Model.getAdmins()) {
            if (admin.getUsername().equals(data) || admin.getEmail().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public static void Register(boolean isAdmin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        while (checkUsernameOrEmailNonAvailability(email) || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid Email or Email already exists");
            System.out.println("Enter your email");
            email = scanner.nextLine();
        }
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        while (checkUsernameOrEmailNonAvailability(username) || username.length() < 5) {
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
        Login(isAdmin);
    }
    public static UserModel checkRegister(String email,String password,boolean isAdmin) {
        if(isAdmin) {
            for (UserModel admin : Model.getAdmins()) {
                if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                    return admin;
                }
            }
        } else {
            for(UserModel user : Model.getUsers()) {
                if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public static void Login(boolean isAdmin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Email");
        String Email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        while(checkRegister(Email,password,isAdmin) == null) {
            System.out.println("Invalid Email or password");
            System.out.println("1. Don't have an account? Register first");
            System.out.println("2. Try again");
            int c=InputDataHandle.UserInput(1,2);
            if(c==1) {
                Register(isAdmin);
            }
            System.out.println("Enter your Email");
            Email = scanner.nextLine();
            System.out.println("Enter your password");
            password = scanner.nextLine();
        }
        CurrentUser = checkRegister(Email,password,isAdmin);
        System.out.println("Login successfully");
    }
    public static void Logout(){
        System.out.println("Logout successfully");
        CurrentUser=null;
        RootOfTheApplication.Start();
    }
}

