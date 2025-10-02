package app.employee.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "in_user")
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String user_id;

    @NonNull
    private String username;

    @Indexed(unique = true)
    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<String> roles = new ArrayList<>();

    public void setId(ObjectId id){
        this.id = id;
    }
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRoles(List<String> roles){
        this.roles = roles;
    }

    public void setRoles(String role){
        this.roles.add(role);
    }

    public void setRoles(String[] roles){
        for(int i=0;i<roles.length;i++){
            this.roles.add(roles[i]);
        }
    }

    public ObjectId getId(){
        return this.id;
    }
    
    public String getUser_id(){
        return this.user_id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }

    public List<String> getRoles(){
        return this.roles;
    }

}
