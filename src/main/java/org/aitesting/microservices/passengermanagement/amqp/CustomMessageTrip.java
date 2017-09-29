package org.aitesting.microservices.passengermanagement.amqp;
import java.io.Serializable;

public final class CustomMessageTrip implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpassenger;
    private String originAddress;
    private String destinationAddress;
    private double locationLat;
    private double locationLon;

    // Default constructor is needed to deserialize JSON
    public CustomMessageTrip() {
    }

	public int getIdpassenger() {
		return idpassenger;
	}

	public void setIdpassenger(int idpassenger) {
		this.idpassenger = idpassenger;
	}
	
	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public double getLocationLat() {
		return locationLat;
	}

	public void setLocationLat(double locationLat) {
		this.locationLat = locationLat;
	}

	public double getLocationLon() {
		return locationLon;
	}

	public void setLocationLon(double locationLon) {
		this.locationLon = locationLon;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID Passenger: "+ idpassenger +" - Address: "+originAddress;
	}
}
