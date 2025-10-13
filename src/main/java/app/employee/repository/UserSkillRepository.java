package app.employee.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import app.employee.entity.UserSkill;


@Repository
public interface UserSkillRepository extends MongoRepository<UserSkill,ObjectId> {
    List<UserSkill> findByUserId(String userId);
    UserSkill findBySkillId(String skillId);
    void deleteByUserId(String userId);
    void deleteBySkillId(String skillId);
}
