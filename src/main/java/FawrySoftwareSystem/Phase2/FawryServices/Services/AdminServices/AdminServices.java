package FawrySoftwareSystem.Phase2.FawryServices.Services.AdminServices;


import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@org.springframework.stereotype.Service
public class AdminServices {
    private final ServicesRepository servicesRepository;

    public AdminServices(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public Object GetNotCheckedRefund(UUID uuid) {
        return servicesRepository.GetNotCheckedRefund(uuid);
    }

    public String AddDiscount(DiscountModel discount, UUID uuid) {
        return servicesRepository.addDiscount(discount, uuid);
    }

    public String DeleteDiscount(DiscountModel discount, UUID uuid) {
        return servicesRepository.deleteDiscount(discount, uuid);
    }

    public String RefundAction(RefundModel refund, UUID uuid) {
        return servicesRepository.RefundAction(refund, uuid);
    }

    public String SetCash(Map<String, String> service, UUID uuid) {
        return servicesRepository.setCash(service, uuid);
    }

    public Object GetAllTransaction(UUID uuid) {
        return servicesRepository.getAllTransaction(uuid);
    }

    public Object GetOneUserTransaction(UUID uuid, UserModel user) {
        return servicesRepository.getOneUserTransaction(uuid,user);
    }

    public Object getAllRefunds(UUID uuid) {
        return servicesRepository.getRefunds(uuid);

    }

    public Object GetUserWalletHistory(UUID uuid, UserModel user) {
        return servicesRepository.GetUserWalletHistory(uuid,user);
    }

    public Object GetallWalletHistory(UUID uuid) {
        return servicesRepository.GetallWalletHistory(uuid);

    }
}
