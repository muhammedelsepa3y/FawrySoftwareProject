package FawrySoftwareSystem.Phase2.Models;

import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.Model.UserModel;

import java.util.Date;



public class RefundModel {

    private UserModel user;
    private boolean isChecked=false;
    private TransactionModel transaction;
    private boolean isApproved;
    private String reason;
    private String date;
    private int id;
    public boolean isChecked() {
        return isChecked;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }

    public RefundModel(int transactionId, String reason,boolean isApproved) {
        this.id=transactionId;
        this.reason = reason;
        this.date = new Date().toString();
        this.isApproved = isApproved;
        this.isChecked=false;
//        user=dataBase.getCurrentUser();
    }


    public TransactionModel getTransaction() {
        return transaction;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public String getReason() {
        return reason;
    }
    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
