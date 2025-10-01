package app.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.employee.entity.User;
import app.employee.service.UserService;
import app.exceptions.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{

            this.userService.createUser(user);

            return new ResponseEntity<>(new Message(0,"User Successfully Inserted"),HttpStatus.ACCEPTED);

        }catch(Exception e){

            return new ResponseEntity<>(new Message(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
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
