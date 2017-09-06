package org.aitesting.microservices.passengermanagement.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcity")
	private Integer idcity;
    @ManyToOne
    @JoinColumn(name = "idstate")
	private State state;
	private String name;

    @OneToMany
    private Set<Passenger> passengers;
	
	public City() {
		
	}

	public Integer getIdcity() {
		return idcity;
	}

	public void setIdcity(Integer idcity) {
		this.idcity = idcity;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
