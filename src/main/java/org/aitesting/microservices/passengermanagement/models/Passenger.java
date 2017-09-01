package org.aitesting.microservices.passengermanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idpassenger")
	private Integer idpassenger;
	private Integer idcity;
	private String fname;
	private String lname;
	private String username;
	private String email;
	private Double lastLocationLat;
	private Double lastLocationLon;
	private String address;
	private String phone;
	private Integer active; // 1 = active, 0 = inactive
	
	public Passenger() {
		
	}

	public Passenger(Integer idcity, String fname, String lname, String username, String email,
			Double lastLocationLat, Double lastLocationLon, String address, String phone, Integer active) {
		super();
		this.idcity = idcity;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.lastLocationLat = lastLocationLat;
		this.lastLocationLon = lastLocationLon;
		this.address = address;
		this.phone = phone;
		this.active = active;
	}

	public Integer getIdpassenger() {
		return idpassenger;
	}

	public void setIdpassenger(Integer idpassenger) {
		this.idpassenger = idpassenger;
	}

	public Integer getIdcity() {
		return idcity;
	}

	public void setIdcity(Integer idcity) {
		this.idcity = idcity;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getLastLocationLat() {
		return lastLocationLat;
	}

	public void setLastLocationLat(Double lastLocationLat) {
		this.lastLocationLat = lastLocationLat;
	}

	public Double getLastLocationLon() {
		return lastLocationLon;
	}

	public void setLastLocationLon(Double lastLocationLon) {
		this.lastLocationLon = lastLocationLon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	

}
