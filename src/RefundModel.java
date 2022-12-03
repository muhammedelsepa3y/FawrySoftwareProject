import java.util.Date;
public class RefundModel {
    private TransactionModel transaction;
    private boolean isApproved;
    private boolean isChecked;
    private String reason;
    private String date;
    public RefundModel(TransactionModel transaction, String reason) {
        this.isChecked= false;
        this.transaction = transaction;
        this.reason = reason;
        this.date = new Date().toString();
        this.isApproved = false;
    }
    public TransactionModel getTransaction() {
        return transaction;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public boolean isChecked() {
        return isChecked;
    }

    public String getReason() {
        return reason;
    }
    public String getDate() {
        return date;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


}
