package org.aitesting.microservices.tripmanagement.amqp;
import java.io.Serializable;

public final class CustomMessagePassenger implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpassenger;
    private int idpassengerState;

    // Default constructor is needed to deserialize JSON
    public CustomMessagePassenger() {
    }
    
    public CustomMessagePassenger(int idpassenger, int idpassengerState) {
    	this.idpassenger = idpassenger;
    	this.idpassengerState = idpassengerState;
    }

	public int getIdpassenger() {
		return idpassenger;
	}

	public void setIdpassenger(int idpassenger) {
		this.idpassenger = idpassenger;
	}

	public int getIdpassengerState() {
		return idpassengerState;
	}

	public void setIdpassengerState(int idpassengerState) {
		this.idpassengerState = idpassengerState;
	}

}
