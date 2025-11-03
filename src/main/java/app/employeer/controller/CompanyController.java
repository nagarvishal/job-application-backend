package app.employeer.controller;


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

import app.employeer.entity.Company;
import app.employeer.service.CompanyService;
import app.exceptions.Message;

@RestController
@RequestMapping("/employeer")
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @PostMapping("/register")
    public ResponseEntity<?> registerCompany(@RequestBody Company company){
        try{

            Object obj = this.companyService.registerCompany(company);

            return new ResponseEntity<>(new Message<Object>( 0,"Company Register Successfully",obj),HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/info/{company_id}")
    public ResponseEntity<?> getCompanyInfo(@PathVariable String company_id ){
        try{
            Company company = this.companyService.getCompanyInfo(company_id);
            return new ResponseEntity<>(new Message<Company>( 0,"Company info",company),HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update-info/{company_id}")
    public ResponseEntity<?> updateCompanyInfo(@PathVariable String company_id,@RequestBody Company company){
        try{

            Object obj = this.companyService.updateCompanyInfo(company, company_id);
            return new ResponseEntity<>(new Message<Object>( 0,"Company Update Successfully",obj),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete/{company_id}")
    public ResponseEntity<?> deleteCompany(@PathVariable String company_id){
        try{
            Object obj = this.companyService.deleteCompnay(company_id);

            return new ResponseEntity<>(new Message<Object>( 0,"Company Deleted Successfully",obj),HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>(new Message<>( 0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }




}
