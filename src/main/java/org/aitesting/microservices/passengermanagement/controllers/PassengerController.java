package org.aitesting.microservices.passengermanagement.controllers;

import org.aitesting.microservices.passengermanagement.models.Passenger;
import org.aitesting.microservices.passengermanagement.repositories.PassengerRepository;
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
@RequestMapping("api")
public class PassengerController {
	
    @Autowired
    private PassengerRepository repository;

    @GetMapping("passengers")
    public @ResponseBody Iterable<Passenger> getPassengers(){
    	// 1="Active", 0="Not Active"
        return  repository.findByActive(1);
    }

    @GetMapping("passengers/{id}")
    public @ResponseBody Passenger getPassenger(@PathVariable("id") Integer id){
        return repository.findByIdpassenger(id);
    }

    @PostMapping("passengers/add")
    public @ResponseBody Passenger addPassenger(@RequestBody Passenger passenger){
        repository.save(passenger);
        return passenger;
    }

    @PutMapping("passengers/update/{id}")
    public @ResponseBody Passenger updatePassenger(@PathVariable("id") Integer id, @RequestBody Passenger updatedPassenger){
        Passenger passenger = repository.findByIdpassenger(id);
        passenger.setFname(updatedPassenger.getFname() != null ? updatedPassenger.getFname() : passenger.getFname());
        passenger.setLname(updatedPassenger.getLname() != null ? updatedPassenger.getLname()  : passenger.getLname());
        passenger.setUsername(updatedPassenger.getUsername() != null ? updatedPassenger.getUsername() : passenger.getUsername());
        passenger.setCity(updatedPassenger.getCity() != null ? updatedPassenger.getCity() : passenger.getCity());
        passenger.setEmail(updatedPassenger.getEmail() != null ? updatedPassenger.getEmail() : passenger.getEmail());
        passenger.setPhone(updatedPassenger.getPhone() != null ? updatedPassenger.getPhone() : passenger.getPhone());
        passenger.setAddress(updatedPassenger.getAddress() != null ? updatedPassenger.getAddress() : passenger.getAddress());
        passenger.setActive(updatedPassenger.getActive() != null ? updatedPassenger.getActive() : passenger.getActive());
        passenger.setLastLocationLat(updatedPassenger.getLastLocationLat() != null ? updatedPassenger.getLastLocationLat() : updatedPassenger.getLastLocationLat());
        passenger.setLastLocationLon(updatedPassenger.getLastLocationLon() != null ? updatedPassenger.getLastLocationLon() : updatedPassenger.getLastLocationLon());
        repository.save(passenger);
        return passenger;
    }
    
    @PutMapping("passengers/update/location/{id}")
    public @ResponseBody Passenger updatePassengerLocation(@PathVariable("id") Integer id, @RequestParam Double lat, @RequestParam Double lon){
        Passenger passenger = repository.findByIdpassenger(id);
        passenger.setLastLocationLat(lat != null ? lat : passenger.getLastLocationLat());
        passenger.setLastLocationLon(lon != null ? lon : passenger.getLastLocationLon());
        repository.save(passenger);

        return passenger;
    }

    @GetMapping("passengers/delete/{id}")
    public @ResponseBody void deletePassenger(@PathVariable("id") String id){
        repository.delete(id);
    }
}
