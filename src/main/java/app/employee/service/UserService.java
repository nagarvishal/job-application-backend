package app.employee.service;


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
        user.setUserId(uniqueId);
        user.setPassword(UserService.passwordEncoder.encode(user.getPassword()));
        user.setRoles("EMPLOYEE");
        this.userRepository.save(user); 
    }

    public void updateUser(String user_id, User user){

        User dbUser = this.findByEmail(user_id);
        if(dbUser != null){
            dbUser.setEmail((user.getEmail()!=null && !user.getEmail().equals(""))?user.getEmail() : dbUser.getEmail());
            dbUser.setPassword((user.getPassword()!=null && !user.getPassword().equals(""))?UserService.passwordEncoder.encode(user.getPassword()) : dbUser.getPassword());
            dbUser.setUsername((user.getUsername()!=null && !user.getUsername().equals(""))?user.getUsername() : dbUser.getUsername());
            this.userRepository.save(dbUser);
        }
    }

    public User findByUserId(String userid){
        return this.userRepository.findByUserId(userid);
    }
    public void deleteUser(String userid){
        this.userRepository.deleteByUserId(userid);
    }

    public User findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
    
}
