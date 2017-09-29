package org.aitesting.microservices.passengermanagement.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="passenger_state")
public class PassengerState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idpassenger_state")
	private Integer idpassengerState; // 1:Available 2:Busy 3:Suspended
	private String name;
	private String description;

    @OneToMany(mappedBy = "passengerState")
    private Set<HasPassengerState> hasPassengerStates;
	
	public PassengerState() {
		
	}

	public Integer getIdpassengerState() {
		return idpassengerState;
	}

	public void setIdpassengerState(Integer idpassengerState) {
		this.idpassengerState = idpassengerState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
    public Set<HasPassengerState> getHasPassengerStates() {
		return hasPassengerStates;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idpassengerState != null ? idpassengerState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassengerState)) {
            return false;
        }
        PassengerState other = (PassengerState) object;
        if ((this.idpassengerState == null && other.idpassengerState != null) || (this.idpassengerState != null && !this.idpassengerState.equals(other.idpassengerState))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return name;
	}

}
