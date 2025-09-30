package app.entity.employee;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "in_user_profile")
public class UserJobProfile {

    @NonNull
    private String job_id;

    @NonNull
    private String user_id;

    @NonNull
    private String employe_status;

    @NonNull
    private String job_title;

    @NonNull
    private String job_location;

    @NonNull
    private String employer;

    @NonNull
    private String primary_industry;

    @NonNull
    private String specialization;

    @NonNull
    private String desired_salary;

    @NonNull
    private String desired_location;

    @NonNull
    private String open_to_work;

    @NonNull
    private String cv_url;

}
