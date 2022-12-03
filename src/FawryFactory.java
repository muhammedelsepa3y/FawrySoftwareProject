import java.util.ArrayList;
import java.util.List;
public class FawryFactory implements IFawryFactory{
    public List<String> GetFeatures() {
        List<String> features = new ArrayList<>();
        features.add("Mobile Recharge");
        features.add("Internet");
        features.add("Landline");
        features.add("Donation");
        return features;
    }
}
