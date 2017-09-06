package org.aitesting.microservices.passengermanagement.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idcountry")
	private Integer idcountry;
	private String name;

    @OneToMany
    private Set<State> states;
	
	public Country() {
		
	}

	public Integer getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(Integer idcountry) {
		this.idcountry = idcountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
