package org.aitesting.microservices.passengermanagement.repositories;

import org.aitesting.microservices.passengermanagement.models.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, String> {
	
    Passenger findByIdpassenger(Integer id);
    
    public Iterable<Passenger> findByActive(Integer active);
    
}
