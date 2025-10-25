package ar.com.itec1misiones.javatemplate.security.service.impl;

import ar.com.itec1misiones.javatemplate.security.entity.UserModel;
import ar.com.itec1misiones.javatemplate.security.repository.UserRepository;
import ar.com.itec1misiones.javatemplate.security.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String username, String password) {

        UserModel user = this.userRepository.findUserByUserAndPassword(username, password);

        if (user != null) {
            return true;
        }

        return false;
    }
}
