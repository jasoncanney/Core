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
 Domain login class 
 The login class defines the domain object for login data that will
 be received by the CDE from the mobile app and then stored in a data store
 by the CDE
 
 
*/
@Entity
@Table(name = "login")
public class login implements Serializable
{

 /**  @param serialVersionUID
  The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
  then an InvalidClassException is thrown
 */

	private static final long serialVersionUID = 4349382150030819493L;
        @Id
        // @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "UserName", nullable = false, length = 100)

	/** 
	 Users UserName
	*/
	private String UserName;
        
        @Column(name = "PassWord", nullable = false, length = 100)
	/** 
	 Users Password
	*/
	private String PassWord;


	/** 
	  Default Constructor
	  @param login object
	*/
	public login()
	{

	}

	/** 
	 Overloaded Constructor
	 @param UserName
	 @param PassWord 
	*/

	public login(String UserName, String PassWord)
	{
		super();
		this.UserName = UserName;
		this.PassWord = PassWord;
	}

	// getters and setters

	/** @return  Returns the UserName
	 <sets>Sets the UserName</sets>
	*/

	public String getuserName()
	{
		return UserName;
	}
	public void setuserName(String value)
	{
		this.UserName = value;
	}

	/** @return  Returns the password 
	 <sets>Sets the password</sets>
	*/

	public String getpassWord()
	{
		return PassWord;
	}
	public void setpassWord(String value)
	{
		this.PassWord = value;
	}


	/** 
	 Validate if the instance variables are valid
	 
	 @return  boolean - true if instance variables are valid, else false 
	*/
	public boolean validate()
	{

		if (PassWord == null)
		{
			return false;
		}
		if (UserName == null)
		{
			 return false;
		}

		return true;
	}

	/** Equals Test Method
	 @param UserName
	 @param PassWord 
	*/


	public boolean equals(login login)


	{

			if (!UserName.equals(login.UserName))
			{
				return false;
			}

			if (!PassWord.equals(login.PassWord))
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
			strBfr.append("UserName:");
			strBfr.append(UserName);
			strBfr.append("PassWord:");
			strBfr.append(PassWord);


		return strBfr.toString();
		}

}