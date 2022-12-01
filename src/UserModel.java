public class UserModel {

    private String name;
    private boolean isAdmin;
    private String email;
    private String password;
    private String phone;
    private String username;

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

}
