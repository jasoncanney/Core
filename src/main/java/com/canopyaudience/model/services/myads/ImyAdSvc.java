package com.canopyaudience.model.services.myads;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.myAdsException;
import java.util.List;

/** 
 This interface defines methods for persisting of myads.cs
 to and from a file system
 @author Jason L. Canney
  
*/
public interface ImyAdSvc extends IService
{

	/** 
	 Persists a myads
	 The storemyAds takes in a myads object as input and will pass it to the myAdSvcSQLImpl 
	 @param myads The application to be persisted 
	 @return  boolean true/false 
	 @exception myAdsException  
	*/

	public boolean storemyAds(myads myads);

	/** 
	 Retrieves a myads
	 The myads takes an ID as an argument and retrieves it through the myAdsSvcSQLImpl class 
	 @return  The collection 
	 @exception myAdsException 
	 @exception ClassNotFoundException  
	*/

        public List<myads> getmyAds() throws myAdsException,
			ClassNotFoundException;
	/**
        * Pulls an myads data from database through hibernate interface
        * @param id
        * @return myads
        * @throws java.lang.ClassNotFoundException
        */
        public myads getAmyAds(int id) throws myAdsException, ClassNotFoundException;
        
        /** 
	 Updates a myads
	 The updatemyAds takes in a myads object as input and will pass it to the myAdsSvcImpl 
	 @param myads The advertisement to be updated
	 @return  void 
	 @exception myAdsException  
	*/

	public boolean updatemyAds(myads myads);

	/** 
	 delete a myads
	 The deletemyAds takes in a myads object as input and will pass it to the advertisementSvcImpl 
	 @param myads The myads to be deleted
	 @return  void 
	 @exception myAdsException  
	*/

	public boolean deletemyAds(myads myads);
}