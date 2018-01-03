package com.canopyaudience.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/** 
 @author Jason Canney
 Domain myads class 
 The myads class defines the domain object for ad and coupon data that the mobile app will
 request upon startup
*/


@JsonAutoDetect

@Entity
@Table(name = "myads")
public class myads implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "IDentifier")
	/** 
        Identifier used as PK within the database
        */
	private int IDentifier;
        
        @Column(name = "consumerID")
	/** 
	 Consumers ID
	*/
	private int consumerID;

        @Column(name = "adID")
	/** 
	 Advertisement ID
	*/
	private int adID;

        @Column(name = "adurl")
	/** 
	 advertisement URL location for image
	*/
	private String AdURL;
        
        @Column(name = "adpcc")
	/** 
	 advertisement PCC code
	*/
	private String adPCC;

        @Column(name = "adtitle")
	/** 
	 advertisement title
	*/
	private String adtitle;

        @Column(name = "addescription")
	/** 
	 advertisement description
	*/
	private String addescription;

        @Column(name = "adowner")
	/** 
	 advertisement owner
	*/
	private String adowner;

        @Column(name = "couponID")        
	/** 
	 Coupon ID
	*/
	private int couponID;

        @Column(name = "couponURL") 
	/** 
	 coupon URL location for image
	*/
	private String couponURL;

        @Column(name = "couponTitle") 
	/** 
	 Coupon Title
	*/
	private String couponTitle;

        @Column(name = "couponDescription")         
	/** 
	 Coupon Description
	*/
	private String couponDescription;

        @Column(name = "couponValue") 
	/** 
	 Coupon Value
	*/
	private String couponValue;

        @Column(name = "adcampid") 
	/** 
	 campaign ID for advertiser reference
	*/
	private String adCampID;


	/** 
	  Default Constructor
	  @param myads object
	*/
	public myads()
	{

	}

	/** 
	 Overloaded Constructor
     * @param IDentifier
	 @param consumerID
	 @param adID
	 @param adURL
	 @param adPCC
	 @param adtitle 
	 @param addescription
	 @param adowner
	 @param couponID
	 @param couponURL
	 @param couponTitle
	 @param couponDescription
	 @param couponValue
	 @param adCampID
	*/


	public myads(int IDentifier, int consumerID, int adID, String adURL, String adPCC, String adtitle, String addescription, String adowner, int couponID, String couponURL, String couponTitle, String couponDescription, String couponValue, String adCampID)
	{
		super();
                this.IDentifier = IDentifier;
		this.consumerID = consumerID;
		this.adID = adID;
		this.AdURL = adURL;
		this.adPCC = adPCC;
		this.adtitle = adtitle;
		this.addescription = addescription;
		this.adowner = adowner;
		this.couponID = couponID;
		this.couponURL = couponURL;
		this.couponTitle = couponTitle;
		this.couponDescription = couponDescription;
		this.couponValue = couponValue;
		this.adCampID = adCampID;
	}

    public myads(int consumerID, int adID, String AdURL, String adPCC, String adtitle, String addescription, String adowner, int couponID, String couponURL, String couponTitle, String couponDescription, String couponValue, String adCampID) {
        this.consumerID = consumerID;
        this.adID = adID;
        this.AdURL = AdURL;
        this.adPCC = adPCC;
        this.adtitle = adtitle;
        this.addescription = addescription;
        this.adowner = adowner;
        this.couponID = couponID;
        this.couponURL = couponURL;
        this.couponTitle = couponTitle;
        this.couponDescription = couponDescription;
        this.couponValue = couponValue;
        this.adCampID = adCampID;
    }
        
        
        public int getIDentifier() {
            return IDentifier;
        }

        public void setIDentifier(int IDentifier) {
            this.IDentifier = IDentifier;
        }

        public int getConsumerID() {
            return consumerID;
        }

        public void setConsumerID(int consumerID) {
            this.consumerID = consumerID;
        }

        public int getAdID() {
            return adID;
        }

        public void setAdID(int adID) {
            this.adID = adID;
        }

        public String getAdURL() {
            return AdURL;
        }

        public void setAdURL(String AdURL) {
            this.AdURL = AdURL;
        }

        public String getAdPCC() {
            return adPCC;
        }

        public void setAdPCC(String adPCC) {
            this.adPCC = adPCC;
        }

        public String getAdtitle() {
            return adtitle;
        }

        public void setAdtitle(String adtitle) {
            this.adtitle = adtitle;
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

        public int getCouponID() {
            return couponID;
        }

        public void setCouponID(int couponID) {
            this.couponID = couponID;
        }

        public String getCouponURL() {
            return couponURL;
        }

        public void setCouponURL(String couponURL) {
            this.couponURL = couponURL;
        }

        public String getCouponTitle() {
            return couponTitle;
        }

        public void setCouponTitle(String couponTitle) {
            this.couponTitle = couponTitle;
        }

        public String getCouponDescription() {
            return couponDescription;
        }

        public void setCouponDescription(String couponDescription) {
            this.couponDescription = couponDescription;
        }

        public String getCouponValue() {
            return couponValue;
        }

        public void setCouponValue(String couponValue) {
            this.couponValue = couponValue;
        }

        public String getAdCampID() {
            return adCampID;
        }

        public void setAdCampID(String adCampID) {
            this.adCampID = adCampID;
        }

	/** 
	 Validate if the instance variables are valid
	 
	 @return  boolean - true if instance variables are valid, else false 
	*/
	public boolean validate()
	{
/*
		if (consumerID == null)
		{
			return false;
		}
		if (adID == null)
		{
			return false;
		} */
		if (AdURL == null)
		{
			return false;
		}
		if (adPCC == null)
		{
			return false;
		}
		if (adtitle == null)
		{
			 return false;
		}
		if (addescription == null)
		{
			return false;
		}
		if (adowner == null)
		{
			return false;
		}/*
		if (couponID == null)
		{
			return false;
		}*/
		if (couponURL == null)
		{
			return false;
		}
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
		if (adCampID == null)
		{
			return false;
		}

		return true;
	}
        
		/** 
		 Constructs a <code>STring</code> with all attributes
		 in name = value format
		 
		 @return a <code>String</code> representation
		 of this object
		 
		*/

		@Override
		public String toString()
		{
			StringBuilder strBfr = new StringBuilder();
			strBfr.append("consumerID:");
			strBfr.append(consumerID);
			strBfr.append("adID:");
			strBfr.append(adID);
			strBfr.append("\nadURL:");
			strBfr.append(AdURL);
			strBfr.append("\nadPCC:");
			strBfr.append(adPCC);
			strBfr.append("\nadtitle:");
			strBfr.append(adtitle);
			strBfr.append("\naddescription:");
			strBfr.append(addescription);
			strBfr.append("\nadowner:");
			strBfr.append(adowner);
			strBfr.append("couponID:");
			strBfr.append(couponID);
			strBfr.append("\ncouponURL:");
			strBfr.append(couponURL);
			strBfr.append("couponTitle:");
			strBfr.append(couponTitle);
			strBfr.append("\ncouponDescription");
			strBfr.append(couponDescription);
			strBfr.append("\ncouponValue:");
			strBfr.append(couponValue);
			strBfr.append("\nadCampID:");
			strBfr.append(adCampID);

		return strBfr.toString();
		}

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 89 * hash + this.IDentifier;
            hash = 89 * hash + this.consumerID;
            hash = 89 * hash + this.adID;
            hash = 89 * hash + Objects.hashCode(this.AdURL);
            hash = 89 * hash + Objects.hashCode(this.adPCC);
            hash = 89 * hash + Objects.hashCode(this.adtitle);
            hash = 89 * hash + Objects.hashCode(this.addescription);
            hash = 89 * hash + Objects.hashCode(this.adowner);
            hash = 89 * hash + this.couponID;
            hash = 89 * hash + Objects.hashCode(this.couponURL);
            hash = 89 * hash + Objects.hashCode(this.couponTitle);
            hash = 89 * hash + Objects.hashCode(this.couponDescription);
            hash = 89 * hash + Objects.hashCode(this.couponValue);
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
            final myads other = (myads) obj;
            if (this.IDentifier != other.IDentifier) {
                return false;
            }
            if (this.consumerID != other.consumerID) {
                return false;
            }
            if (this.adID != other.adID) {
                return false;
            }
            if (this.couponID != other.couponID) {
                return false;
            }
            if (!Objects.equals(this.AdURL, other.AdURL)) {
                return false;
            }
            if (!Objects.equals(this.adPCC, other.adPCC)) {
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
            if (!Objects.equals(this.couponURL, other.couponURL)) {
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
            if (!Objects.equals(this.adCampID, other.adCampID)) {
                return false;
            }
            return true;
        }

                

}