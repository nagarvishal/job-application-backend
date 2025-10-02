package app.employee.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.exceptions.Message;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

    @PostMapping("/add")
    public ResponseEntity<?> addProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProfile(){
        try{
            return null;
        }catch(Exception e){
            return new ResponseEntity<>(new Message(-102,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
