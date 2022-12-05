
public class Main {
    public static void main(String[] args) {
        // Default Admin
        // Email: admin@admin.com
        // Password: admin
        Model.AddAdmin(new UserModel("admin","admin@admin.com","admin","01000000000","admin",true));
        // Default User
        // Email: user@user.com
        // Password: user
        Model.AddUser(new UserModel("user","user@user.com","user","01000000000","user",false));
        RootOfTheApplication.Start();
    }
}