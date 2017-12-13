package com.canopyaudience.model.services.recoservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.RecoException;
import java.util.List;

/** 
 This interface defines methods for storing and retrieving recommendation
 to and from a file system
 @author Jason Canney
 
*/
public interface IRecoSvc extends IService
{

	/** 
	 Persists a recommendation
	 The storeReco interface uses the storeReco method in the recommendationSvcImpl class to store the object 
	 @param recommendation The recommendation to be persisted 
	 @return  boolean true/false 
	 @exception RecoException  
	*/
	public boolean storeReco(recommendation recommendation);

	/** 
	 Retrieves a recommendation 
	 @return  The recommendation object matching recommendation 
        * @throws java.lang.ClassNotFoundException 
	 
	*/
	public List<recommendation> getReco()throws RecoException, ClassNotFoundException;

        /**
        * Pulls single recommendation from database through hibernate interface
        * @param id
        * @return recommendation
        * @throws java.lang.ClassNotFoundException
        */
        public List<recommendation> getAReco(int id) throws RecoException, ClassNotFoundException;
        
	/** 
	 Updates a recommendation
	 The updateReco takes in a recommendation object as input and will pass it to the recoSvcImpl 
	 @param recommendation The recommendation to be updated
	 @return  void 
	 @exception RecoException  
	*/

	public boolean updateReco(recommendation recommendation);

	/** 
	 delete a recommendation
	 The deleteReco takes in a recommendation object as input and will pass it to the recoSvcImpl 
	 @param recommendation The recommendation to be updated
	 @return  void 
	 @exception RecoException  
	*/

	public boolean deleteReco(recommendation recommendation);

}