package org.aitesting.microservices.passengermanagement.controllers;

import org.aitesting.microservices.passengermanagement.PassengerManagementApplication;
import org.aitesting.microservices.passengermanagement.amqp.CustomMessageTrip;
import org.aitesting.microservices.passengermanagement.models.Passenger;
import org.aitesting.microservices.passengermanagement.repositories.PassengerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/passengers")
public class PassengerController {
	
	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
    public PassengerController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
	
    @Autowired
    private PassengerRepository repository;

    @GetMapping("/")
    public @ResponseBody Iterable<Passenger> getPassengers(){
    	// 1="Active", 0="Not Active"
        return  repository.findByActive(1);
    }

    @GetMapping("{id}")
    public @ResponseBody Passenger getPassenger(@PathVariable("id") Integer id){
        return repository.findByIdpassenger(id);
    }

    @PostMapping("add")
    public @ResponseBody Passenger addPassenger(@RequestBody Passenger passenger){
        repository.save(passenger);
        return passenger;
    }

    @PutMapping("update/{id}")
    public @ResponseBody Passenger updatePassenger(@PathVariable("id") Integer id, @RequestBody Passenger updatedPassenger){
        Passenger passenger = repository.findByIdpassenger(id);
        passenger.setFname(updatedPassenger.getFname() != null ? updatedPassenger.getFname() : passenger.getFname());
        passenger.setLname(updatedPassenger.getLname() != null ? updatedPassenger.getLname() : passenger.getLname());
        passenger.setUsername(updatedPassenger.getUsername() != null ? updatedPassenger.getUsername() : passenger.getUsername());
        passenger.setCity(updatedPassenger.getCity() != null ? updatedPassenger.getCity() : passenger.getCity());
        passenger.setEmail(updatedPassenger.getEmail() != null ? updatedPassenger.getEmail() : passenger.getEmail());
        passenger.setPhone(updatedPassenger.getPhone() != null ? updatedPassenger.getPhone() : passenger.getPhone());
        passenger.setAddress(updatedPassenger.getAddress() != null ? updatedPassenger.getAddress() : passenger.getAddress());
        passenger.setActive(updatedPassenger.getActive() != null ? updatedPassenger.getActive() : passenger.getActive());
        passenger.setLastLocationLat(updatedPassenger.getLastLocationLat() != null ? updatedPassenger.getLastLocationLat() : passenger.getLastLocationLat());
        passenger.setLastLocationLon(updatedPassenger.getLastLocationLon() != null ? updatedPassenger.getLastLocationLon() : passenger.getLastLocationLon());
        repository.save(passenger);
        return passenger;
    }
    
    @PutMapping("update/location/{id}")
    public @ResponseBody Passenger updatePassengerLocation(@PathVariable("id") Integer id, @RequestParam Double lat, @RequestParam Double lon){
        Passenger passenger = repository.findByIdpassenger(id);
        passenger.setLastLocationLat(lat != null ? lat : passenger.getLastLocationLat());
        passenger.setLastLocationLon(lon != null ? lon : passenger.getLastLocationLon());
        repository.save(passenger);

        return passenger;
    }

    @GetMapping("delete/{id}")
    public @ResponseBody void deletePassenger(@PathVariable("id") String id){
        repository.delete(id);
    }
    
    /**
     * Retrieve passenger information if there is a match with username.
     * 
     * @param username
     * @param password
     * @return Passenger
     */
    @GetMapping("login")
    public @ResponseBody Passenger getRequestTrip(@RequestParam String username, @RequestParam String password){
    	Passenger passenger = repository.findByUsername(username);
    	//System.out.println("*********************** " + passenger + " ****************************");
    	return passenger;      
    }
    
    @GetMapping("requesttrip")
    public @ResponseBody String getRequestTrip(@RequestParam String idpassenger, @RequestParam Double lat, @RequestParam Double lon, @RequestParam String destinationAddress){
    	CustomMessageTrip customMessage = new CustomMessageTrip();
    	
        // TODO: send message & receive answer from Trip Microservice
    	sendMessageTrip(customMessage);
    	
    	// TODO: send answer to client
    	return "";
    }
    
    public void sendMessageTrip(final CustomMessageTrip customMessage) {
        rabbitTemplate.convertAndSend(PassengerManagementApplication.EXCHANGE_NAME, PassengerManagementApplication.TRIP_ROUTING_KEY, customMessage);
    }
}
