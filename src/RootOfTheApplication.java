import java.util.Scanner;
public class RootOfTheApplication {
    public static void Start() {
        System.out.println("\nWelcome to Fawry services");
        FawryFactory factory = new FawryFactory();
        int i=1;
        while(factory.GetRole(i)!=null){
            System.out.println(String.valueOf(i+". For ")+factory.GetRole(i).GetRoleName());
            i++;
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Your Choice");
        int choice =scanner.nextInt();
        while(choice<1||choice>i-1) {
            System.out.println("Invalid input, please try again");
            choice =scanner.nextInt();
        }
        IRole role = factory.GetRole(choice);
        Boolean isAdmin = role.GetRoleName()=="Admin";
        System.out.println("Your choice is "+role.GetRoleName());

    }
}
