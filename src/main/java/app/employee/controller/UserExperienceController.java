package app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.employee.entity.User;
import app.employee.entity.UserExperience;
import app.employee.service.UserExperienceService;
import app.exceptions.Message;

@RestController
@RequestMapping("/user/experience")
public class UserExperienceController {

    @Autowired
    UserExperienceService userExperienceService;

    @GetMapping("/get")
    public ResponseEntity<?> getUserExperience(){
        try{
            List<UserExperience> userExperiecelist =   this.userExperienceService.getExperience();

            return new ResponseEntity<>(new Message<List<UserExperience>>(0,"User Experiece Data",userExperiecelist),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> creatUserExperience(@RequestBody UserExperience userexperience){
        try{

            this.userExperienceService.addExperience(userexperience);
            
             return new ResponseEntity<>(new Message<User>( 0,"Experience Added Successfully"),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( -102 , e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserExperience(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserExperience(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
