package app.employee.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.employee.entity.UserExperience;
import java.util.List;



@Repository
public interface UserExperienceRepository extends MongoRepository<UserExperience,ObjectId> {

    List<UserExperience> findByUserId(String userId);

    UserExperience findByExperienceId(String experienceId);
    
}


