package app.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.employee.entity.User;
import app.exceptions.Message;

@RestController
@RequestMapping("/user/skill")
public class UserSkillController {

    @GetMapping("/get")
    public ResponseEntity<?> getUserSkill(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> creatUserSkill(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserSkill(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserSkill(){
        try{
            return null;
        }catch(Exception e){

            return new ResponseEntity<>(new Message<User>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
