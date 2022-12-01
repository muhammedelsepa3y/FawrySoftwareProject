import java.util.Scanner;

public abstract class IRole {
	public abstract String GetRoleName();
	public void start(boolean isAdmin)  {
        System.out.println("1. For Register");
        System.out.println("2. For Login");
        int choice = InputDataHandle.UserInput(1, 2);   
	}
	
}

