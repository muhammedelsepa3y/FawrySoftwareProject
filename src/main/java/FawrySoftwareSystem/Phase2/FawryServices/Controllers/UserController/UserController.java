package FawrySoftwareSystem.Phase2.FawryServices.Controllers.UserController;


import FawrySoftwareSystem.Phase2.Authentication.Model.TransactionModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.DiscountModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.RefundModel;
import FawrySoftwareSystem.Phase2.FawryServices.Models.WalletRechargeModel;
import FawrySoftwareSystem.Phase2.FawryServices.Services.UserServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/feature/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<String>> GetFeatures() {
        return ResponseEntity.ok(userServices.GetFeatures());
    }

    @RequestMapping(value = "/service/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<String>> GetServices() {
        return ResponseEntity.ok(userServices.GetServices());
    }
    @RequestMapping(value = "/service/search", method = RequestMethod.GET)
    public ResponseEntity<Object> SearchServices(@RequestBody Map<String,String> query) {
        return ResponseEntity.ok(userServices.SearchServices(query));
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResponseEntity<Object> AddTransaction(@RequestBody TransactionModel transactionModel, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.AddTransaction(transactionModel, uuid));
    }

    @RequestMapping(value = "/discounts/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<DiscountModel>> GetDiscounts() {
        return ResponseEntity.ok(userServices.GetDiscounts());
    }

    @RequestMapping(value = "/wallet/get", method = RequestMethod.GET)
    public ResponseEntity<String> GetWallet(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.GetWallet(uuid));
    }
    @RequestMapping(value = "/wallet/add", method = RequestMethod.PUT)
    public ResponseEntity<String> AddToWallet(@RequestBody WalletRechargeModel walletRechargeModel, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.AddToWallet(walletRechargeModel,uuid));
    }
    @RequestMapping(value = "/transactions/getMeTransaction", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionModel>> GetTransactionsForCurrentUser(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.GetTransactions(uuid));
    }



    @RequestMapping(value = "/refund/add", method = RequestMethod.POST)
    public ResponseEntity<String> AddRefund(@RequestBody RefundModel refund, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.AddRefund(refund,uuid));
    }

    @RequestMapping(value = "/refund/check", method = RequestMethod.GET)
    public ResponseEntity<List<RefundModel>> CheckRefund(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(userServices.CheckRefund(uuid));
    }




}