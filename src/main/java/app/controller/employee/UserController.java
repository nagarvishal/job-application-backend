package app.controller.employee;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.employee.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public void createUser(@RequestBody User user){
        
    }

    @GetMapping("/{user_id}")
    public void getUser(@PathVariable String user_id){

    }

    @PutMapping("/{user_id}")
    public void updateUser(@PathVariable String user_id, @RequestBody User user){

    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id){
          
    }

}
