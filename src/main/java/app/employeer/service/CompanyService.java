package app.employeer.service;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employeer.entity.Company;
import app.employeer.repository.CompanyRepository;

@Component
public class CompanyService {
    
    
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UniqueService uniqueService;

    public Object registerCompany(Company company){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        String company_id = uniqueService.generateUniqueNumber("CP","","company_id");
        company.setCompanyId(company_id);

        company.setCreatedBy(user_id);
        company.setUpdatedAt(Instant.now());
        company.setUpdatedBy(user_id);
        company.setCreatedAt(Instant.now());

        Object data = this.companyRepository.save(company);
        return data;
    }

    public Company getCompanyInfo(String compnay_id){

        Company company = this.companyRepository.findByCompanyId(compnay_id);

        return company;

    }

    public Object updateCompanyInfo(Company company, String company_id){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        Company dbCompany = this.companyRepository.findByCompanyId(company_id);

        if(dbCompany!=null){
            dbCompany.setCompanyName((company.getCompanyName()!=null && !company.getCompanyName().equals("")) ?company.getCompanyName() : dbCompany.getCompanyName() );
            dbCompany.setDescription((company.getDescription()!=null && !company.getDescription().equals("")) ?company.getDescription() : dbCompany.getDescription() );
            dbCompany.setIndustry((company.getIndustry()!=null && !company.getIndustry().equals("")) ?company.getIndustry() : dbCompany.getIndustry() );
            dbCompany.setWebsite((company.getWebsite()!=null && !company.getWebsite().equals("")) ?company.getWebsite() : dbCompany.getWebsite() );
            dbCompany.setLocation((company.getLocation()!=null && !company.getLocation().equals("")) ?company.getLocation() : dbCompany.getLocation() );
            dbCompany.setEmployeeCount(company.getEmployeeCount()!=null ? company.getEmployeeCount() : dbCompany.getEmployeeCount());

            dbCompany.setUpdatedAt(Instant.now());
            dbCompany.setUpdatedBy(user_id);
            
            
            Object response = this.companyRepository.save(dbCompany);
            return response;
        }
        else{
            throw new RuntimeException("Company Not Found in Database");
        }
    }

    public Object deleteCompnay(String company_id){

        Object response = this.companyRepository.deleteByCompanyId(company_id);
        return response;

    }








}
