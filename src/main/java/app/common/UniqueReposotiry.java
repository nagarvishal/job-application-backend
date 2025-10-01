package app.common;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueReposotiry extends MongoRepository<UniqueEntity,ObjectId> {
    UniqueEntity findByColumn(String column);  
} 