package app.employee.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.mongodb.lang.NonNull;

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
    private String user_id;
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }
    public String getUser_id(){
        return this.user_id;
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
    private String location;
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
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
}
