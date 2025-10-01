package app.repository.common;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.entity.common.UniqueEntity;

@Repository
public interface UniqueReposotiry extends MongoRepository<UniqueEntity,ObjectId> {
    UniqueEntity findByColumn(String column);  
} 