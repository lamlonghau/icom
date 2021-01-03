package com.icommerce.userlog.persistence.repository;

import com.icommerce.userlog.persistence.entity.UserLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends MongoRepository<UserLogEntity, String> {
}
