package app.employee.entity;

import java.time.Instant;
import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "in_experience")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserExperience {

    @Id
    private ObjectId id;

    @NonNull
    @Field("experience_id")
    private String experienceId;

    @NonNull
    @Field("user_id")
    private String userId;

    @NonNull
    @Field("company_name")
    private String companyName;

    @NonNull
    @Field("job_title")
    private String jobTitle;

    @NonNull
    @Field("start_date")
    private LocalDate startDate;

    @Field("end_date")
    private LocalDate endDate;

    @NonNull
    private String description;

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
