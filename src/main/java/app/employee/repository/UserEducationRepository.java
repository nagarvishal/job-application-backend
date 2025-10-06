package app.employee.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.employee.entity.UserEducation;;

@Repository
public interface UserEducationRepository extends MongoRepository<UserEducation,ObjectId> {
    
}
