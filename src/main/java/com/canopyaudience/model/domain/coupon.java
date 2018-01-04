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
 Domain Coupon class 
 The Coupon class defines the domain object for coupon data that will
 be received by the CDE from the advertiser system and then stored in a data store
 by the CDE
 
 
*/
@JsonAutoDetect

@Entity
@Table(name = "coupon")
public class coupon implements Serializable
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
        
        @Column(name = "couponID")
	/** 
	 Coupon ID
	*/
	private int couponID;

        @Column(name = "couponTitle", nullable = false, length = 50)
	/** 
	 Coupon Title
	*/
	private String couponTitle;

        @Column(name = "couponDescription", nullable = false, length = 50)
	/** 
	 Coupon Description
	*/
	private String couponDescription;

        @Column(name = "couponValue")
	/** 
	 Coupon Value
	*/
	private String couponValue;

        @Column(name = "couponStartActive", nullable = false, length = 50)
	/** 
	 Coupon Start Active
	*/
	private String couponStartActive;

        @Column(name = "couponEndActive", nullable = false, length = 50)
	/** 
	 Coupon End Active
	*/
	private String couponEndActive;

        @Column(name = "couponLocationsZip", nullable = false, length = 50)
	/** 
	 Coupon LocationsZip
	*/
	private String couponLocationsZip;

        @Column(name = "couponURL") 
	/** 
	 coupon URL location for image
	*/
	private String couponURL;
        
        @Column(name = "adcampid") 
	/** 
	 campaign ID for advertiser reference
	*/
	private String adCampID;

        @Column(name = "adID")
	/** 
	 Advertisement ID
	*/
	private int adID;
	/** 
	  Default Constructor
	  @param consumer object
	*/
	public coupon()
	{

	}
        /** 
         Overloaded Constructor
         @param couponID
         @param couponTitle 
         @param couponDescription 
         @param couponValue 
         @param couponStartActive
         @param couponEndActive
         @param couponLocationsZip
         @param couponURL
         @param adCampID
         @param adID
        */
        public coupon(int couponID, String couponTitle, String couponDescription, String couponValue, String couponStartActive, String couponEndActive, String couponLocationsZip, String couponURL, String adCampID, int adID) {
            this.couponID = couponID;
            this.couponTitle = couponTitle;
            this.couponDescription = couponDescription;
            this.couponValue = couponValue;
            this.couponStartActive = couponStartActive;
            this.couponEndActive = couponEndActive;
            this.couponLocationsZip = couponLocationsZip;
            this.couponURL = couponURL;
            this.adCampID = adCampID;
            this.adID = adID;
        }

        /** 
	 Overloaded Constructor
         @param identifier
	 @param couponID
	 @param couponTitle 
	 @param couponDescription 
	 @param couponValue 
	 @param couponStartActive
	 @param couponEndActive
	 @param couponLocationsZip
         @param couponURL
         @param adCampID
         @param adID
	*/
        
        public coupon(int identifier, int couponID, String couponTitle, String couponDescription, String couponValue, String couponStartActive, String couponEndActive, String couponLocationsZip, String couponURL, String adCampID, int adID) {
            this.identifier = identifier;
            this.couponID = couponID;
            this.couponTitle = couponTitle;
            this.couponDescription = couponDescription;
            this.couponValue = couponValue;
            this.couponStartActive = couponStartActive;
            this.couponEndActive = couponEndActive;
            this.couponLocationsZip = couponLocationsZip;
            this.couponURL = couponURL;
            this.adCampID = adCampID;
            this.adID = adID;
        }    


