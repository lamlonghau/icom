package com.icommerce.userlog.configuration;

import com.icommerce.userlog.core.userlog.port.UserLogPort;
import com.icommerce.userlog.core.userlog.usecase.CreateUserLogUseCase;
import com.icommerce.userlog.core.userlog.usecase.impl.CreateUserLogUseCaseImpl;
import com.icommerce.userlog.persistence.impl.UserLogPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserLogUseCaseConfiguration {

    @Bean
    public UserLogPort userLogPort() {
        return new UserLogPortImpl();
    }

    @Bean
    public CreateUserLogUseCase createUserLogUseCase(UserLogPort userLogPort) {
        return new CreateUserLogUseCaseImpl(userLogPort);
    }
}
