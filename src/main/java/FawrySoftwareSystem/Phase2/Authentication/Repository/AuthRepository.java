package com.fci.advanced.sw.fawrysoftwaresystem.authentication.Repository;

import com.fci.advanced.sw.fawrysoftwaresystem.authentication.Model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AuthRepository {

    private   List<UserModel> users;
    private AuthRepository() {
        users = new ArrayList<>();
    }
    public boolean userExistBefore(UserModel user) {
        for (UserModel userModel : users) {
            if (userModel.getUsername().equals(user.getUsername()) || userModel.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public UUID userRegistered(String email, String password) {
        for (UserModel userModel : users) {
            if (userModel.getEmail().equals(email) && userModel.getPassword().equals(password)) {
                if(!userModel.isLogin()) {
                    userModel.setLogin(true);
                    userModel.setId(UUID.randomUUID());
                    return userModel.getId();
                }
                return userModel.getId();
            }
        }
        return null;
    }

    public boolean userLogin(UUID id) {
        for (UserModel userModel : users) {
            if (userModel.getId().equals(id) && userModel.isLogin()) {
                userModel.setLogin(false);
                return true;
            }
        }
        return false;
    }

    public UserModel userDetails(UUID id) {
        for (UserModel userModel : users) {
            if (userModel.getId().equals(id) && userModel.isLogin()) {
                return userModel;
            }
        }
        return null;
    }
    public UserModel userexistToPay(UUID id) {
        for (UserModel userModel : users) {
            if (userModel.getId().equals(id) && userModel.isLogin()) {
                return userModel;
            }
        }
        return null;
    }
}
