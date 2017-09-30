package com.canopyaudience.model.services.consumerhistoryservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.ConsumerHistoryException;
import java.util.List;

/** 
 This interface defines methods for persisting of consumerHistory.java
 to and from a file system
 @author Jason L. Canney
  
*/
public interface IConsumerHistorySvc extends IService
{

	/** 
	 Persists a consumerHistory
	 The storeConsumerHistory takes in a consumerHistory object as input and will pass it to the ConsumerHistorySvcImpl 
     * @param consumerHistory
	 @return  boolean true/false 
	 @exception ConsumerHistoryException  
	*/

	public boolean storeConsumerHistory(consumerHistory consumerHistory);

	/** 
	 Retrieves a single consumerHistory
	 The getConsumer takes an ID as an argument and retrieves it through the ConsumerSvcImpl class 
	 @return  The collection 
	 @exception ClassNotFoundException  
	*/

	public List<consumerHistory> getConsumerHistory() throws ConsumerHistoryException, ClassNotFoundException;


	/** 
	 Updates a consumer
	 The updateConsumerHistory takes in a consumerHistory object as input and will pass it to the ConsumerHistorySvcImpl 
	 @param consumerHistory The consumerHistory to be updated
	 @return  void  
	*/

	public boolean updateConsumerHistory(consumerHistory consumerHistory);

	/** 
	 delete a consumerHistory
	 The deleteConsumerHistory takes in a consumerHistory object as input and will pass it to the ConsumerHistorySvcImpl 
	 @param consumerHistory The consumerHistory to be updated
	 @return  void  
	*/

	public boolean deleteConsumerHistory(consumerHistory consumerHistory);

}