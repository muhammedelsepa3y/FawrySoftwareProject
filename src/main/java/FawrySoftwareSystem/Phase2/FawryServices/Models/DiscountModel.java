package FawrySoftwareSystem.Phase2.FawryServices.Models;

import java.util.Date;

public class DiscountModel {
    private String FeatureName;
    private int discountPercentage;
    private String discountDescription;
    private boolean isOverAll;
    private int discountID;
    public DiscountModel(String FeatureName, int discountPercentage) {
        this.FeatureName = FeatureName;
        this.discountPercentage = discountPercentage;
        this.discountDescription = new Date().toString();
        this.discountID = (int) (Math.random() * 1000000);
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
    public int getDiscountID() {
        return discountID;
    }


}
