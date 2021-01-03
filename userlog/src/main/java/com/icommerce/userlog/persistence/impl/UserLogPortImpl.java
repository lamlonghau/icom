package com.icommerce.userlog.persistence.impl;

import com.icommerce.userlog.core.userlog.UserLog;
import com.icommerce.userlog.core.userlog.port.UserLogPort;
import com.icommerce.userlog.persistence.entity.UserLogEntity;
import com.icommerce.userlog.persistence.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLogPortImpl implements UserLogPort {

    @Autowired
    private UserLogRepository userLogRepository;

    @Override
    public String create(UserLog userLog) {
        final UserLogEntity entity = new UserLogEntity();
        entity.setId(userLog.getId());
        entity.setAction(userLog.getAction());
        entity.setCreatedOn(userLog.getCreatedOn());
        entity.setUsername(userLog.getUsername());
        entity.setDescription(userLog.getDescription());
        return userLogRepository.save(entity).getId();
    }
}
