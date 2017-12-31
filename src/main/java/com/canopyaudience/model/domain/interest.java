package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Objects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 @author Jason Canney
 Domain interest class 
 The preference class defines the domain object for consumer  interest data that will
 be customers of Canopy Audience
*/
@JsonAutoDetect

@Entity
@Table(name = "interest")
public class interest implements Serializable
{

	/**  @param serialVersionUID
	 The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
	 number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
	 then an InvalidClassException is thrown
	*/

	private static final long serialVersionUID = 4349382150030819494L;
        
        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "IntID")
	/** 
        Identifier used as PK within the database
        */
	private int intID;

        @Column(name = "IntDate")
	/** 
	 @param - recoDate is the date the preference was stored by the mobile app
	*/
        // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        // @JsonDeserialize(using=DateAndTimeDeserialize.class)
        // @Temporal(javax.persistence.TemporalType.DATE)
        private long intDate;
         
        @Column(name = "IntWeight")
	/** 
	 RecoWeight
	*/
	private int intWeight;
        
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
	  @param interest object
	*/
	public interest()
	{

	}

    public interest(long intDate, int intWeight, int consumerId, int providerId, String providerName, String locationZip, int demographic, int adID, String adURL, String adPCC, String adOwner) {
        this.intDate = intDate;
        this.intWeight = intWeight;
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

      
    public interest(int intID, long intDate, int intWeight, int consumerId, int providerId, String providerName, String locationZip, int demographic, int adID, String adURL, String adPCC, String adOwner) {
        this.intID = intID;
        this.intDate = intDate;
        this.intWeight = intWeight;
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

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public long getIntDate() {
        return intDate;
    }

    public void setIntDate(long intDate) {
        this.intDate = intDate;
    }

    public int getIntWeight() {
        return intWeight;
    }

    public void setIntWeight(int intWeight) {
        this.intWeight = intWeight;
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
        int hash = 7;
        hash = 97 * hash + this.intID;
        hash = 97 * hash + (int) (this.intDate ^ (this.intDate >>> 32));
        hash = 97 * hash + this.intWeight;
        hash = 97 * hash + this.consumerId;
        hash = 97 * hash + this.providerId;
        hash = 97 * hash + Objects.hashCode(this.providerName);
        hash = 97 * hash + Objects.hashCode(this.locationZip);
        hash = 97 * hash + this.demographic;
        hash = 97 * hash + this.adID;
        hash = 97 * hash + Objects.hashCode(this.adURL);
        hash = 97 * hash + Objects.hashCode(this.adPCC);
        hash = 97 * hash + Objects.hashCode(this.adOwner);
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
        final interest other = (interest) obj;
        if (this.intID != other.intID) {
            return false;
        }
        if (this.intDate != other.intDate) {
            return false;
        }
        if (this.intWeight != other.intWeight) {
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
        return true;
    }

   

    @Override
    public String toString() {
        return "interest{" + "intID=" + intID + ", intDate=" + intDate + ", intWeight=" + intWeight + ", consumerId=" + consumerId + ", providerId=" + providerId + ", providerName=" + providerName + ", locationZip=" + locationZip + ", demographic=" + demographic + ", adID=" + adID + ", adURL=" + adURL + ", adPCC=" + adPCC + ", adOwner=" + adOwner + '}';
    }

    
        
    }

        
        