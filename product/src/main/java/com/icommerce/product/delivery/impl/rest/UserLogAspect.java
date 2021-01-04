package com.icommerce.product.delivery.impl.rest;

import com.icommerce.product.core.shared.ConstantUtils;
import com.icommerce.product.core.shared.LocalProfile;
import com.icommerce.product.core.userlog.UserAction;
import com.icommerce.product.core.userlog.UserLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class UserLogAspect {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.exchange}")
    String topicExchangeName;
    @Value("${spring.rabbitmq.routingKey}")
    String routingKey;

    @Before("execution(* com.icommerce.product.delivery.impl.rest.ProductRest.find(..))")
    @Async(ConstantUtils.ASYNC_POOL)
    public void logForFind(JoinPoint joinPoint) {
        final String arguments = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        final UserLog userLog = new UserLog(LocalProfile.getUserId(), UserAction.SEARCH, arguments);
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, userLog);
    }

    @Before("execution(* com.icommerce.product.delivery.impl.rest.ProductRest.findById(..))")
    @Async(ConstantUtils.ASYNC_POOL)
    public void logForFindById(JoinPoint joinPoint) {
        final String arguments = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        final UserLog userLog = new UserLog(LocalProfile.getUserId(), UserAction.SEARCH, arguments);
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, userLog);
    }

    @Before("execution(* com.icommerce.product.delivery.impl.rest.ProductRest.update(..))")
    @Async(ConstantUtils.ASYNC_POOL)
    public void logForUpdating(JoinPoint joinPoint) {
        final String arguments = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        final UserLog userLog = new UserLog(LocalProfile.getUserId(), UserAction.SEARCH, arguments);
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, userLog);
    }
}
