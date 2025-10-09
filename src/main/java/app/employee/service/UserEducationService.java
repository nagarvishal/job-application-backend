package app.employee.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import app.employee.entity.UserEducation;
import app.employee.repository.UserEducationRepository;
import app.common.service.UniqueService;

@Component
public class UserEducationService {

    @Autowired
    UniqueService uniqueService;

    @Autowired
    UserEducationRepository userEducationRepository;
    
    public void addEducation(UserEducation userEducation){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        userEducation.setUserId(user_id);

        String education_id = this.uniqueService.generateUniqueNumber("ED", "", "education_id");

        System.out.println(education_id);

        userEducation.setEducationId(education_id);
        userEducation.setCreatedBy(user_id);
        userEducation.setUpdatedBy(user_id);
        userEducation.setUpdatedAt(Instant.now());
        userEducation.setCreatedAt(Instant.now());

        System.out.println(userEducation);

        this.userEducationRepository.save(userEducation);

    }

    public List<UserEducation> getEducation(){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        List<UserEducation> userEducationList = this.userEducationRepository.findByUserId(user_id);
        
        return userEducationList;

    }

    public void updateEducation(String education_id, UserEducation userEducation){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        UserEducation dbUserEducation = this.userEducationRepository.findByEducationId(education_id);


        if(dbUserEducation!=null){

            dbUserEducation.setDegree((userEducation.getDegree()!=null && !userEducation.getDegree().equals(""))?userEducation.getDegree() : dbUserEducation.getDegree());
            dbUserEducation.setGrads((userEducation.getGrads()!=null)?userEducation.getGrads() : dbUserEducation.getGrads());
            dbUserEducation.setYearOfPassing((userEducation.getYearOfPassing()!=null && !userEducation.getYearOfPassing().equals(""))?userEducation.getYearOfPassing() : dbUserEducation.getYearOfPassing());
            dbUserEducation.setInstituteName((userEducation.getInstituteName()!=null && !userEducation.getInstituteName().equals(""))?userEducation.getInstituteName() : dbUserEducation.getInstituteName());
            dbUserEducation.setUpdatedBy(user_id);
            dbUserEducation.setUpdatedAt(Instant.now());

            this.userEducationRepository.save(dbUserEducation);

            return;

        }
        throw new UsernameNotFoundException("User Not Found Exception");
    }

    public void deleteEducation(String education_id){

        this.userEducationRepository.deleteByEducationId(education_id);

    }




}
