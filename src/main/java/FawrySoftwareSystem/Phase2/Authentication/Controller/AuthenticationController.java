package FawrySoftwareSystem.Phase2.Authentication.Controller;

import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.Authentication.Services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationServices authenticationServices;


    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public ResponseEntity<String> Register(@RequestBody UserModel user) {
        return ResponseEntity.ok(authenticationServices.UserRegister(user));
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<String> Login(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(authenticationServices.UserLogin(userModel.getEmail(), userModel.getPassword()));
    }


    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)
    public ResponseEntity<String> Logout(@RequestHeader("id") UUID id) {
        return ResponseEntity.ok(authenticationServices.UserLogout(id));
    }

    @RequestMapping(value = "/auth/me", method = RequestMethod.GET)
    public ResponseEntity<Object> CurrentUser( @RequestHeader("id") UUID id) {
        return ResponseEntity.ok(authenticationServices.CurrentUser(id));
    }


}
