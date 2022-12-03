public class UserModel {

    private  String name;
    private  boolean isAdmin;
    private  String email;
    private  String password;
    private  String phone;
    private  String username;
    private  int wallet=0;
    public UserModel(String name, String email, String password, String phone, String username, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.isAdmin = isAdmin;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }

    public int addWallet(int amount) {
        return wallet+=amount;
    }
    public int getWallet() {
        return wallet;
    }
    public int deductWallet(int amount) {
        return wallet-=amount;
    }
}
