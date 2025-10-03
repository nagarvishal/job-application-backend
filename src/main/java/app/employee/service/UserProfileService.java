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
        
        userprofile.setUserId(userid);

        this.userProfileRepository.save(userprofile);
        
    }

    public UserProfile getProfile(String userid){
        return this.userProfileRepository.findByUserId(userid);
    }

    public void updateProfile(String userid, UserProfile userprofile){

    }

    public void deleteProfile(String userid){

    }



}
