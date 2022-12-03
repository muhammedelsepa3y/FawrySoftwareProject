
public class Main {
    public static void main(String[] args) {
        Model.AddAdmin(new UserModel("admin","admin@admin.com","admin","01000000000","admin",true));
        Model.AddUser(new UserModel("user","user@user.com","user","01000000000","user",false));
        RootOfTheApplication.Start();
    }
}