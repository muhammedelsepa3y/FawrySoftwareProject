package FawrySoftwareSystem.Phase2.FawryServices.Controllers.AdminController;

import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.DiscountModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.RefundModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.WalletRechargeModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Services.AdminServices.AdminServices;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Services.UserServices.UserServices;
import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;
    @RequestMapping(value = "/refund/getAll", method = RequestMethod.GET)
        public ResponseEntity<Object>  GetNotCheckedRefund(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.GetNotCheckedRefund(uuid));
    }
    @RequestMapping(value = "/discounts/add", method = RequestMethod.POST)
    public ResponseEntity<String> AddDiscount(@RequestBody DiscountModel discount, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.AddDiscount(discount,uuid));
    }
    @RequestMapping(value = "/discounts/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> DeleteDiscount(@RequestBody DiscountModel discount, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.DeleteDiscount(discount,uuid));
    }
    @RequestMapping(value = "/refund/request", method = RequestMethod.PUT)
    public ResponseEntity<String> Refund(@RequestBody RefundModel refund, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.RefundAction(refund,uuid));
    }
    @RequestMapping(value = "/service/setCash", method = RequestMethod.PUT)
    public ResponseEntity<String> SetCash(@RequestBody Map<String,String> service, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.SetCash(service,uuid));
    }

    @RequestMapping(value = "/transactions/getAllTransaction", method = RequestMethod.GET)
    public ResponseEntity<Object> GetAllTransaction(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.GetAllTransaction(uuid));
    }

    @RequestMapping(value = "/transactions/getUserTransaction", method = RequestMethod.GET)
    public ResponseEntity<Object> GetUserTransaction(@RequestHeader("uuid") UUID uuid, @RequestBody UserModel user) {
        return ResponseEntity.ok(adminServices.GetOneUserTransaction(uuid,user));
    }

    @RequestMapping(value = "/refund/GetAll", method = RequestMethod.GET)
    public ResponseEntity<Object> GetAllRefunds(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.getAllRefunds(uuid));
    }

    @RequestMapping(value = "/wallet/getUserHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> GetUserWalletHistory(@RequestHeader("uuid") UUID uuid, @RequestBody UserModel user) {
        return ResponseEntity.ok(adminServices.GetUserWalletHistory(uuid,user));
    }

    @RequestMapping(value = "/wallet/GetAll", method = RequestMethod.GET)
    public ResponseEntity<Object> GetAllWalletHistory(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(adminServices.GetallWalletHistory(uuid));
    }

}