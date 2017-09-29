package org.aitesting.microservices.passengermanagement.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="has_passenger_state")
public class HasPassengerState {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idhas_passenger_state")
	private Integer idhasPassengerState;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpassenger", referencedColumnName = "idpassenger")
	private Passenger passenger;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpassenger_state", referencedColumnName = "idpassenger_state")
	private PassengerState passengerState;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	public HasPassengerState() {
		
	}

	public Integer getIdhasPassengerState() {
		return idhasPassengerState;
	}


	public void setIdhasPassengerState(Integer idhasPassengerState) {
		this.idhasPassengerState = idhasPassengerState;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public PassengerState getPassengerState() {
		return passengerState;
	}


	public void setPassengerState(PassengerState passengerState) {
		this.passengerState = passengerState;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhasPassengerState != null ? idhasPassengerState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasPassengerState)) {
            return false;
        }
        HasPassengerState other = (HasPassengerState) object;
        if ((this.idhasPassengerState == null && other.idhasPassengerState != null) || (this.idhasPassengerState != null && !this.idhasPassengerState.equals(other.idhasPassengerState))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return passenger.toString() + " - " + passengerState.toString() + " - " + creationDate.toString();
	}

}
