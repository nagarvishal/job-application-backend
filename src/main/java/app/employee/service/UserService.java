package app.employee.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employee.entity.User;
import app.employee.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    @Autowired
    UniqueService uniqueService;

    // Logger logger = LoggerFactory.getLogger(UserService.class); // in place of this we can use @slf4j anotation on class

    

    public void createUser(User user){
        try{

            String uniqueId = this.uniqueService.generateUniqueNumber("UI", "", "user_id");
            System.out.println(uniqueId);
            user.setUserId(uniqueId);
            user.setPassword(UserService.passwordEncoder.encode(user.getPassword()));
            user.setRoles("EMPLOYEE");
            this.userRepository.save(user); 

        }catch(Exception e){

            // logger.error("Error Occured for {}",user.getUsername(),e);
            // logger.warn("hahahahahahahahahaha");
            // logger.debug("hahahahahahahahahaa");
            // logger.trace("hahhaahahahahahahah");
            // logger.info("hahahahahahahahahaha");
            
            log.error("Error Occured for {}",user.getUsername(),e);

            throw new RuntimeException(e.getMessage(),e);
        }
        
    }

    public User fetchUser(String email, String password){
        User dbUser = this.findByEmail(email);
        if(dbUser!=null){

            String dbPassword = dbUser.getPassword();

            if(UserService.passwordEncoder.matches(password, dbPassword)){
                
                return dbUser;
                
            }
            else{
                throw new UsernameNotFoundException("Given Password is incorrent");
            }
        }
        throw new UsernameNotFoundException("User Not Found");
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
