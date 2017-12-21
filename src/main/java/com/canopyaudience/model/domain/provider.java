package com.canopyaudience.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 @author Jason Canney
 Domain provider class 
 The provider class defines the domain object for provider data that will
 be received by the CDE from the mobile app and then stored in a data store
 by the CDE
*/
@Entity
@Table(name = "provider")
public class provider implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;

        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "IDentifier")
	/** 
	 Identifier ID
	*/
	private int identifier;

        @Column(name = "providerID")
	/** 
	 provider ID
	*/
	private int providerID;
        
        @Column(name = "providerName", nullable = false, length = 50)
	/** 
	 Provider Name
	*/
	private String providerName;

   
        /*
        Default constructor
        */
        public provider() {
        }

        /*
        Overloaded Constructor
        */

    public provider(int providerID, String providerName) {
        this.providerID = providerID;
        this.providerName = providerName;
    }
        
        

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.identifier;
        hash = 97 * hash + this.providerID;
        hash = 97 * hash + Objects.hashCode(this.providerName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final provider other = (provider) obj;
        if (this.identifier != other.identifier) {
            return false;
        }
        if (this.providerID != other.providerID) {
            return false;
        }
        if (!Objects.equals(this.providerName, other.providerName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "provider{" + "identifier=" + identifier + ", providerID=" + providerID + ", providerName=" + providerName + '}';
    }
        
        
}