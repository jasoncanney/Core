package com.canopyaudience.model.services.interestservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.IntException;
import java.util.List;

/** 
 This interface defines methods for storing and retrieving interest
 to and from a file system
 @author Jason Canney
 
*/
public interface IIntSvc extends IService
{

	/** 
	 Persists a interest
	 The storeReco interface uses the storeReco method in the intSvcImpl class to store the object 
	 @param interest The interest to be persisted 
	 @return  boolean true/false 
	 @exception RecoException  
	*/
	public boolean storeInt(interest interest);

	/** 
	 Retrieves a interest 
	 @return  The interest object matching interest 
        * @throws java.lang.ClassNotFoundException 
	 
	*/
	public List<interest> getInt()throws IntException, ClassNotFoundException;

        /**
        * Pulls single interest from database through hibernate interface
        * @param id
        * @return interest
        * @throws java.lang.ClassNotFoundException
        */
        public List<interest> getAInt(int id) throws IntException, ClassNotFoundException;
        
	/** 
	 Updates a interest
	 The updateReco takes in a interest object as input and will pass it to the recoSvcImpl 
	 @param interest The interest to be updated
	 @return  void 
	 @exception RecoException  
	*/

	public boolean updateInt(interest interest);

	/** 
	 delete a interest
	 The deleteReco takes in a interest object as input and will pass it to the recoSvcImpl 
	 @param interest The interest to be updated
	 @return  void 
	 @exception RecoException  
	*/

	public boolean deleteInt(interest interest);

}