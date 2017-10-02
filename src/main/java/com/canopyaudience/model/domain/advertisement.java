package com.canopyaudience.model.domain;

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
 Domain Advertisement class 
 * updated with hibernate entity bean logic
 The Advertisement class defines the domain object for advertisement data that will
 be received by the CDE from advertisers and then stored in a data store
 by the CDE
*/

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

	public advertisement(int adID, String adtitle, int addemo01, int addemo02, int addemo03, int addemo04, String addescription, String adowner, String adbrand, String adPCC, String adURL, String adCampID)
	{
		super();
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

	// getters and setters

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

	

	/** 
	 Validate if the instance variables are valid
	 
	 @return  boolean - true if instance variables are valid, else false 
	*/
	public boolean validate()
	{

                if (adID == -1)
		{
			return false;
		}
		if (adtitle == null)
		{
			 return false;
		}
		if (addemo01 == -1)
		{
			return false;
		}
		if (addemo02 == -1)
		{
			return false;
		}
		if (addemo03 == -1)
		{
			return false;
		}
		if (addemo04 == -1)
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
		}
		if (adbrand == null)
		{
			return false;
		}
		if (adPCC == null)
		{
			return false;
		}
		if (adURL == null)
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

	public boolean equals(advertisement advertisement)


	{

			if (!(new Integer(adID)).equals(advertisement.adID))
			{
				return false;
			}

			if (!adtitle.equals(advertisement.adtitle))
			{
				return false;
			}
			if (!(new Integer(addemo01)).equals(advertisement.addemo01))
			{
				return false;
			}
			if (!(new Integer(addemo02)).equals(advertisement.addemo02))
			{
				return false;
			}

			if (!(new Integer(addemo03)).equals(advertisement.addemo03))
			{
				return false;
			}
			if (!(new Integer(addemo04)).equals(advertisement.addemo04))
			{
				return false;
			}
			if (!addescription.equals(advertisement.addescription))
			{
				return false;
			}

			if (!adowner.equals(advertisement.adowner))
			{
				return false;
			}
			if (!adbrand.equals(advertisement.adbrand))
			{
				return false;
			}
			if (!adPCC.equals(advertisement.adPCC))
			{
				return false;
			}
			if (!adURL.equals(advertisement.adURL))
			{
				return false;
			}
			if (!adCampID.equals(advertisement.adCampID))
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
			strBfr.append("adID:");
			strBfr.append(adID);
			strBfr.append("\nadtitle:");
			strBfr.append(adtitle);
			strBfr.append("\naddemo01:");
			strBfr.append(addemo01);
			strBfr.append("\naddemo02:");
			strBfr.append(addemo02);
			strBfr.append("\naddemo03:");
			strBfr.append(addemo03);
			strBfr.append("\naddemo04:");
			strBfr.append(addemo04);
			strBfr.append("\naddescription:");
			strBfr.append(addescription);
			strBfr.append("\nadowner:");
			strBfr.append(adowner);
			strBfr.append("\nadbrand:");
			strBfr.append(adbrand);
			strBfr.append("\nadPCC:");
			strBfr.append(adPCC);
			strBfr.append("\nadURL:");
			strBfr.append(adURL);
			strBfr.append("\nadCampID:");
			strBfr.append(adCampID);
		return strBfr.toString();
		}

}