package com.canopyaudience.model.services.providerservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.ProviderException;
import java.util.List;

/** 
 This interface defines methods for persisting of consumer.java
 to and from a file system
 @author Jason L. Canney
  
*/
public interface IProviderSvc extends IService
{

	/** 
	 Persists a provider
	 The storeProvider takes in a provider object as input and will pass it to the ConsumerSvcImpl 
	 @param provider The provider to be persisted 
	 @return  void 
	 @exception ProviderException  
	*/

	public boolean storeProvider(provider provider);
        
	/** 
	 Retrieves a single provider
	 The getProvider takes an ID as an argument and retrieves it through the ProviderSvcImpl class 
	 @return  The collection 
	 @exception ProviderException 
	 @exception ClassNotFoundException  
	*/

	public List<provider> getProvider() throws ProviderException, ClassNotFoundException;

	/**
         * Pulls data from database through hibernate interface getAProvider
         * @param id
         * @return provider object
         * @throws java.lang.ClassNotFoundException
         */
        public provider getAProvider(int id) throws ProviderException, ClassNotFoundException;
       
        /** 
	 Updates a consumer
	 The updateProvider takes in a provider object as input and will pass it to the ProviderSvcImpl 
	 @param consumer The consumer to be updated
	 @return  void 
	 @exception ProviderException  
	*/


	public boolean updateProvider(provider provider);

	/** 
	 delete a consumer
	 The deleteProvider takes in a provider object as input and will pass it to the ProviderSvcImpl 
	 @param provider The provider to be updated
	 @return  void 
	 @exception ProviderException  
	*/

	public boolean deleteProvider(provider provider);

}