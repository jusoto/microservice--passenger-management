package org.aitesting.microservices.passengermanagement.amqp;

import org.aitesting.microservices.passengermanagement.PassengerManagementApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    //@Scheduled(fixedDelay = 5000L)
    public void sendMessageTrip(final CustomMessageTrip customMessage) {
        log.info("Sending Trip message...");
        rabbitTemplate.convertAndSend(PassengerManagementApplication.EXCHANGE_NAME, PassengerManagementApplication.TRIP_ROUTING_KEY, customMessage);
    }

}
