package app.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.employee.entity.UserProfile;
import app.employee.repository.UserProfileRepository;


@Component
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;
    
    public void addProfile(UserProfile userprofile, String userid){
        userprofile.setUser_id(userid);

        this.userProfileRepository.save(userprofile);
        
    }

    public void getProfile(String userid){
        
    }

    

}
