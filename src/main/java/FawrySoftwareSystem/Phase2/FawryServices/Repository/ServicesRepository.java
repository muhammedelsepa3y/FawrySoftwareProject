package FawrySoftwareSystem.Phase2.FawryServices.Repository;


import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.Authentication.Repository.AuthRepository;
import FawrySoftwareSystem.Phase2.FawryServices.Data.Donation.Donations;
import FawrySoftwareSystem.Phase2.FawryServices.Data.Factory.PayFactory;
import FawrySoftwareSystem.Phase2.FawryServices.Data.InternetPayment.InternetPayment;
import FawrySoftwareSystem.Phase2.FawryServices.Data.LandlinePayment.LandlinePayment;
import FawrySoftwareSystem.Phase2.FawryServices.Data.MobileRecharge.MobileRecharge;
import FawrySoftwareSystem.Phase2.FawryServices.Models.DiscountModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.RefundModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.WalletRechargeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ServicesRepository {

    private PayFactory payFactory;
    private final List<DiscountModel> discounts = new ArrayList<>();
    private final List<RefundModel> Allrefunds = new ArrayList<>();
    private final List<RefundModel> NotChecked = new ArrayList<>();

    private AuthRepository authRepository;


    private ServicesRepository(AuthRepository authRepository) {
        payFactory = new PayFactory();
        this.authRepository = authRepository;

    }


    public List<String> getFeatures() {
        return payFactory.getAllFeatures();
    }

    public List<String> getServices() {
        return payFactory.getAllServices();
    }

    public List<String> searchServices(Map<String, String> query) {
        List<String> services = payFactory.getAllServices();
        List<String> result = new ArrayList<>();
        String queryy = query.get("query");
        for (String temp : services) {
            if (temp.toLowerCase().contains(queryy.toLowerCase())) {
                result.add(temp);
            }
        }
        return result;
    }

    public String AddTransaction(TransactionModel transaction, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {

            double amount = 0;
            for (int j = 0; j < discounts.size(); j++) {
                if (transaction.getFeatureName().toLowerCase().contains(discounts.get(j).getFeatureName().toLowerCase())) {
                    int discount = discounts.get(j).getDiscountPercentage();
                    amount += transaction.getAmount() * discount / 100;
                }
                if (discounts.get(j).getFeatureName().toLowerCase().contains("OverAll".toLowerCase()) && user.getTransaction().size() == 0) {
                    double discount = discounts.get(j).getDiscountPercentage();
                    amount += transaction.getAmount() * discount / 100;
                }
                if (amount >= transaction.getAmount()) {
                    amount -= transaction.getAmount() * discounts.get(j).getDiscountPercentage() / 100;
                    break;
                }
            }

            transaction.setAmount(transaction.getAmount() - amount);
            if (transaction.getFeatureName().equals("Mobile Recharge")) {
                MobileRecharge Obj = payFactory.getMobileRecharge(transaction.getNumber(), transaction.getAmount(), transaction.getServiceName());
                return Obj.pay(transaction, user);
            } else if (transaction.getFeatureName().equals("Donation")) {
                Donations Obj = payFactory.getDonation(transaction.getNumber(), transaction.getAmount(), transaction.getServiceName());
                return Obj.pay(transaction, user);
            } else if (transaction.getFeatureName().equals("Landline Payment")) {
                LandlinePayment Obj = payFactory.getLandlinePayment(transaction.getNumber(), transaction.getAmount(), transaction.getServiceName());
                return Obj.pay(transaction, user);
            } else if (transaction.getFeatureName().equals("Internet Payment")) {
                InternetPayment Obj = payFactory.getInternetPayment(transaction.getNumber(), transaction.getAmount(), transaction.getServiceName());
                return Obj.pay(transaction, user);
            }
            return "Error no service found";
        } else {
            return "User Not Found";
        }
    }

    public List<DiscountModel> getDiscounts() {
        return discounts;
    }

    public String getWallet(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            return "you have " + user.getWallet() + " $ in your wallet";
        } else {
            return "No User Found";
        }

    }

    public String addToWallet(WalletRechargeModel walletRechargeModel, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (walletRechargeModel.getCreditCardCVV().length() == 3 && walletRechargeModel.getCreditCardNumber().length() == 16 && walletRechargeModel.getCreditCardExpirationDate().length() == 5) {
                user.addWallet(walletRechargeModel.getAmount());
                user.addWalletHistory(walletRechargeModel);
                return "Wallet Recharged Successfully";
            } else {
                return "Invalid Credit Card";
            }
        } else {
            return "No User Found";
        }
    }

    public List<TransactionModel> getTransactions(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            return user.getTransaction();
        } else {
            return null;
        }
    }

    public String addRefund(RefundModel refund, UUID uuid) {

        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            for (TransactionModel trans : user.getTransaction()) {
                if (trans.getId() == refund.getId()) {
                    for (RefundModel r : Allrefunds) {
                        if (r.getId() == refund.getId()) {
                            return "you sent a refund request before to this transaction";
                        }
                    }
                    refund.setTransaction(trans);
                    refund.setUser(user);
                    NotChecked.add(refund);
                    Allrefunds.add(refund);
                    return "Refund Request Added Successfully";
                }
            }
            return "No Transaction Found";
        } else {
            return "No User Found";
        }
    }

    public List<RefundModel> checkRefund(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        List<RefundModel> reflist = new ArrayList<>();
        if (user != null) {
            for (RefundModel ref : Allrefunds) {
                if (ref.getUser().getId() == uuid) {
                    reflist.add(ref);
                }
            }
            return reflist;
        } else {
            return null;
        }
    }

    public Object GetNotCheckedRefund(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (user.isAdmin()) {
                return NotChecked;
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }

    }

    public String addDiscount(DiscountModel discount, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);

        if (user != null) {
            if (user.isAdmin()) {
                for (DiscountModel discountModel : discounts) {
                    if (discountModel.getFeatureName().equalsIgnoreCase(discount.getFeatureName())) {
                        return "this service already has a discount";
                    }
                }
                List<String> features = getFeatures();
                boolean chk = false;
                for (String fea : features) {
                    if (fea.equalsIgnoreCase(discount.getFeatureName())) {
                        discounts.add(discount);
                        chk = true;
                        return "Discount Added Successfully";
                    }
                    if (discount.getFeatureName().equalsIgnoreCase("OverAll")) {
                        discounts.add(discount);
                        chk = true;
                        return "Discount Added Successfully";
                    }
                }
                if (!chk) {
                    return "Feature Not Found Please Try Again";
                }
            }
            return "Not Admin, you don't have access to this";
        } else {
            return "User Not Found";
        }
    }

    public String deleteDiscount(DiscountModel discount, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);

        if (user != null) {
            if (user.isAdmin()) {
                boolean chk = false;
                for (DiscountModel discountModel : discounts) {
                    if (discountModel.getFeatureName().equalsIgnoreCase(discount.getFeatureName())) {
                        chk = true;
                        discounts.remove(discountModel);
                        return "Discount Removed Successfully";
                    }
                }
                if (!chk) {
                    return "This Feature Doesn't have any discount";
                }
            }
            return "Not Admin, you don't have access to this";
        } else {
            return "User Not Found";
        }
    }

    public String RefundAction(RefundModel refund, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (user.isAdmin()) {
                for (RefundModel ref : NotChecked) {
                    if (ref.getId() == refund.getId()) {
                        if(refund.isApproved()){
                            ref.getUser().addWallet(ref.getTransaction().getAmount());
                            ref.getUser().RemoveTransaction(ref.getTransaction());
                            return "Refund Accepted";
                        }
                        else{
                            return "Refund Rejected";
                        }

                    }
                }
                return "No Refund Found";
            }
            return "Not Admin, you don't have access to this";
        }
        return "User Not Found";


    }

    public String setCash(Map<String, String> service, UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        String featue = service.get("featureName");
        String iscash = service.get("isAcceptCash");
        boolean isAcceptCash = iscash.equalsIgnoreCase("true");
        if (user != null) {
            if (user.isAdmin()) {
                boolean chk = false;
                for (String fea : getFeatures()) {
                    if (fea.equalsIgnoreCase(featue)) {
                        chk = true;
                        if (featue.equalsIgnoreCase("Mobile Recharge")) {
                            MobileRecharge.isAcceptCash = isAcceptCash;
                        } else if (featue.equalsIgnoreCase("Internet Payment")) {
                            InternetPayment.isAcceptCash = isAcceptCash;
                        } else if (featue.equalsIgnoreCase("Donation")) {
                            Donations.isAcceptCash = isAcceptCash;
                        } else if (featue.equalsIgnoreCase("Landline Payment")) {
                            LandlinePayment.isAcceptCash = isAcceptCash;
                        }
                        if (isAcceptCash) {
                            return "Cash Status Changed";
                        }

                    }
                }
                if (!chk) {
                    return "This Feature Not Found";
                }
            }
            return "Not Admin, you don't have access to this";
        } else {
            return "User Not Found";
        }

    }

    public Object getAllTransaction(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        List<TransactionModel> transactionModels=new ArrayList<>();
        if (user != null) {
            if (user.isAdmin()) {
                for (UserModel userModel: authRepository.getUsers(uuid)){
                    transactionModels.addAll(userModel.getTransaction());
                }
                if(transactionModels.size()!=0)
                    return transactionModels;
                else
                    return "No Transaction Found";
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }
    }

    public Object getOneUserTransaction(UUID uuid, UserModel SearchedUser) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (user.isAdmin()) {
                for (UserModel userModel: authRepository.getUsers(uuid)){
                    if(userModel.getEmail().equalsIgnoreCase(SearchedUser.getEmail())||userModel.getUsername().equalsIgnoreCase(SearchedUser.getUsername())){
                        return userModel.getTransaction();
                    }
                }
                return "User Not Found";
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }
    }

    public Object getRefunds(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (user.isAdmin()) {
                return Allrefunds;
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }

    }

    public Object GetUserWalletHistory(UUID uuid, UserModel SearchedUser ) {
        UserModel user = authRepository.userexistToPay(uuid);
        if (user != null) {
            if (user.isAdmin()) {
                for (UserModel userModel: authRepository.getUsers(uuid)){
                    if(userModel.getEmail().equalsIgnoreCase(SearchedUser.getEmail())||userModel.getUsername().equalsIgnoreCase(SearchedUser.getUsername())){
                        return userModel.getWalletHistory();
                    }
                }
                return "User Not Found";
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }
    }

    public Object GetallWalletHistory(UUID uuid) {
        UserModel user = authRepository.userexistToPay(uuid);
        List<WalletRechargeModel> walletRechargeModels=new ArrayList<>();
        if (user != null) {
            if (user.isAdmin()) {
                for (UserModel userModel: authRepository.getUsers(uuid)){
                    walletRechargeModels.addAll(userModel.getWalletHistory());
                }
                if(walletRechargeModels.size()!=0)
                    return walletRechargeModels;
                else
                    return "No Wallet Recharge found";
            } else {
                return "Not Admin, you don't have access to this";
            }
        } else {
            return "No User Found";
        }
    }
}
