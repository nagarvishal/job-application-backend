package app.form.controller;

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

import app.exceptions.Message;
import app.form.entity.Form;
import app.form.service.FormService;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    FormService formService;
    

    @PostMapping("/create")
    public ResponseEntity<?> createForm(@RequestBody() Form form){
        try{
            Object response = formService.createForm(form);
            
            return new ResponseEntity<>(new Message<Object>( 0,"Post Create Successfully",response),HttpStatus.ACCEPTED);
        }catch(Exception e){
             return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        


    }


    @GetMapping("/get")
    public ResponseEntity<?> getForm(){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateForm(){
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteForm(){
        return null;
    }



}
