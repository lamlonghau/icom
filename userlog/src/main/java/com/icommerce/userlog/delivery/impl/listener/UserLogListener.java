package com.icommerce.userlog.delivery.impl.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icommerce.userlog.core.userlog.UserLog;
import com.icommerce.userlog.core.userlog.usecase.CreateUserLogUseCase;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserLogListener implements MessageListener {

    private CreateUserLogUseCase createUserLogUseCase;

    public UserLogListener(CreateUserLogUseCase createUserLogUseCase) {
        this.createUserLogUseCase = createUserLogUseCase;
    }

    @Async("defaultPool")
    @Override
    public void onMessage(Message message) {
        if (message == null || message.getBody() == null || message.getBody().length < 1) {
            return;
        }
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final UserLog userLog = mapper.readValue(new String(message.getBody()), UserLog.class);
            createUserLogUseCase.execute(userLog);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Consuming Message - " + new String(message.getBody()));
    }
}
