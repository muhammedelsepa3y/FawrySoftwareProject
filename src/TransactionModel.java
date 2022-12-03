import java.util.Date;
public class TransactionModel {
    private String serviceName;
    private int amount;
    private UserModel user;
    private String number;
    private String date;

    private int id;
    public TransactionModel(String serviceName, int amount, String number, UserModel user) {
        this.serviceName = serviceName;
        this.amount = amount;
        this.date = new Date().toString();
        this.number = number;
        this.id=(int)Math.floor(Math.random()*(999999998-1+1)+1);
        this.user = user;


    }
    public String getServiceName() {
        return serviceName;
    }
    public int getAmount() {
        return amount;
    }
    public UserModel getUser() {
        return user;
    }
    public String getNumber() {
        return number;
    }
    public String getDate() {
        return date;
    }
    public int getId() {
        return id;
    }

}
