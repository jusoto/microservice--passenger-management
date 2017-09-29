package org.aitesting.microservices.passengermanagement.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="country")
public class Country {
	
	@Id
    @Column(name="idcountry")
	private Integer idcountry;
	private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	@JsonIgnore
    public Set<State> getStates() {
		return states;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idcountry != null ? idcountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.idcountry == null && other.idcountry != null) || (this.idcountry != null && !this.idcountry.equals(other.idcountry))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return name;
	}

}
