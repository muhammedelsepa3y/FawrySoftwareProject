package FawrySoftwareSystem.Phase2.Authentication.Services;

import FawrySoftwareSystem.Phase2.Authentication.Model.UserModel;
import FawrySoftwareSystem.Phase2.Authentication.Repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationServices {
    private final AuthRepository authRepository;
    public AuthenticationServices(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String UserRegister(UserModel user) {
        if (authRepository.userExistBefore(user)) {
            return "User Registered Successfully";
        } else {
            return "User Already Exists";
        }
    }

    public String UserLogin(String email, String password) {
        UUID id = authRepository.userRegistered(email, password);
        String Response = "";
        if (id != null) {
            Response = "User Logged In Successfully\n";
            Response+= "User Id: " + id;
            return Response;

        } else {
            Response = "User Not Found";
            return Response;
        }
    }

    public String UserLogout(UUID id) {
        if(authRepository.userLogin(id)) {
            return "User Logged Out Successfully";
        } else {
            return "User Not Found Or Not Logged In";
        }
    }

    public Object CurrentUser(UUID id) {
        UserModel user = authRepository.userDetails(id);
        if(user != null) {
            return user;
        } else {
            return "User Not Found Or Not Logged In";
        }
    }

}
