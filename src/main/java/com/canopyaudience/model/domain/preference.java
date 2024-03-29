package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 @author Jason Canney
 Domain preference class 
 The preference class defines the domain object for consumer  preference data that will
 be received by the CDE from the mobile app and then stored in a data store
 by the CDE
 
 
*/
@JsonAutoDetect
@Entity
@Table(name = "preference")
public class preference implements Serializable
{

	/**  @param serialVersionUID
	 The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
	 number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
	 then an InvalidClassException is thrown
	*/

	private static final long serialVersionUID = 4349382150030819494L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "preferenceID")
	/** 
	 Preference ID
	 Unique identifier generated by the mobile app to identify the preference
	 Not unique within the system and can be reused by the client
	 The client will send any number of preferences and will sequence those 
	 preferences with some unique numbering scheme
	*/
	private int preferenceId;

        @Column(name = "preferenceChoice")
	/** 
	 Preference Choice
	*/
	private int preferenceChoice;
        
        /** 
	 @param - preferenceDate is the date the preference was stored by the mobile app
	*/
	// private String preferenceDate;
        // @Column(name = "preferenceDate", nullable = false, length = 50)
        // @JsonDeserialize(using=DateAndTimeDeserialize.class)
        // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        // NOTE: JSON external deserializer class configured on the setter class.
        // @Temporal(TemporalType.DATE)
        @Column(name = "preferenceDate")
        private long preferenceDate;
        
        @Column(name = "advertisementID")
	/** 
	 Advertisement ID
	*/
	private int advertisementID;

        @Column(name = "couponID")
	/** 
	 Coupon ID
	*/
	private int couponID;

        @Column(name = "consumerID")
	/** 
	 @param - consumerID is a value sent from the mobile app with preferences
	 that link the preference back to a particular consumer.
	 Once stored in a data store, these values will link to the consumerID sent in the
	 consumer object
	*/
	private int consumerId;


	/** 
	  Default Constructor
	  @param preference object
	*/
	public preference()
	{

	}

        /** 
	  Overloaded Constructor
             * @param preferenceId
             * @param preferenceChoice
             * @param preferenceDate
             * @param advertisementID
             * @param couponID
             * @param consumerId
	*/
        public preference(int preferenceId, int preferenceChoice, long preferenceDate, int advertisementID, int couponID, int consumerId) {
            this.preferenceId = preferenceId;
            this.preferenceChoice = preferenceChoice;
            this.preferenceDate = preferenceDate;
            this.advertisementID = advertisementID;
            this.couponID = couponID;
            this.consumerId = consumerId;
        }

        
        /*
        Constructor without the preferenceID for testing and front end usage
        */
    public preference(int preferenceChoice, long preferenceDate, int advertisementID, int couponID, int consumerId) {
        this.preferenceChoice = preferenceChoice;
        this.preferenceDate = preferenceDate;
        this.advertisementID = advertisementID;
        this.couponID = couponID;
        this.consumerId = consumerId;
    }

        
    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getPreferenceChoice() {
        return preferenceChoice;
    }

    public void setPreferenceChoice(int preferenceChoice) {
        this.preferenceChoice = preferenceChoice;
    }

    public long getPreferenceDate() {
        return preferenceDate;
    }

    // @JsonDeserialize(using=DateAndTimeDeserialize.class)
    public void setPreferenceDate(long preferenceDate) {
        this.preferenceDate = preferenceDate;
    }

    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public String toString() {
        return "preference{" + "preferenceId=" + preferenceId + ", preferenceChoice=" + preferenceChoice + ", preferenceDate=" + preferenceDate + ", advertisementID=" + advertisementID + ", couponID=" + couponID + ", consumerId=" + consumerId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.preferenceId;
        hash = 11 * hash + this.preferenceChoice;
        hash = 11 * hash + (int) (this.preferenceDate ^ (this.preferenceDate >>> 32));
        hash = 11 * hash + this.advertisementID;
        hash = 11 * hash + this.couponID;
        hash = 11 * hash + this.consumerId;
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
        final preference other = (preference) obj;
        if (this.preferenceId != other.preferenceId) {
            return false;
        }
        if (this.preferenceChoice != other.preferenceChoice) {
            return false;
        }
        if (this.preferenceDate != other.preferenceDate) {
            return false;
        }
        if (this.advertisementID != other.advertisementID) {
            return false;
        }
        if (this.couponID != other.couponID) {
            return false;
        }
        if (this.consumerId != other.consumerId) {
            return false;
        }
        return true;
    }

    
    
}

       