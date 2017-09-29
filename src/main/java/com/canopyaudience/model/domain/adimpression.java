package com.canopyaudience.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/** 
 @author Jason Canney  
 Domain AdImpression class 
 The AdImpression class defines the domain object for AdImpression data that will
 be received by the CDE from advertisers and then stored in a data store
 by the CDE
*/

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

        @Column(name = "SessionID", nullable = false, length = 50)
	/** 
	 AdImpression session id
	*/
	private String sessionID;
        
        @Column(name = "ServiceID", nullable = false, length = 50)
        /** 
	 AdImpression service id
	*/
	private String serviceID;
        
        @Column(name = "ContentID", nullable = false, length = 50)
	/** 
	 AdImpression content id
	*/
	private String contentID;
        
        @Column(name = "Duration", nullable = false, length = 50)
        /** 
	 AdImpression duration
	*/
	private String duration;
        
        @Column(name = "CurrentDateTime", nullable = false, length = 50)
        /** 
	 AdImpression currentDateTime
	*/
	private String currentDateTime;
        
        @Column(name = "TerminalID", nullable = false, length = 50)
        /** 
	 AdImpression terminalID
	*/
	private String terminalID;
        
        @Column(name = "OppType", nullable = false, length = 50)
        /** 
	 AdImpression oppType
	*/
	private String oppType;
        
        @Column(name = "OppNum", nullable = false, length = 50)
        /** 
	 AdImpression oppNum
	*/
	private String oppNum;
        
        @Column(name = "OppDuration", nullable = false, length = 50)
        /** 
	 AdImpression oppDuration
	*/
	private String oppDuration;
        
        @Column(name = "PCCCode", nullable = false, length = 50)
        /** 
	 AdImpression pccCode
	*/
	private String pccCode;
        
        @Column(name = "AdCampID", nullable = false, length = 50)
        /** 
	 AdImpression adCampID
	*/
	private String adCampID;
        
        @Column(name = "AssetID", nullable = false, length = 50)
        /** 
	 AdImpression assetID
	*/
	private String assetID;
        
        @Column(name = "AssetProviderID", nullable = false, length = 50)
        /** 
	 AdImpression assetProviderID
	*/
	private String assetProviderID;
        
        @Column(name = "ViewStartTime", nullable = false, length = 50)
        /** 
	 AdImpression viewStartTime
	*/
	private String viewStartTime;
        
        @Column(name = "ViewEndTime", nullable = false, length = 50)
        /** 
	 AdImpression viewEndTime
	*/
	private String viewEndTime;
        
        @Column(name = "LocationID", nullable = false, length = 50)
        /** 
	 AdImpression locationID
	*/
	private String locationID;
        
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

    public adimpression(int consumerID, String sessionID, String serviceID, String contentID, String duration, String currentDateTime, String terminalID, String oppType, String oppNum, String oppDuration, String pccCode, String adCampID, String assetID, String assetProviderID, String viewStartTime, String viewEndTime, String locationID, String locationZip) {
        this.consumerID = consumerID;
        this.sessionID = sessionID;
        this.serviceID = serviceID;
        this.contentID = contentID;
        this.duration = duration;
        this.currentDateTime = currentDateTime;
        this.terminalID = terminalID;
        this.oppType = oppType;
        this.oppNum = oppNum;
        this.oppDuration = oppDuration;
        this.pccCode = pccCode;
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

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    
    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getOppType() {
        return oppType;
    }

    public void setOppType(String oppType) {
        this.oppType = oppType;
    }

    public String getOppNum() {
        return oppNum;
    }

    public void setOppNum(String oppNum) {
        this.oppNum = oppNum;
    }

    public String getOppDuration() {
        return oppDuration;
    }

    public void setOppDuration(String oppDuration) {
        this.oppDuration = oppDuration;
    }

    public String getPccCode() {
        return pccCode;
    }

    public void setPccCode(String pccCode) {
        this.pccCode = pccCode;
    }

    public String getAdCampID() {
        return adCampID;
    }

    public void setAdCampID(String adCampID) {
        this.adCampID = adCampID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getAssetProviderID() {
        return assetProviderID;
    }

    public void setAssetProviderID(String assetProviderID) {
        this.assetProviderID = assetProviderID;
    }

    public String getViewStartTime() {
        return viewStartTime;
    }

    public void setViewStartTime(String viewStartTime) {
        this.viewStartTime = viewStartTime;
    }

    public String getViewEndTime() {
        return viewEndTime;
    }

    public void setViewEndTime(String viewEndTime) {
        this.viewEndTime = viewEndTime;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
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
        hash = 47 * hash + this.consumerID;
        hash = 47 * hash + Objects.hashCode(this.sessionID);
        hash = 47 * hash + Objects.hashCode(this.serviceID);
        hash = 47 * hash + Objects.hashCode(this.contentID);
        hash = 47 * hash + Objects.hashCode(this.duration);
        hash = 47 * hash + Objects.hashCode(this.currentDateTime);
        hash = 47 * hash + Objects.hashCode(this.terminalID);
        hash = 47 * hash + Objects.hashCode(this.oppType);
        hash = 47 * hash + Objects.hashCode(this.oppNum);
        hash = 47 * hash + Objects.hashCode(this.oppDuration);
        hash = 47 * hash + Objects.hashCode(this.pccCode);
        hash = 47 * hash + Objects.hashCode(this.adCampID);
        hash = 47 * hash + Objects.hashCode(this.assetID);
        hash = 47 * hash + Objects.hashCode(this.assetProviderID);
        hash = 47 * hash + Objects.hashCode(this.viewStartTime);
        hash = 47 * hash + Objects.hashCode(this.viewEndTime);
        hash = 47 * hash + Objects.hashCode(this.locationID);
        hash = 47 * hash + Objects.hashCode(this.locationZip);
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
        if (!Objects.equals(this.sessionID, other.sessionID)) {
            return false;
        }
        if (!Objects.equals(this.serviceID, other.serviceID)) {
            return false;
        }
        if (!Objects.equals(this.contentID, other.contentID)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.currentDateTime, other.currentDateTime)) {
            return false;
        }
        if (!Objects.equals(this.terminalID, other.terminalID)) {
            return false;
        }
        if (!Objects.equals(this.oppType, other.oppType)) {
            return false;
        }
        if (!Objects.equals(this.oppNum, other.oppNum)) {
            return false;
        }
        if (!Objects.equals(this.oppDuration, other.oppDuration)) {
            return false;
        }
        if (!Objects.equals(this.pccCode, other.pccCode)) {
            return false;
        }
        if (!Objects.equals(this.adCampID, other.adCampID)) {
            return false;
        }
        if (!Objects.equals(this.assetID, other.assetID)) {
            return false;
        }
        if (!Objects.equals(this.assetProviderID, other.assetProviderID)) {
            return false;
        }
        if (!Objects.equals(this.viewStartTime, other.viewStartTime)) {
            return false;
        }
        if (!Objects.equals(this.viewEndTime, other.viewEndTime)) {
            return false;
        }
        if (!Objects.equals(this.locationID, other.locationID)) {
            return false;
        }
        if (!Objects.equals(this.locationZip, other.locationZip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adimpression{" + "consumerID=" + consumerID + ", sessionID=" + sessionID + ", serviceID=" + serviceID + ", contentID=" + contentID + ", duration=" + duration + ", currentDateTime=" + currentDateTime + ", terminalID=" + terminalID + ", oppType=" + oppType + ", oppNum=" + oppNum + ", oppDuration=" + oppDuration + ", pccCode=" + pccCode + ", adCampID=" + adCampID + ", assetID=" + assetID + ", assetProviderID=" + assetProviderID + ", viewStartTime=" + viewStartTime + ", viewEndTime=" + viewEndTime + ", locationID=" + locationID + ", locationZip=" + locationZip + '}';
    }
    
}

        


        
        
        
        
        
	