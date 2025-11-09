package app.form.entity;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NonNull;

@Document(collection = "in_form")
@Data
public class Form {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    @Field("form_id")   // maps to MongoDB snake_case
    private String formId = "";

    @NonNull
    private String formname;

    @NonNull
    private String description;

    @NonNull
    private String data;

    @Field("created_by")
    private String createdBy;

    
    @Field("updated_by")
    private String updatedBy;

    
    @Field("created_at")
    private Instant createdAt;

    
    @Field("updated_at")
    private Instant updatedAt;

}
