public interface IPayment {
    public boolean  isActivated() ;
    public void setActivated(boolean isActivated) ;
    public boolean Pay(int Amount,UserModel user); // Strategy Pattern
    public String GetPaymentName();

}
