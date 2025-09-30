package app.repository.employee;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.entity.employee.UserJobProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserJobProfile,ObjectId> {

}
