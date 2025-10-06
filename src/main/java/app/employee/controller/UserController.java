package app.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;

import app.employee.entity.User;
import app.employee.service.UserService;
import app.exceptions.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/fetch")
    public ResponseEntity<?> getUser(@RequestBody User user){
        try{

            User dbUser = this.userService.fetchUser(user.getEmail(), user.getPassword());

            return new ResponseEntity<>(new Message<User>( 0, "User Data", dbUser),HttpStatus.ACCEPTED);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{

            this.userService.createUser(user);

            return new ResponseEntity<>(new Message<>(0,"User Successfully Inserted"),HttpStatus.ACCEPTED);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try{
            Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

            String user_id = authentication.getName();

            this.userService.updateUser(user_id, user);

            return new ResponseEntity<>("User Update Succeesfully",HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(){
        try{
            Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
            String user_id = authentication.getName();
            this.userService.deleteUser(user_id);
            return new ResponseEntity<>("User Update Succeesfully",HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
