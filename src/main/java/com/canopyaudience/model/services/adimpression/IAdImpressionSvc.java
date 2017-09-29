/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adimpression;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.services.IService;
import com.canopyaudience.model.services.exception.AdImpressionException;
import java.util.Set;

/**
 *
 * @author Jason
 */
public interface IAdImpressionSvc extends IService {
	
	public final String NAME = "IAdImpressionSvc";
	
	/**
	 * Persists an adimpression
	 * The storeAdImpression takes in an adimpression object as input and will pass it to the AdImpressionSvcImpl
	 * @param adimpression The adimpression to be persisted
	 * @return boolean true/false
	 * @throws AdImpressionException 
	 */
	public boolean storeAdImpression(adimpression adimpression) throws AdImpressionException;
	/**
	 * Retrieves an application
	 * The getApplication takes an ID as an argument and retrieves it through the ApplicationSvcImpl class
	 * @return The collection
	 * @throws AdImpressionException
	 * @throws ClassNotFoundException 
	 */
	// public boolean getApplication(Application application) throws ApplicationException, ClassNotFoundException;
	
	public Set<adimpression> getAdImpression() throws AdImpressionException,
			ClassNotFoundException;
 
        /**
        * Updates Application object received from GUI and put in database
        * @param adimpression
        * @return boolean
        */
        public boolean updateAdImpression(adimpression adimpression);
        
          /**
           * Deletes data from database through hibernate interface
            * @param adimpression
            * @return boolean of adimpression
            */
        public boolean deleteAdImpression(adimpression adimpression);
        
        
        
        
}
