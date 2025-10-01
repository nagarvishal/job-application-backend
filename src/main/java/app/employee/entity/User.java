package app.employee.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "in_user")
public class User {

    @NonNull
    private String user_id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<String> roles;
    
    

}
