package app.employee.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import app.employee.entity.User;
import app.employee.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){

        this.userRepository.save(user);
        
    }
    
}
