package app.service.employee;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.employee.User;
import app.repository.employee.UserRepository;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){

        this.userRepository.save(user);
        return null;
    }
    
}
