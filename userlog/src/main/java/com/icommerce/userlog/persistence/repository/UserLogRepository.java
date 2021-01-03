package com.icommerce.userlog.persistence.repository;

import com.icommerce.userlog.persistence.entity.UserLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "user-logs", path = "user-logs")
@Repository
public interface UserLogRepository extends MongoRepository<UserLogEntity, String> {
}