// getters and setters


	public int getIdentifier()
	{
		return identifier;
	}

        public void setIdentifier(int identifier) {
            this.identifier = identifier;
        }

        /** @return  Returns the coupon's ID
        <sets>Sets the coupon's ID</sets>
         */
        public int getCouponID() {
            return couponID;
        }
	public void setCouponID(int value)
	{
		this.couponID = value;
	}

	/** @return  Returns the Coupon Title 
	 <sets>Sets the Coupon Title  </sets>
	*/

	public String getCouponTitle()
	{
		return couponTitle;
	}
	public void setCouponTitle(String value)
	{
		this.couponTitle = value;
	}



	/** @return  Returns the Coupon Description 
	 <sets>Sets the Coupon Description</sets>
	*/

	public String getCouponDescription()
	{
		return couponDescription;
	}
	public void setCouponDescription(String value)
	{
		this.couponDescription = value;
	}

	/** @return  Returns the Coupon Value 
	 <sets>Sets the Coupon Value</sets>
	*/

	public String getCouponValue()
	{
		return couponValue;
	}
	public void setCouponValue(String value)
	{
		this.couponValue = value;
	}

	/** @return  Returns the Coupon's Start Active 
	 <sets>Sets the Coupon's Start Active</sets>
	*/

	public String getCouponStartActive()
	{
		return couponStartActive;
	}
	public void setCouponStartActive(String value)
	{
		this.couponStartActive = value;
	}

	/** @return  Returns the Coupon's End Active 
	 <sets>Sets the Coupon's End Active</sets>
	*/

	public String getCouponEndActive()
	{
		return couponEndActive;
	}
	public void setCouponEndActive(String value)
	{
		this.couponEndActive = value;
	}

	/** @return  Returns the Coupon's Location Zip 
	 <sets>Sets the Coupon's Location Zip</sets>
	*/

	public String getCouponLocationsZip()
	{
		return couponLocationsZip;
	}
	public void setCouponLocationsZip(String value)
	{
		this.couponLocationsZip = value;
	}

        public String getCouponURL() {
            return couponURL;
        }

        public void setCouponURL(String couponURL) {
            this.couponURL = couponURL;
        }

        public String getAdCampID() {
            return adCampID;
        }

        public void setAdCampID(String adCampID) {
            this.adCampID = adCampID;
        }

        public int getAdID() {
            return adID;
        }

        public void setAdID(int adID) {
            this.adID = adID;
        }

	/** 
	 Validate if the instance variables are valid
	 
	 @return  boolean - true if instance variables are valid, else false 
	*/
	public boolean validate()
	{
/*
		if (couponID == null)
		{
			return false;
		}*/
		if (couponTitle == null)
		{
			 return false;
		}
		if (couponDescription == null)
		{
			return false;
		}
		if (couponValue == null)
		{
			return false;
		}
		if (couponStartActive == null)
		{
			return false;
		}
		if (couponEndActive == null)
		{
			return false;
		}
		if (couponLocationsZip == null)
		{
			return false;
		}

		return true;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.identifier;
        hash = 89 * hash + this.couponID;
        hash = 89 * hash + Objects.hashCode(this.couponTitle);
        hash = 89 * hash + Objects.hashCode(this.couponDescription);
        hash = 89 * hash + Objects.hashCode(this.couponValue);
        hash = 89 * hash + Objects.hashCode(this.couponStartActive);
        hash = 89 * hash + Objects.hashCode(this.couponEndActive);
        hash = 89 * hash + Objects.hashCode(this.couponLocationsZip);
        hash = 89 * hash + Objects.hashCode(this.couponURL);
        hash = 89 * hash + Objects.hashCode(this.adCampID);
        hash = 89 * hash + this.adID;
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
        final coupon other = (coupon) obj;
        if (this.identifier != other.identifier) {
            return false;
        }
        if (this.couponID != other.couponID) {
            return false;
        }
        if (this.adID != other.adID) {
            return false;
        }
        if (!Objects.equals(this.couponTitle, other.couponTitle)) {
            return false;
        }
        if (!Objects.equals(this.couponDescription, other.couponDescription)) {
            return false;
        }
        if (!Objects.equals(this.couponValue, other.couponValue)) {
            return false;
        }
        if (!Objects.equals(this.couponStartActive, other.couponStartActive)) {
            return false;
        }
        if (!Objects.equals(this.couponEndActive, other.couponEndActive)) {
            return false;
        }
        if (!Objects.equals(this.couponLocationsZip, other.couponLocationsZip)) {
            return false;
        }
        if (!Objects.equals(this.couponURL, other.couponURL)) {
            return false;
        }
        if (!Objects.equals(this.adCampID, other.adCampID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coupon{" + "identifier=" + identifier + ", couponID=" + couponID + ", couponTitle=" + couponTitle + ", couponDescription=" + couponDescription + ", couponValue=" + couponValue + ", couponStartActive=" + couponStartActive + ", couponEndActive=" + couponEndActive + ", couponLocationsZip=" + couponLocationsZip + ", couponURL=" + couponURL + ", adCampID=" + adCampID + ", adID=" + adID + '}';
    }

   
}