package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Objects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
/** 
 @author Jason Canney  
 Domain AdImpression class 
 The AdImpression class defines the domain object for AdImpression data that will
 be received by the CDE from advertisers and then stored in a data store
 by the CDE
*/
@JsonAutoDetect

@Entity
@Table(name = "adimpression")
public class adimpression implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;

        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "ConsumerID")
	/** 
	 AdImpression Consumer ID
	*/
	private int consumerID;

        @Column(name = "SessionID")
	/** 
	 AdImpression session id
	*/
	private int sessionID;
        
        @Column(name = "ServiceID")
        /** 
	 AdImpression service id
	*/
	private int serviceID;
        
        @Column(name = "ContentID")
	/** 
	 AdImpression content id
	*/
	private int contentID;
        
        @Column(name = "TerminalID", nullable = false, length = 50)
        /** 
	 AdImpression terminalID
	*/
	private String terminalID;
        
        @Column(name = "OppType")
        /** 
	 AdImpression oppType
	*/
	private int oppType;
        
        @Column(name = "OppNum")
        /** 
	 AdImpression oppNum
	*/
	private int oppNum;
        
        @Column(name = "OppDuration")
        /** 
	 AdImpression oppDuration
	*/
	private int oppDuration;
        
        @Column(name = "AdPCC", nullable = false, length = 50)
        /** 
	 AdImpression pccCode
	*/
	private String adPCC;
        
        @Column(name = "AdCampID", nullable = false, length = 50)
        /** 
	 AdImpression adCampID
	*/
	private String adCampID;
        
        @Column(name = "AssetID")
        /** 
	 AdImpression assetID
	*/
	private int assetID;
        
        @Column(name = "AssetProviderID")
        /** 
	 AdImpression assetProviderID
	*/
	private int assetProviderID;
        
        @Column(name = "ViewStartTime", nullable = false, length = 50)
        /** 
	 AdImpression viewStartTime
	*/
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date viewStartTime;
        
        @Column(name = "ViewEndTime", nullable = false, length = 50)
        /** 
	 AdImpression viewEndTime
	*/
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date viewEndTime;
        
        @Column(name = "LocationID")
        /** 
	 AdImpression locationID
	*/
	private int locationID;
        
        @Column(name = "LocationZip", nullable = false, length = 50)
        /** 
	 AdImpression locationZip
	*/
	private String locationZip;

	/** 
	  Default Constructor
	*/
	public adimpression()
	{

	}

    public adimpression(int consumerID, int sessionID, int serviceID, int contentID, String terminalID, int oppType, int oppNum, int oppDuration, String adPCC, String adCampID, int assetID, int assetProviderID, Date viewStartTime, Date viewEndTime, int locationID, String locationZip) {
        this.consumerID = consumerID;
        this.sessionID = sessionID;
        this.serviceID = serviceID;
        this.contentID = contentID;
        this.terminalID = terminalID;
        this.oppType = oppType;
        this.oppNum = oppNum;
        this.oppDuration = oppDuration;
        this.adPCC = adPCC;
        this.adCampID = adCampID;
        this.assetID = assetID;
        this.assetProviderID = assetProviderID;
        this.viewStartTime = viewStartTime;
        this.viewEndTime = viewEndTime;
        this.locationID = locationID;
        this.locationZip = locationZip;
    }

    public int getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public int getOppType() {
        return oppType;
    }

    public void setOppType(int oppType) {
        this.oppType = oppType;
    }

    public int getOppNum() {
        return oppNum;
    }

    public void setOppNum(int oppNum) {
        this.oppNum = oppNum;
    }

    public int getOppDuration() {
        return oppDuration;
    }

    public void setOppDuration(int oppDuration) {
        this.oppDuration = oppDuration;
    }

    public String getAdPCC() {
        return adPCC;
    }

    public void setAdPCC(String adPCC) {
        this.adPCC = adPCC;
    }

    public String getAdCampID() {
        return adCampID;
    }

    public void setAdCampID(String adCampID) {
        this.adCampID = adCampID;
    }

    public int getAssetID() {
        return assetID;
    }

    public void setAssetID(int assetID) {
        this.assetID = assetID;
    }

    public int getAssetProviderID() {
        return assetProviderID;
    }

    public void setAssetProviderID(int assetProviderID) {
        this.assetProviderID = assetProviderID;
    }

    public Date getViewStartTime() {
        return viewStartTime;
    }

    public void setViewStartTime(Date viewStartTime) {
        this.viewStartTime = viewStartTime;
    }

    public Date getViewEndTime() {
        return viewEndTime;
    }

    public void setViewEndTime(Date viewEndTime) {
        this.viewEndTime = viewEndTime;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationZip() {
        return locationZip;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.consumerID;
        hash = 29 * hash + this.sessionID;
        hash = 29 * hash + this.serviceID;
        hash = 29 * hash + this.contentID;
        hash = 29 * hash + Objects.hashCode(this.terminalID);
        hash = 29 * hash + this.oppType;
        hash = 29 * hash + this.oppNum;
        hash = 29 * hash + this.oppDuration;
        hash = 29 * hash + Objects.hashCode(this.adPCC);
        hash = 29 * hash + Objects.hashCode(this.adCampID);
        hash = 29 * hash + this.assetID;
        hash = 29 * hash + this.assetProviderID;
        hash = 29 * hash + Objects.hashCode(this.viewStartTime);
        hash = 29 * hash + Objects.hashCode(this.viewEndTime);
        hash = 29 * hash + this.locationID;
        hash = 29 * hash + Objects.hashCode(this.locationZip);
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
        final adimpression other = (adimpression) obj;
        if (this.consumerID != other.consumerID) {
            return false;
        }
        if (this.sessionID != other.sessionID) {
            return false;
        }
        if (this.serviceID != other.serviceID) {
            return false;
        }
        if (this.contentID != other.contentID) {
            return false;
        }
        if (this.oppType != other.oppType) {
            return false;
        }
        if (this.oppNum != other.oppNum) {
            return false;
        }
        if (this.oppDuration != other.oppDuration) {
            return false;
        }
        if (this.assetID != other.assetID) {
            return false;
        }
        if (this.assetProviderID != other.assetProviderID) {
            return false;
        }
        if (this.locationID != other.locationID) {
            return false;
        }
        if (!Objects.equals(this.terminalID, other.terminalID)) {
            return false;
        }
        if (!Objects.equals(this.adPCC, other.adPCC)) {
            return false;
        }
        if (!Objects.equals(this.adCampID, other.adCampID)) {
            return false;
        }
        if (!Objects.equals(this.locationZip, other.locationZip)) {
            return false;
        }
        if (!Objects.equals(this.viewStartTime, other.viewStartTime)) {
            return false;
        }
        if (!Objects.equals(this.viewEndTime, other.viewEndTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adimpression{" + "consumerID=" + consumerID + ", sessionID=" + sessionID + ", serviceID=" + serviceID + ", contentID=" + contentID + ", terminalID=" + terminalID + ", oppType=" + oppType + ", oppNum=" + oppNum + ", oppDuration=" + oppDuration + ", adPCC=" + adPCC + ", adCampID=" + adCampID + ", assetID=" + assetID + ", assetProviderID=" + assetProviderID + ", viewStartTime=" + viewStartTime + ", viewEndTime=" + viewEndTime + ", locationID=" + locationID + ", locationZip=" + locationZip + '}';
    }

    

    
}

        


        
        
        
        
        
	