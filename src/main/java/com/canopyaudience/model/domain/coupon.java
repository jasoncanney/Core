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
	*/

	public coupon(int couponID, String couponTitle, String couponDescription, String couponValue, String couponStartActive, String couponEndActive, String couponLocationsZip)
	{
		super();
		this.couponID = couponID;
		this.couponTitle = couponTitle;
		this.couponDescription = couponDescription;
		this.couponValue = couponValue;
		this.couponStartActive = couponStartActive;
		this.couponEndActive = couponEndActive;
		this.couponLocationsZip = couponLocationsZip;
	}

	// getters and setters

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

	/** Equals Test Method
	 @param couponID
	 @param couponTitle 
	 @param couponDescription 
	 @param couponValue 
	 @param couponStartActive
	 @param couponEndActive
	 @param couponLocationsZip
	*/

	public boolean equals(coupon coupon)


	{

			if (!(new Integer(couponID)).equals(coupon.couponID))
			{
				return false;
			}

			if (!couponTitle.equals(coupon.couponTitle))
			{
				return false;
			}
			if (!couponDescription.equals(coupon.couponDescription))
			{
				return false;
			}
			if (!couponValue.equals(coupon.couponValue))
			{
				return false;
			}

			if (!couponStartActive.equals(coupon.couponStartActive))
			{
				return false;
			}
			if (!couponEndActive.equals(coupon.couponEndActive))
			{
				return false;
			}
			if (!couponLocationsZip.equals(coupon.couponLocationsZip))
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
	 
	@param couponID
	 @param couponTitle 
	 @param couponDescription 
	 @param couponValue 
	 @param couponStartActive
	 @param couponEndActive
	 @param couponLocationsZip
	*/

	@Override
	public String toString()
	{
			StringBuilder strBfr = new StringBuilder();
			strBfr.append("couponID:");
			strBfr.append(couponID);
			strBfr.append("couponTitle:");
			strBfr.append(couponTitle);
			strBfr.append("\ncouponDescription");
			strBfr.append(couponDescription);
			strBfr.append("\ncouponValue:");
			strBfr.append(couponValue);
			strBfr.append("\ncouponStartDate:");
			strBfr.append(couponStartActive);
			strBfr.append("\ncouponEndDate:");
			strBfr.append(couponEndActive);
			strBfr.append("\ncouponLocationsZip:");
			strBfr.append(couponLocationsZip);

		return strBfr.toString();
	}

}