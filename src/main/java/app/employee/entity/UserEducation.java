package app.employee.entity;

import java.sql.Date;
import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.NonNull;

import lombok.Data;

@Document(collection = "in_education")
@Data
public class UserEducation {

    @Id
    private ObjectId id;

    @NonNull
    @Field("user_id")
    private String userId = "";
    
    @NonNull
    @Field("education_id")
    private String educationId = "";

    @NonNull
    private String degree = "";

    @NonNull
    @Field("institute_name")
    private String instituteName;

    @NonNull
    @Field("year_of_passing")
    private String yearOfPassing;

    @NonNull
    private Integer grads;

    @NonNull
    @Field("created_by")
    private String createdBy = "";

    @NonNull
    @Field("updated_by")
    private String updatedBy = "";

    
    @Field("created_at")
    private Instant createdAt;

    @NonNull
    @Field("updated_at")
    private Instant updatedAt = Instant.now();

}
