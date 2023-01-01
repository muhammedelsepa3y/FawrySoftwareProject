package FawrySoftwareSystem.Phase2.FawryServices.Services.UserServices;


import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.DiscountModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.RefundModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.WalletRechargeModel;
import FawrySoftwareSystem.Phase2.FawryServices.Repository.ServicesRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@org.springframework.stereotype.Service
public class UserServices {
    private final ServicesRepository servicesRepository;
    public UserServices(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }




    public List<String> GetFeatures() {
        return servicesRepository.getFeatures();
    }

    public List<String> GetServices() {
        return servicesRepository.getServices();
    }

    public Object SearchServices(Map<String,String> query) {
        if(query != null) {
            if(servicesRepository.searchServices(query).size() != 0) {
                return servicesRepository.searchServices(query);
            } else {
                return "No Services Found";
            }
        } else {
            return "Query is Empty";
        }

    }

    public String AddTransaction(TransactionModel transactionModel, UUID uuid) {
        Map<String,String> query = Map.of("query",transactionModel.getServiceName());
        if(!SearchServices(query).equals("No Services Found") ) {
            return servicesRepository.AddTransaction(transactionModel,uuid);
        } else {
            return "Service Not Found";
        }


    }

    public List<DiscountModel> GetDiscounts() {
        return servicesRepository.getDiscounts();
    }

    public String GetWallet(UUID uuid) {
        return servicesRepository.getWallet(uuid);
    }

    public String AddToWallet(WalletRechargeModel walletRechargeModel, UUID uuid) {
        return servicesRepository.addToWallet(walletRechargeModel,uuid);
    }

    public List<TransactionModel> GetTransactions(UUID uuid) {
        return servicesRepository.getTransactions(uuid);
    }

    public String AddRefund(RefundModel refund, UUID uuid) {
        return servicesRepository.addRefund(refund,uuid);
    }

    public List<RefundModel> CheckRefund(UUID uuid) {
        return servicesRepository.checkRefund(uuid);
    }

}
