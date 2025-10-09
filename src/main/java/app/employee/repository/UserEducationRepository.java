package app.employee.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.employee.entity.UserEducation;
import java.util.List;
;

@Repository
public interface UserEducationRepository extends MongoRepository<UserEducation,ObjectId> {

    List<UserEducation> findByUserId(String userId);

    UserEducation findByEducationId(String educationId);

    void deleteByUserId(String userId);

    void deleteByEducationId(String educationId);



}
