package org.aitesting.microservices.passengermanagement.amqp;

import org.aitesting.microservices.passengermanagement.PassengerManagementApplication;
import org.aitesting.microservices.passengermanagement.models.HasPassengerState;
import org.aitesting.microservices.passengermanagement.repositories.HasPassengerStateRepository;
import org.aitesting.microservices.passengermanagement.repositories.PassengerRepository;
import org.aitesting.microservices.passengermanagement.repositories.PassengerStateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);
    
    @Autowired
    private HasPassengerStateRepository hasPassengerStateRepository;
    
    @Autowired
    private PassengerStateRepository passengerStateRepository;
    
    @Autowired
    private PassengerRepository passengerRepository;

//    @RabbitListener(queues = PassengerManagementApplication.QUEUE_GENERIC_NAME)
//    public void receiveMessage(final Message message) {
//        log.info("Received message as generic: {}", message.toString());
//    }

    @RabbitListener(queues = PassengerManagementApplication.PASSENGER_MANAGEMENT_QUEUE)
    public void receiveMessage(final CustomMessage customMessage) {
    	HasPassengerState obj = new HasPassengerState();
    	obj.setPassenger(passengerRepository.findByIdpassenger(customMessage.getIdpassenger()));
    	obj.setPassengerState(passengerStateRepository.findByIdpassengerState(customMessage.getIdpassengerState()));
    	hasPassengerStateRepository.save(obj);
        log.info("Received Passenger message as specific class: {}", customMessage.toString());
    }
}
