import java.util.Scanner;
public class RootOfTheApplication {
    public static void Start() {
        System.out.println("\nWelcome to Fawry services");
        FawryFactory factory = new FawryFactory();
        int i=1;
        while(factory.GetRole(i)!=null){
            System.out.println(i+". For "+factory.GetRole(i).GetRoleName());
            i++;
        }
        int choice=InputDataHandle.UserInput(1,i-1);
        IRole role = factory.GetRole(choice);
        Boolean isAdmin = role.GetRoleName().equals("Admin");
        System.out.println("Your choice is "+role.GetRoleName());

    }
}
