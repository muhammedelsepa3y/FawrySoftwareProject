

public interface AdminServices {
    public void setPaymentActivate()  ;
    public void setCashForPaymentMethod();
    public void AddDiscount();
    public void getNotCheckedRefundsRequests();
    public void RemoveDiscount();
    public void getAllDiscounts();
    public void refundMoneyToUser(RefundModel refundModel);

}