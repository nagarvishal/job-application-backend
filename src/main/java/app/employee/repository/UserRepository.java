package app.employee.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import app.employee.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,ObjectId> {
    User findByEmail(String email);
    void deleteByEmail(String email);
    User findByUserId(String userId);
    void deleteByUserId(String userId);


}