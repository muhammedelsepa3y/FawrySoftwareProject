import java.util.Scanner;

public class InputDataHandle {
    public static int UserInput(int lower,int upper) {
        System.out.println("Please enter your choice:");
        Scanner scanner=new Scanner(System.in);
        int choice;
        while(true){
            try{
                choice=scanner.nextInt();
                if(choice<lower||choice>upper){
                    throw new Exception();
                }
                return choice;
            }catch(Exception e){
                System.out.println("Invalid input, please try again");
            }
        }
    }
}
