package app.employee.entity;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "in_experience")
@Data
public class UserSkill {

    @Id
    private ObjectId id;

    @NonNull
    @Field("skill_name")
    private String skillName;

    @NonNull
    @Field("profeciency_level")
    private String profeciencyLevel;

    @NonNull
    @Field("years_of_experience")
    private String yearOfExperience;

    @NonNull
    @Field("created_by")
    private String createdBy;

    @NonNull
    @Field("updated_by")
    private String updatedBy;

    @NonNull
    @Field("created_at")
    private Instant createdAt;

    @NonNull
    @Field("updated_at")
    private Instant updatedAt;
}
