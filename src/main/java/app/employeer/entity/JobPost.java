package app.employeer.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import app.employeer.enums.JobStatus;
import app.employeer.enums.JobType;
import lombok.Data;
import lombok.NonNull;

@Document(collection = "in_jobpost")
@Data
public class JobPost {
    
    @Id
    private ObjectId id;

    @Field("job_id")
    @Indexed(unique = true)
    private String jobId;

    @Field("company_id")
    private String companyId = "";

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private List<String> location = new ArrayList<String>();


    @Field("min_salary")
    private Integer minSalary;

    @Field("max_salary")
    private Integer maxSalary;

    @NonNull
    @Field("job_type")      
    private JobType jobType;


    private JobStatus status;

    private List<String> skills = new ArrayList<String>();

    @Field("created_by")
    private String createdBy;

    
    @Field("updated_by")
    private String updatedBy;

    
    @Field("created_at")
    private Instant createdAt;

    
    @Field("updated_at")
    private Instant updatedAt;

}
