package com.icommerce.userlog.core.userlog.usecase.impl;

import com.icommerce.userlog.core.userlog.UserLog;
import com.icommerce.userlog.core.userlog.port.UserLogPort;
import com.icommerce.userlog.core.userlog.usecase.CreateUserLogUseCase;

public class CreateUserLogUseCaseImpl implements CreateUserLogUseCase {

    private UserLogPort userLogPort;

    public CreateUserLogUseCaseImpl(UserLogPort userLogPort) {
        this.userLogPort = userLogPort;
    }

    @Override
    public String execute(UserLog userLog) {
        userLog.validateSelf();
        return userLogPort.create(userLog);
    }
}
