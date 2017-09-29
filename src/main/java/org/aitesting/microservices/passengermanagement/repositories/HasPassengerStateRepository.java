package org.aitesting.microservices.passengermanagement.repositories;

import org.aitesting.microservices.passengermanagement.models.HasPassengerState;
import org.springframework.data.repository.CrudRepository;

public interface HasPassengerStateRepository extends CrudRepository<HasPassengerState, String> {
	
    HasPassengerState findByIdhasPassengerState(Integer id);
    
    HasPassengerState findLastByPassenger(Integer id);
    
}
