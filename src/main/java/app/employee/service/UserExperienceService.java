package app.employee.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employee.entity.UserExperience;
import app.employee.repository.UserExperienceRepository;

@Component
public class UserExperienceService {

    @Autowired
    UserExperienceRepository userExperienceRepository;

    @Autowired
    UniqueService uniqueService;
    
    public void addExperience(UserExperience userExperience){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        userExperience.setUserId(user_id);
        
        String experienceId = this.uniqueService.generateUniqueNumber("EX","","experience_id");

        userExperience.setExperienceId(experienceId);
        userExperience.setCreatedBy(user_id);
        userExperience.setUpdatedBy(user_id);
        userExperience.setUpdatedAt(Instant.now());
        userExperience.setCreatedAt(Instant.now());

        this.userExperienceRepository.save(userExperience);

    }

    public List<UserExperience> getExperience(){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        List<UserExperience> userExperiences = this.userExperienceRepository.findByUserId(user_id);

        return userExperiences;


    }

    public void updateExperience(String experience_id, UserExperience userExperience){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        UserExperience dbUserExperience = this.userExperienceRepository.findByExperienceId(experience_id);

        if(dbUserExperience!=null){

            dbUserExperience.setCompanyName( (userExperience.getCompanyName()!=null && !userExperience.getCompanyName().equals(""))?userExperience.getCompanyName() : dbUserExperience.getCompanyName() );
            dbUserExperience.setCurrentlyWorking((userExperience.getCurrentlyWorking()!=null )?userExperience.getCurrentlyWorking() : dbUserExperience.getCurrentlyWorking());
            dbUserExperience.setJobTitle((userExperience.getJobTitle()!=null )?userExperience.getJobTitle() : dbUserExperience.getJobTitle());
            dbUserExperience.setDescription((userExperience.getDescription()!=null )?userExperience.getDescription() : dbUserExperience.getDescription());
            dbUserExperience.setEndDate((userExperience.getEndDate()!=null )?userExperience.getEndDate() : dbUserExperience.getEndDate());
            dbUserExperience.setStartDate((userExperience.getStartDate()!=null )?userExperience.getStartDate() : dbUserExperience.getStartDate());
            dbUserExperience.setUpdatedAt(Instant.now());
            dbUserExperience.setUpdatedBy(user_id);

            this.userExperienceRepository.save(dbUserExperience);
            return;

        }
        else{
            throw new UsernameNotFoundException("User not Found");
        }
    }

    public void deleteExperience(String experience_id){
        
    }
    

}
