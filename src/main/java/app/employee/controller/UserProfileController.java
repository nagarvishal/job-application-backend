package app.employee.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.employee.entity.UserProfile;
import app.employee.service.UserProfileService;
import app.exceptions.Message;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/add")
    public ResponseEntity<?> addProfile(@RequestBody UserProfile userProfile){
        try{
            Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

            String user_id = authentication.getName();

            this.userProfileService.addProfile(userProfile, user_id);

            return new ResponseEntity<>(new Message<>(0,"User Profile Successfully Inserted"),HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getProfile(){
        try{
            Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

            String user_id = authentication.getName();

            UserProfile userProfile = this.userProfileService.getProfile(user_id);

            return new ResponseEntity<>(new Message<UserProfile>(0,"User Profile Data",userProfile),HttpStatus.ACCEPTED);



        }catch(Exception e){
            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message<>(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
