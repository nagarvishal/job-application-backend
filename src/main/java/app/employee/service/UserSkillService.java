package app.employee.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employee.entity.UserSkill;
import app.employee.repository.UserSkillRepository;

@Component
public class UserSkillService {

    @Autowired
    UserSkillRepository userSkillRepository;

    @Autowired
    UniqueService uniqueService;

    public void addSkill(UserSkill userSkill){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        String skill_id = this.uniqueService.generateUniqueNumber("SK","","skill_id");

        userSkill.setUserId(user_id);
        userSkill.setSkillId(skill_id);
        userSkill.setCreatedBy(user_id);
        userSkill.setUpdatedAt(Instant.now());
        userSkill.setUpdatedBy(user_id);
        userSkill.setCreatedAt(Instant.now());

        this.userSkillRepository.save(userSkill);

    }

    public List<UserSkill> getSkill(){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        List<UserSkill> userSkills = this.userSkillRepository.findByUserId(user_id);
        
        return userSkills;

    }

    public void updateSkill(UserSkill userSkill,String skilllId) {

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        UserSkill dbUserSkill = this.userSkillRepository.findBySkillId(skilllId);
        if(dbUserSkill !=null){
            dbUserSkill.setSkillName((userSkill.getSkillName()!=null && !userSkill.getSkillName().equals(""))?userSkill.getSkillName() : dbUserSkill.getSkillName());
            dbUserSkill.setYearOfExperience((userSkill.getYearOfExperience()!=null)?userSkill.getYearOfExperience() : dbUserSkill.getYearOfExperience());
            dbUserSkill.setProfeciencyLevel((userSkill.getProfeciencyLevel()!=null)?userSkill.getProfeciencyLevel() : dbUserSkill.getProfeciencyLevel());
            dbUserSkill.setUpdatedAt(Instant.now());
            dbUserSkill.setUpdatedBy(user_id);

            this.userSkillRepository.save(dbUserSkill);
        }
        else{
            throw new RuntimeException("Skill Is Not Present in Database");
        }
    }

    public void deleteSkill(String skillId){

        this.userSkillRepository.deleteBySkillId(skillId);
    }

    public void deleteSkillByUserId(){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();
        
        this.userSkillRepository.deleteByUserId(user_id);


    }

    

}
