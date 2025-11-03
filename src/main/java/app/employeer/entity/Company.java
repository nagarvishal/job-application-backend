package app.employeer.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "in_company")
@Data
public class Company {
    @Id
    private ObjectId id;
    
    @Field("company_id")
    @Indexed(unique = true)
    private String companyId = "";

    @NonNull
    @Field("company_name")
    @Indexed(unique = true)
    private String companyName = "";

    @NonNull
    private String description;

    @NonNull
    private String industry;

    @NonNull
    private String website;

    @NonNull
    private String location;

    @NonNull
    private List<String> email_domains = new ArrayList<>();

    @NonNull
    @Field("employee_count")
    private Integer employeeCount;

    @Field("created_by")
    private String createdBy;

    
    @Field("updated_by")
    private String updatedBy;

    
    @Field("created_at")
    private Instant createdAt;

    
    @Field("updated_at")
    private Instant updatedAt;

}
