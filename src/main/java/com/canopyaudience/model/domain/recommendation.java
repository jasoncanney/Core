package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
/** 
 @author Jason Canney
 Domain recommendation class 
 The preference class defines the domain object for consumer  recommendation data that will
 be customers of Canopy Audience
*/
@JsonAutoDetect

@Entity
@Table(name = "recommendation")
public class recommendation implements Serializable
{

	/**  @param serialVersionUID
	 The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
	 number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
	 then an InvalidClassException is thrown
	*/

	private static final long serialVersionUID = 4349382150030819494L;
        
        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "RecoID")
	/** 
        Identifier used as PK within the database
        */
	private int recoID;

        @Column(name = "RecoDate", nullable = false, length = 50)
	/** 
	 @param - recoDate is the date the preference was stored by the mobile app
	*/
        // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonDeserialize(using=DateAndTimeDeserialize.class)
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date recoDate;
         
        @Column(name = "RecoWeight")
	/** 
	 RecoWeight
	*/
	private int recoWeight;
        
        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "ConsumerID")
	/** 
	 Consumer ID
	*/
	private int consumerId;

        @Column(name = "ProviderID")
	/** 
	 Provider ID
	*/
	private int providerId;
        
        @Column(name = "ProviderName")
	/** 
	 Provider ID
	*/
	private String providerName;
        
        @Column(name = "LocationZip")
	/** 
	 Provider ID
	*/
	private String locationZip;
         
        @Column(name = "Demographic")
	/** 
	 Advertisement ID
	*/
	private int demographic;
        
        @Column(name = "AdID")
	/** 
	 AdID
	*/
	private int adID;

        @Column(name = "AdURL")
	/** 
	 advertisement URL location for image
	*/
	private String adURL;
        
        @Column(name = "AdPCC")
	/** 
	 advertisement PCC code
	*/
	private String adPCC;

        @Column(name = "AdOwner")
	/** 
	 advertisement owner
	*/
	private String adOwner;

	/** 
	  Default Constructor
	  @param recommendation object
	*/
	public recommendation()
	{

	}

    public recommendation(int recoID, Date recoDate, int recoWeight, int consumerId, int providerId, String providerName, String locationZip, int demographic, int adID, String adURL, String adPCC, String adOwner) {
        this.recoID = recoID;
        this.recoDate = recoDate;
        this.recoWeight = recoWeight;
        this.consumerId = consumerId;
        this.providerId = providerId;
        this.providerName = providerName;
        this.locationZip = locationZip;
        this.demographic = demographic;
        this.adID = adID;
        this.adURL = adURL;
        this.adPCC = adPCC;
        this.adOwner = adOwner;
    }

    // Constructor without the PK unique identifier that is set by the DB
    public recommendation(Date recoDate, int recoWeight, int consumerId, int providerId, String providerName, String locationZip, int demographic, int adID, String adURL, String adPCC, String adOwner) {
        this.recoDate = recoDate;
        this.recoWeight = recoWeight;
        this.consumerId = consumerId;
        this.providerId = providerId;
        this.providerName = providerName;
        this.locationZip = locationZip;
        this.demographic = demographic;
        this.adID = adID;
        this.adURL = adURL;
        this.adPCC = adPCC;
        this.adOwner = adOwner;
    }


    public int getRecoID() {
        return recoID;
    }

    public void setRecoID(int recoID) {
        this.recoID = recoID;
    }

    public Date getRecoDate() {
        return recoDate;
    }

    public void setRecoDate(Date recoDate) {
        this.recoDate = recoDate;
    }

    public int getRecoWeight() {
        return recoWeight;
    }

    public void setRecoWeight(int recoWeight) {
        this.recoWeight = recoWeight;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getLocationZip() {
        return locationZip;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    public int getDemographic() {
        return demographic;
    }

    public void setDemographic(int demographic) {
        this.demographic = demographic;
    }

    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public String getAdURL() {
        return adURL;
    }

    public void setAdURL(String adURL) {
        this.adURL = adURL;
    }

    public String getAdPCC() {
        return adPCC;
    }

    public void setAdPCC(String adPCC) {
        this.adPCC = adPCC;
    }

    public String getAdOwner() {
        return adOwner;
    }

    public void setAdOwner(String adOwner) {
        this.adOwner = adOwner;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.recoID;
        hash = 83 * hash + Objects.hashCode(this.recoDate);
        hash = 83 * hash + this.recoWeight;
        hash = 83 * hash + this.consumerId;
        hash = 83 * hash + this.providerId;
        hash = 83 * hash + Objects.hashCode(this.providerName);
        hash = 83 * hash + Objects.hashCode(this.locationZip);
        hash = 83 * hash + this.demographic;
        hash = 83 * hash + this.adID;
        hash = 83 * hash + Objects.hashCode(this.adURL);
        hash = 83 * hash + Objects.hashCode(this.adPCC);
        hash = 83 * hash + Objects.hashCode(this.adOwner);
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
        final recommendation other = (recommendation) obj;
        if (this.recoID != other.recoID) {
            return false;
        }
        if (this.recoWeight != other.recoWeight) {
            return false;
        }
        if (this.consumerId != other.consumerId) {
            return false;
        }
        if (this.providerId != other.providerId) {
            return false;
        }
        if (this.demographic != other.demographic) {
            return false;
        }
        if (this.adID != other.adID) {
            return false;
        }
        if (!Objects.equals(this.providerName, other.providerName)) {
            return false;
        }
        if (!Objects.equals(this.locationZip, other.locationZip)) {
            return false;
        }
        if (!Objects.equals(this.adURL, other.adURL)) {
            return false;
        }
        if (!Objects.equals(this.adPCC, other.adPCC)) {
            return false;
        }
        if (!Objects.equals(this.adOwner, other.adOwner)) {
            return false;
        }
        if (!Objects.equals(this.recoDate, other.recoDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recommendation{" + "recoID=" + recoID + ", recoDate=" + recoDate + ", recoWeight=" + recoWeight + ", consumerId=" + consumerId + ", providerId=" + providerId + ", providerName=" + providerName + ", locationZip=" + locationZip + ", demographic=" + demographic + ", adID=" + adID + ", adURL=" + adURL + ", adPCC=" + adPCC + ", adOwner=" + adOwner + '}';
    }
        
    }

        
        