import java.util.Scanner;

public class RootOfTheApplication {
    public static void Start() {
        System.out.println("\nWelcome to Fawry services");
        RoleFactory factory = new RoleFactory();
        int i=1;
        while(factory.GetRole(i)!=null){
            System.out.println(i+". For "+factory.GetRole(i).GetRoleName());
            i++;
        }
        int choice=InputDataHandle.UserInput(1,i-1);
        IRole role = factory.GetRole(choice);
        Boolean isAdmin = role.GetRoleName().equals("Admin");
        role.start(isAdmin);
    }
}
