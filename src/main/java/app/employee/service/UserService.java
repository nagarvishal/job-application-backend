package app.employee.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employee.entity.User;
import app.employee.repository.UserRepository;


@Component
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    @Autowired
    UniqueService uniqueService;

    

    public void createUser(User user){

        String uniqueId = this.uniqueService.generateUniqueNumber("UI", "", "user_id");

        System.out.println(uniqueId);

        user.setUser_id(uniqueId);

        user.setPassword(UserService.passwordEncoder.encode(user.getPassword()));

        user.setRoles("EMPLOYEE");
        
        this.userRepository.save(user); 

        
        
    }
    
}
