package com.canopyaudience.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 @author Jason Canney
 added new comment to test github setup
 Domain Consumer History class 
 The ConsumerHistory class defines the domain object for consumer VIEWS and Preferences data that will
 be received by the CDE from the mobile app and then stored in a data store
 by the CDE
 
 
*/
@Entity
@Table(name = "consumerhistory")
public class consumerHistory implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;
        
        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "consumerID")
	/** 
	 Consumers ID
	*/
	private int consumerID;

        @Column(name = "preferenceID")
	/** 
	 Preference ID
	*/
	private int preferenceID;

        @Column(name = "preferenceDate", nullable = false, length = 50)
	/** 
	 Preference Date
	*/
	private String preferenceDate;

        @Column(name = "preferenceChoice")
	/** 
	 Preference Choice
	*/
	private int preferenceChoice;

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



	/** 
	  Default Constructor
	  @param consumerHistory object
	*/
	public consumerHistory()
	{

	}

	/** 
	 Overloaded Constructor
	 @param consumerID
	 @param preferenceID 
	 @param preferenceDate 
	 @param preferenceChoice 
	 @param advertisementID
	 @param couponID
	*/

	public consumerHistory(int consumerID, int preferenceID, String preferenceDate, int preferenceChoice, int advertisementID, int couponID)
	{
		super();
		this.consumerID = consumerID;
		this.preferenceID = preferenceID;
		this.preferenceDate = preferenceDate;
		this.preferenceChoice = preferenceChoice;
		this.advertisementID = advertisementID;
		this.couponID = couponID;
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

	/** @return  Returns the consumer's preference ID 
	 <sets>Sets the consumer's preference ID</sets>
	*/

	public int getPreferenceID()
	{
		return preferenceID;
	}
	public void setPreferenceID(int value)
	{
		this.preferenceID = value;
	}



		/** @return  Returns the consumer's preference date 
		 <sets>Sets the consumer's preference date</sets>
		*/

		public String getPreferenceDate()
		{
			return preferenceDate;
		}
		public void setPreferenceDate(String value)
		{
			this.preferenceDate = value;
		}

		/** @return  Returns the consumer's preference choice is positive (1) or negative (0) 
		 <sets>Sets the consumer's preference choice</sets>
		*/

		public int getPreferenceChoice()
		{
			return preferenceChoice;
		}
		public void setPreferenceChoice(int value)
		{
			this.preferenceChoice = value;
		}

	/** @return  Returns the consumer's advertisement id 
	 <sets>Sets the consumer's advertisement ID</sets>
	*/

	public int getAdvertisementID()
	{
		return advertisementID;
	}
	public void setAdvertisementID(int value)
	{
		this.advertisementID = value;
	}

	/** @return  Returns the consumer's coupon ID 
	 <sets>Sets the consumer's coupon ID</sets>
	*/

	public int getCouponID()
	{
		return couponID;
	}
	public void setCouponID(int value)
	{
		this.couponID = value;
	}


	/** 
	 Validate if the instance variables are valid
	 
	 @return  boolean - true if instance variables are valid, else false 
	*/
	public boolean validate()
	{

		if (consumerID == -1)
		{
			return false;
		}
		if (preferenceID == -1)
		{
			 return false;
		}
		if (preferenceDate == null)
		{
			return false;
		}
		if (preferenceChoice == -1)
		{
			return false;
		}
		if (advertisementID == -1)
		{
			return false;
		}
		if (couponID == -1)
		{
			return false;
		}

		return true;
	}

	/** Equals Test Method
        * @param consumerHistory
	*/

	public boolean equals(consumerHistory consumerHistory)


	{

			if (!(new Integer(consumerID)).equals(consumerHistory.consumerID))
			{
				return false;
			}

			if (!(new Integer(preferenceID)).equals(consumerHistory.preferenceID))
			{
				return false;
			}
			if (!preferenceDate.equals(consumerHistory.preferenceDate))
			{
				return false;
			}
			if (!(new Integer(preferenceChoice)).equals(consumerHistory.preferenceChoice))
			{
				return false;
			}
			if (!(new Integer(advertisementID)).equals(consumerHistory.advertisementID))
			{
				return false;
			}
			if (!(new Integer(couponID)).equals(consumerHistory.couponID))
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
	 /// @param consumerID
	*/

	@Override
	public String toString()
	{
			StringBuilder strBfr = new StringBuilder();
			strBfr.append("consumerID:");
			strBfr.append(consumerID);
			strBfr.append("\npreferenceID:");
			strBfr.append(preferenceID);
			strBfr.append("\npreferenceDate:");
			strBfr.append(preferenceDate);
			strBfr.append("\npreferenceChoice:");
			strBfr.append(preferenceChoice);
			strBfr.append("\nadvertisementID:");
			strBfr.append(advertisementID);
			strBfr.append("\ncouponID:");
			strBfr.append(couponID);

		return strBfr.toString();
	}

}