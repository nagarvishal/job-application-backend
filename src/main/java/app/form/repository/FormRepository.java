package app.form.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.form.entity.Form;

@Repository
public interface FormRepository extends MongoRepository<Form,ObjectId> {
    
}
