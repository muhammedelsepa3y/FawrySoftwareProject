import java.util.Scanner;

public abstract class IRole {
	public abstract String GetRoleName();
	public void start(boolean isAdmin)  {
        System.out.println("1. For Register");
        System.out.println("2. For Login");
        System.out.println("Please enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice");
            System.out.println("Please enter your choice:");
            choice = scanner.nextInt();
        }
	}
	
}

