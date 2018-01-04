package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 @author Jason Canney  
 Domain Advertisement class 
 * updated with hibernate entity bean logic
 The Advertisement class defines the domain object for advertisement data that will
 be received by the CDE from advertisers and then stored in a data store
 by the CDE
*/
@JsonAutoDetect

@Entity
@Table(name = "advertisement")
public class advertisement implements Serializable
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
  
        @Column(name = "adID")
	/** 
	 Advertisement ID
	*/
	private int adID;

        
        @Column(name = "adtitle", nullable = false, length = 50)
	/** 
	 advertisement title
	*/
	private String adtitle;

        
        @Column(name = "addemo01")
	/** 
	 advertisement demographic01
	*/
	private int addemo01;

        @Column(name = "addemo02")
	/** 
	 advertisement demographic02
	*/
	private int addemo02;

        @Column(name = "addemo03")
	/** 
	 advertisement demographic03
	*/
	private int addemo03;

        @Column(name = "addemo04")
	/** 
	 advertisement demographic04
	*/
	private int addemo04;

        @Column(name = "addescription", nullable = false, length = 50)
	/** 
	 advertisement description
	*/
	private String addescription;

        @Column(name = "adowner", nullable = false, length = 50)
	/** 
	 advertisement owner
	*/
	private String adowner;

        @Column(name = "adbrand", nullable = false, length = 50)
	/** 
	 advertisement brand
	*/
	private String adbrand;

        @Column(name = "adpcc", nullable = false, length = 50)
	/** 
	 advertisement PCC code
	*/
	private String adPCC;

        @Column(name = "adurl", nullable = false, length = 50)
	/** 
	 advertisement URL location for image
	*/
	private String adURL;

        @Column(name = "adcampid", nullable = false, length = 50)
	/** 
	 advertisement campaign ID for advertiser reference
	*/
	private String adCampID;

	/** 
	  Default Constructor
	  @param advertisement object
	*/
	public advertisement()
	{

	}

	/** 
	 Overloaded Constructor
         @param identifier
	 @param adID
	 @param adtitle 
	 @param addemo01 
	 @param addemo02 
	 @param addemo03
	 @param addemo04
	 @param addescription
	 @param adowner
	 @param adbrand
	 @param adPCC
	 @param adURL
	 @param adCampID
	*/

	public advertisement(int identifier, int adID, String adtitle, int addemo01, int addemo02, int addemo03, int addemo04, String addescription, String adowner, String adbrand, String adPCC, String adURL, String adCampID) {
        this.identifier = identifier;
        this.adID = adID;
        this.adtitle = adtitle;
        this.addemo01 = addemo01;
        this.addemo02 = addemo02;
        this.addemo03 = addemo03;
        this.addemo04 = addemo04;
        this.addescription = addescription;
        this.adowner = adowner;
        this.adbrand = adbrand;
        this.adPCC = adPCC;
        this.adURL = adURL;
        this.adCampID = adCampID;
    }
        /**
	 Overloaded Constructor
	 @param adID
	 @param adtitle 
	 @param addemo01 
	 @param addemo02 
	 @param addemo03
	 @param addemo04
	 @param addescription
	 @param adowner
	 @param adbrand
	 @param adPCC
	 @param adURL
	 @param adCampID
	*/
         public advertisement(int adID, String adtitle, int addemo01, int addemo02, int addemo03, int addemo04, String addescription, String adowner, String adbrand, String adPCC, String adURL, String adCampID) {
        this.adID = adID;
        this.adtitle = adtitle;
        this.addemo01 = addemo01;
        this.addemo02 = addemo02;
        this.addemo03 = addemo03;
        this.addemo04 = addemo04;
        this.addescription = addescription;
        this.adowner = adowner;
        this.adbrand = adbrand;
        this.adPCC = adPCC;
        this.adURL = adURL;
        this.adCampID = adCampID;
        }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public int getAddemo01() {
        return addemo01;
    }

    public void setAddemo01(int addemo01) {
        this.addemo01 = addemo01;
    }

    public int getAddemo02() {
        return addemo02;
    }

    public void setAddemo02(int addemo02) {
        this.addemo02 = addemo02;
    }

    public int getAddemo03() {
        return addemo03;
    }

    public void setAddemo03(int addemo03) {
        this.addemo03 = addemo03;
    }

    public int getAddemo04() {
        return addemo04;
    }

    public void setAddemo04(int addemo04) {
        this.addemo04 = addemo04;
    }

    public String getAddescription() {
        return addescription;
    }

    public void setAddescription(String addescription) {
        this.addescription = addescription;
    }

    public String getAdowner() {
        return adowner;
    }

    public void setAdowner(String adowner) {
        this.adowner = adowner;
    }

    public String getAdbrand() {
        return adbrand;
    }

    public void setAdbrand(String adbrand) {
        this.adbrand = adbrand;
    }

    public String getAdPCC() {
        return adPCC;
    }

    public void setAdPCC(String adPCC) {
        this.adPCC = adPCC;
    }

    public String getAdURL() {
        return adURL;
    }

    public void setAdURL(String adURL) {
        this.adURL = adURL;
    }

    public String getAdCampID() {
        return adCampID;
    }

    public void setAdCampID(String adCampID) {
        this.adCampID = adCampID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.identifier;
        hash = 89 * hash + this.adID;
        hash = 89 * hash + Objects.hashCode(this.adtitle);
        hash = 89 * hash + this.addemo01;
        hash = 89 * hash + this.addemo02;
        hash = 89 * hash + this.addemo03;
        hash = 89 * hash + this.addemo04;
        hash = 89 * hash + Objects.hashCode(this.addescription);
        hash = 89 * hash + Objects.hashCode(this.adowner);
        hash = 89 * hash + Objects.hashCode(this.adbrand);
        hash = 89 * hash + Objects.hashCode(this.adPCC);
        hash = 89 * hash + Objects.hashCode(this.adURL);
        hash = 89 * hash + Objects.hashCode(this.adCampID);
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
        final advertisement other = (advertisement) obj;
        if (this.identifier != other.identifier) {
            return false;
        }
        if (this.adID != other.adID) {
            return false;
        }
        if (this.addemo01 != other.addemo01) {
            return false;
        }
        if (this.addemo02 != other.addemo02) {
            return false;
        }
        if (this.addemo03 != other.addemo03) {
            return false;
        }
        if (this.addemo04 != other.addemo04) {
            return false;
        }
        if (!Objects.equals(this.adtitle, other.adtitle)) {
            return false;
        }
        if (!Objects.equals(this.addescription, other.addescription)) {
            return false;
        }
        if (!Objects.equals(this.adowner, other.adowner)) {
            return false;
        }
        if (!Objects.equals(this.adbrand, other.adbrand)) {
            return false;
        }
        if (!Objects.equals(this.adPCC, other.adPCC)) {
            return false;
        }
        if (!Objects.equals(this.adURL, other.adURL)) {
            return false;
        }
        if (!Objects.equals(this.adCampID, other.adCampID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "advertisement{" + "identifier=" + identifier + ", adID=" + adID + ", adtitle=" + adtitle + ", addemo01=" + addemo01 + ", addemo02=" + addemo02 + ", addemo03=" + addemo03 + ", addemo04=" + addemo04 + ", addescription=" + addescription + ", adowner=" + adowner + ", adbrand=" + adbrand + ", adPCC=" + adPCC + ", adURL=" + adURL + ", adCampID=" + adCampID + '}';
    }

}