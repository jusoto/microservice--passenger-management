package org.aitesting.microservices.passengermanagement.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="state")
public class State {
	
	@Id
    @Column(name="idstate")
	private Integer idstate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcountry", referencedColumnName = "idcountry")
	private Country country;
	private String name;
	private String abbreviation;

    @OneToMany(mappedBy = "state", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<City> cities;
	
	public State() {
		
	}

	public Integer getIdstate() {
		return idstate;
	}

	public void setIdstate(Integer idstate) {
		this.idstate = idstate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<City> getCities() {
		return cities;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return name;
	}

}
