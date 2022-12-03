import java.util.Date;
public class DiscountModel {
    private String FeatureName;
    private int discountPercentage;
    private String discountDescription;
    private int discountID;
    private boolean isOverAll;
    public DiscountModel(String FeatureName, int discountPercentage,  boolean isOverAll, int discountID) {
        this.FeatureName = FeatureName;
        this.discountPercentage = discountPercentage;
        this.discountDescription = new Date().toString();
        this.isOverAll = isOverAll;
        this.discountID = discountID;
    }
    public String getFeatureName() {
        return FeatureName;
    }
    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public String getDiscountDescription() {
        return discountDescription;
    }
    public boolean isOverAll() {
        return isOverAll;
    }
    public int getDiscountID() {
        return discountID;
    }
}
