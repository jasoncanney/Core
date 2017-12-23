package com.canopyaudience.model.services.interestservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.IntException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;

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
         * Pulls data from database through hibernate interface
         * @return <list> of interest
         * @throws java.lang.ClassNotFoundException
         * @throws org.apache.mahout.cf.taste.common.TasteException
         */
        public AbstractJDBCDataModel getMahoutInterest() throws IntException, ClassNotFoundException, TasteException;

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