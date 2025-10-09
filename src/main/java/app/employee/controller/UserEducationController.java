package app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.employee.entity.User;
import app.employee.entity.UserEducation;
import app.employee.service.UserEducationService;
import app.exceptions.Message;

@RestController
@RequestMapping("/user/education")
public class UserEducationController {

    @Autowired
    UserEducationService userEducationService;

    @GetMapping("/get")
    public ResponseEntity<?> getUserEducation(){
        try{

            List<UserEducation> userEducations =  this.userEducationService.getEducation();

            return new ResponseEntity<>(new Message<List<UserEducation>>( 0,"User Education Details",userEducations),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> creatUserEducation(@RequestBody UserEducation userEducation){
        try{

            this.userEducationService.addEducation(userEducation);

            return new ResponseEntity<>(new Message<User>( 0,"Education Added Successfully"),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update/{education_id}")
    public ResponseEntity<?> updateUserEducation(@PathVariable String education_id,@RequestBody UserEducation userEducation){
        try{

            
            this.userEducationService.updateEducation(education_id,userEducation);

            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete/{education_id}")
    public ResponseEntity<?> deleteUserEducation(@PathVariable String education_id){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
