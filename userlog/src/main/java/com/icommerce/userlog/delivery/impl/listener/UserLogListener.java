package com.icommerce.userlog.delivery.impl.listener;

import com.icommerce.userlog.core.userlog.usecase.CreateUserLogUseCase;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLogListener implements MessageListener {

    @Autowired
    private CreateUserLogUseCase createUserLogUseCase;

    @Override
    public void onMessage(Message message) {
        System.out.println("Consuming Message - " + new String(message.getBody()));
    }
}
