package app.employee.entity;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "in_skills")
@Data
public class UserSkill {

    @Id
    private ObjectId id;

    @NonNull
    @Field("user_id")
    private String userId = "";

    @NonNull
    @Field("skill_id")
    private String skillId = "";

    @NonNull
    @Field("skill_name")
    private String skillName = "";

    
    @Field("profeciency_level")
    private Integer profeciencyLevel;

    
    @Field("years_of_experience")
    private Integer yearOfExperience;

    
    @Field("created_by")
    private String createdBy;

    
    @Field("updated_by")
    private String updatedBy;

    
    @Field("created_at")
    private Instant createdAt;

    
    @Field("updated_at")
    private Instant updatedAt;
}
