package com.canopyaudience.model.domain;

import java.io.Serializable;

/** 
 @author Jason Canney
 Domain myAds class 
 The myads class defines the domain object for ad and coupon data that the mobile app will
 request upon startup
 
 
*/

public class myads implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;

	/** 
	 Consumers ID
	*/
	private int consumerID;

	/** 
	 Advertisement ID
	*/
	private int adID;

	/** 
	 advertisement URL location for image
	*/
	private String AdURL;

	/** 
	 advertisement PCC code
	*/
	private String adPCC;

	/** 
	 advertisement title
	*/
	private String adtitle;

	/** 
	 advertisement description
	*/
	private String addescription;

	/** 
	 advertisement owner
	*/
	private String adowner;

	/** 
	 Coupon ID
	*/
	private int couponID;

	/** 
	 coupon URL location for image
	*/
	private String couponURL;

	/** 
	 Coupon Title
	*/
	private String couponTitle;

	/** 
	 Coupon Description
	*/
	private String couponDescription;

	/** 
	 Coupon Value
	*/
	private String couponValue;

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


	public myads(int consumerID, int adID, String adURL, String adPCC, String adtitle, String addescription, String adowner, int couponID, String couponURL, String couponTitle, String couponDescription, String couponValue, String adCampID)
	{
		super();
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

	// getters and setters

	/** @return  Returns the consumer's ID 
	 <sets>Sets the consumer's ID</sets>
	*/

	public int getConsumerID()
	{
		return consumerID;
	}
	public void setConsumerID(int value)
	{
		this.consumerID = value;
	}

	/** @return  Returns the advertisement's ID 
	  <sets>Sets the advertisement's ID</sets>
	*/

	public int getAdId()
	{
		return adID;
	}
	public void setAdId(int value)
	{
		this.adID = value;
	}

	/** @return  Returns the advertisement's URL 
	 <sets>Sets the advertisement's URL</sets>
	*/

	public String getAdUrl()
	{
		return AdURL;
	}
	public void setAdUrl(String value)
	{
		this.AdURL = value;
	}

	/** @return  Returns the advertisement's PCC code 
	 <sets>Sets the advertisement's PCC code</sets>
	*/

	public String getAdPcc()
	{
		return adPCC;
	}
	public void setAdPcc(String value)
	{
		this.adPCC = value;
	}

	/** @return  Returns the advertisement's title 
	 <sets>Sets the advertisement's title </sets>
	*/

	public String getAdTitle()
	{
		return adtitle;
	}
	public void setAdTitle(String value)
	{
		this.adtitle = value;
	}

	/** @return  Returns the advertisement's description 
	 <sets>Sets the advertisement's description</sets>
	*/

	public String getAdDescription()
	{
		return addescription;
	}
	public void setAdDescription(String value)
	{
		this.addescription = value;
	}

	/** @return  Returns the advertisement's owner 
	 <sets>Sets the advertisement's owner</sets>
	*/

	public String getAdOwner()
	{
		return adowner;
	}
	public void setAdOwner(String value)
	{
		this.adowner = value;
	}

	/** @return  Returns the coupon's ID 
	 <sets>Sets the coupon's ID</sets>
	*/

	public int getCouponID()
	{
		return couponID;
	}
	public void setCouponID(int value)
	{
		this.couponID = value;
	}

	/** @return  Returns the coupon's URL 
	 <sets>Sets the coupon's URL</sets>
	*/

	public String getCouponUrl()
	{
		return couponURL;
	}
	public void setCouponUrl(String value)
	{
		this.couponURL = value;
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

	/** @return  Returns the advertisement's Campaign ID 
	 <sets>Sets the advertisement's Campaign ID</sets>
	*/

	public String getAdCampId()
	{
		return adCampID;
	}
	public void setAdCampId(String value)
	{
		this.adCampID = value;
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

	/** Equals Test Method
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


	public boolean equals(myads myads)


	{
			if (!(new Integer(consumerID)).equals(myads.consumerID))
			{
				return false;
			}
			if (!(new Integer(adID)).equals(myads.adID))
			{
				return false;
			}
			if (!AdURL.equals(myads.AdURL))
			{
				return false;
			}
			if (!adPCC.equals(myads.adPCC))
			{
				return false;
			}
			if (!adtitle.equals(myads.adtitle))
			{
				return false;
			}
			if (!addescription.equals(myads.addescription))
			{
				return false;
			}
			if (!adowner.equals(myads.adowner))
			{
				return false;
			}
			if (!(new Integer(couponID)).equals(myads.couponID))
			{
				return false;
			}
			if (!AdURL.equals(myads.couponURL))
			{
				return false;
			}
			if (!couponTitle.equals(myads.couponTitle))
			{
				return false;
			}
			if (!couponDescription.equals(myads.couponDescription))
			{
				return false;
			}
			if (!couponValue.equals(myads.couponValue))
			{
				return false;
			}
			if (!adCampID.equals(myads.adCampID))
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

}