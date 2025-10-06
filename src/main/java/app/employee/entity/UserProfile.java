package app.employee.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.NonNull;

@Document(collection = "in_user_profile")
public class UserProfile {
    
    @Id
    private ObjectId id;

    public void setId(ObjectId id){
        this.id = id;
    }
    public ObjectId getId(){
        return this.id;
    }

    @NonNull
    @Indexed(unique = true)
    @Field("profile_id")
    private String profileId;
    public void setProfileId(String profileid){
        this.profileId = profileid;
    }
    public String getProfileId(){
        return this.profileId;
    }


    @NonNull
    @Indexed(unique = true)
    @Field("user_id")
    private String userId;
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return this.userId;
    }

    @NonNull
    private String employementstatus;
    public void setEmployementstatus(String employementstatus){
        this.employementstatus = employementstatus;
    }
    public String getEmployementstatus(){
        return this.employementstatus;
    }

    @NonNull
    private String jobtitle;
    public void setJobtitle(String jobtitle){
        this.jobtitle = jobtitle;
    }
    public String getJobtitle(){
        return this.jobtitle;
    }

    @NonNull
    private String city;
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }

    @NonNull
    private String state;
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }

    @NonNull
    private String country;
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    



    @NonNull
    private String industry;
    public void setIndustry(String industry){
        this.industry = industry;
    }
    public String getIndustry(){
        return this.industry;
    }

    @NonNull
    private String specialization;
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public String getSpecialization(){
        return this.specialization;
    }


    @NonNull
    private String desired_jobtitle;
    public void setDesired_jobtitle(String desired_jobtitle){
        this.desired_jobtitle = desired_jobtitle;
    }
    public String getDesired_jobtitle(){
        return this.desired_jobtitle;
    }

    @NonNull
    private String desired_minimumsalary;
    public void setDesired_minimumsalary(String desired_minimumsalary){
        this.desired_minimumsalary = desired_minimumsalary;
    }
    public String getDesired_minimumsalary(){
        return this.desired_minimumsalary;
    }

    @NonNull
    private String desired_location;
    public void setDesired_location(String desired_location){
        this.desired_location = desired_location;
    }
    public String getDesired_location(){
        return this.desired_location;
    }

    private String currentorganization;
    public void setCurrentorganization(String currentorganization){
        this.currentorganization = currentorganization;
    }
    public String getCurrentorganization(){
        return this.currentorganization;
    }
}
