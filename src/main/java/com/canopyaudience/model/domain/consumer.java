package com.canopyaudience.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 @author Jason Canney
 Domain Consumer class 
 The Consumer class defines the domain object for consumer data that will
 be received by the CDE from the mobile app and then stored in a data store
 by the CDE
*/
@Entity
@Table(name = "consumer")
public class consumer implements Serializable
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
	 Consumers ID
	*/
	private int consumerID;

        @Column(name = "ConsumerFirstName", nullable = false, length = 50)
	/** 
	 Consumers First Name
	*/
	private String consumerFirstName;

        @Column(name = "ConsumerMiddleInitial", nullable = false, length = 50)
	/** 
	 Consumers Middle Initial
	*/
	private String consumerMiddleInitial;

        @Column(name = "ConsumerLastName", nullable = false, length = 50)
	/** 
	 Consumers Last Name
	*/
	private String consumerLastName;

        @Column(name = "ConsumerEmail", nullable = false, length = 50)
	/** 
	 Consumer email address
	*/
	private String consumerEmail;

        @Column(name = "ConsumerPhone", nullable = false, length = 50)
	/** 
	 Consumer phone
	*/
	private String consumerPhone;

        @Column(name = "ConsumerAddress", nullable = false, length = 50)
	/** 
	 Consumer Address1
	*/
	private String consumerAddress;

        @Column(name = "ConsumerCity", nullable = false, length = 50)
	/** 
	 Consumer City
	*/
	private String consumerCity;

        @Column(name = "ConsumerState", nullable = false, length = 50)
	/** 
	 Consumer State
	*/
	private String consumerState;

        @Column(name = "ConsumerZip", nullable = false, length = 50)
	/** 
	 Consumer Zip
	*/
	private String consumerZip;

        @Column(name = "ConsumerSocEmail", nullable = false, length = 50)
	/** 
	 Consumer SocialEmail
	*/
	private String consumerSocEmail;


	/** 
	  Default Constructor
	  @param consumer object
	*/
	public consumer()
	{

	}

	/** 
	 Overloaded Constructor
	 @param consumerID
	 @param consumerFirstName 
	 @param consumerMiddleInitial 
	 @param consumerLastName 
	 @param consumerEmail
	 @param consumerPhone
	 @param consumerAddress
	 @param consumerCity
	 @param consumerState
	 @param consumerZip
	 @param consumerSocEmail
	*/

	public consumer(int consumerID, String consumerFirstName, String consumerMiddleInitial, String consumerLastName, String consumerEmail, String consumerPhone, String consumerAddress, String consumerCity, String consumerState, String consumerZip, String consumerSocEmail)
	{
		super();
		this.consumerID = consumerID;
		this.consumerFirstName = consumerFirstName;
		this.consumerMiddleInitial = consumerMiddleInitial;
		this.consumerLastName = consumerLastName;
		this.consumerEmail = consumerEmail;
		this.consumerPhone = consumerPhone;
		this.consumerAddress = consumerAddress;
		this.consumerCity = consumerCity;
		this.consumerState = consumerState;
		this.consumerZip = consumerZip;
		this.consumerSocEmail = consumerSocEmail;
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

	/** @return  Returns the consumer's first name. 
	 <sets>Sets the consumer's first name. </sets>
	*/

	public String getConsumerFirstName()
	{
		return consumerFirstName;
	}
	public void setConsumerFirstName(String value)
	{
		this.consumerFirstName = value;
	}



		/** @return  Returns the consumer's middle initial. 
		 <sets>Sets the consumer's middle initial</sets>
		*/

		public String getConsumerMiddleInitial()
		{
			return consumerMiddleInitial;
		}
		public void setConsumerMiddleInitial(String value)
		{
			this.consumerMiddleInitial = value;
		}

		/** @return  Returns the consumer's last name. 
		 <sets>Sets the consumer's last name</sets>
		*/

		public String getConsumerLastName()
		{
			return consumerLastName;
		}
		public void setConsumerLastName(String value)
		{
			this.consumerLastName = value;
		}

	/** @return  Returns the consumer's email. 
	 <sets>Sets the consumer's email</sets>
	*/

	public String getConsumerEmail()
	{
		return consumerEmail;
	}
	public void setConsumerEmail(String value)
	{
		this.consumerEmail = value;
	}

	/** @return  Returns the consumer's Phone 
	 <sets>Sets the consumer's phone</sets>
	*/

	public String getConsumerPhone()
	{
		return consumerPhone;
	}
	public void setConsumerPhone(String value)
	{
		this.consumerPhone = value;
	}

	/** @return  Returns the consumer's Address 
	 <sets>Sets the consumer's address</sets>
	*/

	public String getConsumerAddress()
	{
		return consumerAddress;
	}
	public void setConsumerAddress(String value)
	{
		this.consumerAddress = value;
	}

	/** @return  Returns the consumer's city 
	 <sets>Sets the consumer's city</sets>
	*/

	public String getConsumerCity()
	{
		return consumerCity;
	}
	public void setConsumerCity(String value)
	{
		this.consumerCity = value;
	}

	/** @return  Returns the consumer's State 
	 <sets>Sets the consumer's State</sets>
	*/

	public String getConsumerState()
	{
		return consumerState;
	}
	public void setConsumerState(String value)
	{
		this.consumerState = value;
	}

	/** @return  Returns the consumer's zip 
	 <sets>Sets the consumer's zip</sets>
	*/

	public String getConsumerZip()
	{
		return consumerZip;
	}
	public void setConsumerZip(String value)
	{
		this.consumerZip = value;
	}

	/** @return  Returns the consumer's Social Media Email 
	 <sets>Sets the consumer's Social Media Email</sets>
	*/

	public String getConsumerSocEmail()
	{
		return consumerSocEmail;
	}
	public void setConsumerSocEmail(String value)
	{
		this.consumerSocEmail = value;
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
		} */
		if (consumerFirstName == null)
		{
			 return false;
		}
		if (consumerMiddleInitial == null)
		{
			return false;
		}
		if (consumerLastName == null)
		{
			return false;
		}
		if (consumerEmail == null)
		{
			return false;
		}
		if (consumerPhone == null)
		{
			return false;
		}
		if (consumerAddress == null)
		{
			return false;
		}

		if (consumerCity == null)
		{
			return false;
		}
		if (consumerState == null)
		{
			return false;
		}
		if (consumerZip == null)
		{
			return false;
		}
		if (consumerSocEmail == null)
		{
			return false;
		}

		return true;
	}

	/** Equals Test Method
	 @param consumerID
	 @param consumerFirstName 
	 @param consumerMiddleInitial 
	 @param consumerLastName 
	 @param consumerEmail
	 @param consumerPhone
	 @param consumerAddress
	 @param consumerCity
	 @param consumerState
	 @param consumerZip
	 @param consumerSocEmail
	*/

	public boolean equals(consumer consumer)


	{

			if (!(new Integer(consumerID)).equals(consumer.consumerID))
			{
				return false;
			}

			if (!consumerFirstName.equals(consumer.consumerFirstName))
			{
				return false;
			}
			if (!consumerMiddleInitial.equals(consumer.consumerMiddleInitial))
			{
				return false;
			}
			if (!consumerLastName.equals(consumer.consumerLastName))
			{
				return false;
			}

			if (!consumerEmail.equals(consumer.consumerEmail))
			{
				return false;
			}
			if (!consumerPhone.equals(consumer.consumerPhone))
			{
				return false;
			}
			if (!consumerAddress.equals(consumer.consumerAddress))
			{
				return false;
			}

			if (!consumerCity.equals(consumer.consumerCity))
			{
				return false;
			}
			if (!consumerState.equals(consumer.consumerState))
			{
				return false;
			}
			if (!consumerZip.equals(consumer.consumerZip))
			{
				return false;
			}
			if (!consumerSocEmail.equals(consumer.consumerSocEmail))
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
			strBfr.append("consumerFirstName:");
			strBfr.append(consumerFirstName);
			strBfr.append("\nconsumerMiddleInitial:");
			strBfr.append(consumerMiddleInitial);
			strBfr.append("\nconsumerLastName:");
			strBfr.append(consumerLastName);
			strBfr.append("\nconsumerEmail:");
			strBfr.append(consumerEmail);
			strBfr.append("\nconsumerPhone:");
			strBfr.append(consumerPhone);
			strBfr.append("\nconsumerAddress:");
			strBfr.append(consumerAddress);
			strBfr.append("\nconsumerCity:");
			strBfr.append(consumerCity);
			strBfr.append("\nconsumerState:");
			strBfr.append(consumerState);
			strBfr.append("\nconsumerZip:");
			strBfr.append(consumerZip);
			strBfr.append("\nconsumerSocEmail:");
			strBfr.append(consumerSocEmail);

		return strBfr.toString();
		}

}