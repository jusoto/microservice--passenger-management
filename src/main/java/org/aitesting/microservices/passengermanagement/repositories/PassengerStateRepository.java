package org.aitesting.microservices.passengermanagement.repositories;

import org.aitesting.microservices.passengermanagement.models.PassengerState;
import org.springframework.data.repository.CrudRepository;

public interface PassengerStateRepository  extends CrudRepository<PassengerState, String> {
	
    PassengerState findByIdpassengerState(Integer id);

}
