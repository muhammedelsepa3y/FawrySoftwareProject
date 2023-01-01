package FawrySoftwareSystem.Phase2.Authentication.Model;

import FawrySoftwareSystem.Phase2.FawryServices.Models.WalletRechargeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserModel {


    private UUID id;
    private String name;
    private boolean isAdmin;
    private String email;
    private String password;
    private String phone;
    private String username;
    private double wallet = 0;
    private boolean isLogin = false;
    private List<WalletRechargeModel> walletRechargeModels=new ArrayList<>();
    private List<TransactionModel> transaction = new ArrayList<TransactionModel>();

    public UserModel(String name, String email, String password, String phone, String username, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.isAdmin = isAdmin;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
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

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getName() {
        return name;
    }

    public String addWallet(double amount) {
        if (amount > 0) {
            wallet += amount;
            return "your wallet is updated now your balance is " + wallet;
        } else {
            return "Error";
        }
    }


    public double getWallet() {
        return wallet;
    }

    public String deductWallet(double amount) {
        if (amount > 0) {
            wallet -= amount;
            return "your wallet is updated now your balance is " + wallet;
        } else {
            return "Error";
        }

    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void addTransaction(TransactionModel transaction) {
        this.transaction.add(transaction);
    }

    public List<TransactionModel> getTransaction() {
        return transaction;
    }

    public void RemoveTransaction(TransactionModel transaction) {
        this.transaction.remove(transaction);
    }

    public void addWalletHistory(WalletRechargeModel walletRechargeModel) {
        this.walletRechargeModels.add(walletRechargeModel);
    }

    public List<WalletRechargeModel> getWalletHistory() {
        return walletRechargeModels;
    }
}
