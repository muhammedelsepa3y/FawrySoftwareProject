package FawrySoftwareSystem.Phase2.FawryServices.Controllers.UserController;

import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.DiscountModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.RefundModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Models.WalletRechargeModel;
import com.fci.advanced.sw.fawrysoftwaresystem.FawryServices.Services.UserServices.UserServices;
import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
public class UserController {

    @Autowired
    private UserServices UserServices;

    @RequestMapping(value = "/feature/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<String>> GetFeatures() {
        return ResponseEntity.ok(UserServices.GetFeatures());
    }

    @RequestMapping(value = "/service/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<String>> GetServices() {
        return ResponseEntity.ok(UserServices.GetServices());
    }
    @RequestMapping(value = "/service/search", method = RequestMethod.GET)
    public ResponseEntity<Object> SearchServices(@RequestBody Map<String,String> query) {
        return ResponseEntity.ok(UserServices.SearchServices(query));
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResponseEntity<Object> AddTransaction(@RequestBody TransactionModel transactionModel, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.AddTransaction(transactionModel, uuid));
    }

    @RequestMapping(value = "/discounts/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<DiscountModel>> GetDiscounts() {
        return ResponseEntity.ok(UserServices.GetDiscounts());
    }

    @RequestMapping(value = "/wallet/get", method = RequestMethod.GET)
    public ResponseEntity<String> GetWallet(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.GetWallet(uuid));
    }
    @RequestMapping(value = "/wallet/add", method = RequestMethod.PUT)
    public ResponseEntity<String> AddToWallet(@RequestBody WalletRechargeModel walletRechargeModel, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.AddToWallet(walletRechargeModel,uuid));
    }
    @RequestMapping(value = "/transactions/getMeTransaction", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionModel>> GetTransactionsForCurrentUser(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.GetTransactions(uuid));
    }



    @RequestMapping(value = "/refund/add", method = RequestMethod.POST)
    public ResponseEntity<String> AddRefund(@RequestBody RefundModel refund, @RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.AddRefund(refund,uuid));
    }

    @RequestMapping(value = "/refund/check", method = RequestMethod.GET)
    public ResponseEntity<List<RefundModel>> CheckRefund(@RequestHeader("uuid") UUID uuid) {
        return ResponseEntity.ok(UserServices.CheckRefund(uuid));
    }




}