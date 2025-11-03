package app.employeer.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.employeer.entity.JobPost;

@Repository
public interface JobPostRepository extends MongoRepository<JobPost,ObjectId> {
    
}
