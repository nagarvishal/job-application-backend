package app.employeer.repository;

import org.springframework.stereotype.Repository;

import app.employeer.entity.Company;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;




@Repository
public interface CompanyRepository extends MongoRepository<Company,ObjectId> {
    Company findByCompanyId(String companyId);
    Object deleteByCompanyId(String companyId);
}
