package com.canopyaudience.model.services.consumerservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.ConsumerException;
import java.sql.ResultSet;
import java.util.Set;

/** 
 This interface defines methods for persisting of consumer.java
 to and from a file system
 @author Jason L. Canney
  
*/
public interface IConsumerSvc extends IService
{

	/** 
	 Persists a consumer
	 The storeConsumer takes in a consumer object as input and will pass it to the ConsumerSvcImpl 
	 @param consumer The application to be persisted 
	 @return  void 
	 @exception ConsumerException  
	*/

	public boolean storeConsumer(consumer consumer);
        
	/** 
	 Retrieves a single consumer
	 The getConsumer takes an ID as an argument and retrieves it through the ConsumerSvcImpl class 
	 @return  The collection 
	 @exception ConsumerException 
	 @exception ClassNotFoundException  
	*/

	public Set<consumer> getConsumer() throws ConsumerException, ClassNotFoundException;

	/** 
	 Updates a consumer
	 The updateConsumer takes in a consumer object as input and will pass it to the ConsumerSvcImpl 
	 @param consumer The consumer to be updated
	 @return  void 
	 @exception ConsumerException  
	*/


	public boolean updateConsumer(consumer consumer);

	/** 
	 delete a consumer
	 The deleteConsumer takes in a consumer object as input and will pass it to the ConsumerSvcImpl 
	 @param consumer The consumer to be updated
	 @return  void 
	 @exception ConsumerException  
	*/

	public boolean deleteConsumer(consumer consumer);

}