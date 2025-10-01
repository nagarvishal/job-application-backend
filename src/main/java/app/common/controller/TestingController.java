package app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.entity.UniqueEntity;
import app.common.service.UniqueService;

@RestController
@RequestMapping("/testing")
public class TestingController {

    @Autowired
    UniqueService uniqueService;

    @PostMapping("/entity")
    public ResponseEntity<?> createUniqueEntity(@RequestBody UniqueEntity uniqueEntity){
        try{

            this.uniqueService.setUniqueEntiry(uniqueEntity);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
