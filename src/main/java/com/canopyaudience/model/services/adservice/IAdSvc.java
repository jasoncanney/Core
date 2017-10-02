package com.canopyaudience.model.services.adservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.AdvertisementException;
import java.util.List;

/** 
 This interface defines methods for persisting of advertisement.cs
 to and from a file system
 @author Jason L. Canney 
 @param NAME is a string used to identify the service
  
*/
public interface IAdSvc extends IService
{

	/** 
	 Persists a advertisement
	 The storeAdvertisement takes in a advertisement object as input and will pass it to the AdSvcSQLImpl 
	 @param advertisement The application to be persisted 
	 @return  boolean true/false 
	 @exception AdvertisementException  
	*/

	public boolean storeAdvertisement(advertisement advertisement);

	/** 
	 Retrieves a advertisement
	 The getAdvertisement takes an ID as an argument and retrieves it through the AdvertisementSvcSQLImpl class 
	 @param none The unique identifier for the advertisement to be retrieved 
	 @return  The collection 
	 @exception AdvertisementException 
	 @exception ClassNotFoundException  
	*/

        public List<advertisement> getAdvertisement() throws AdvertisementException,
			ClassNotFoundException;
	/**
        * Pulls an advertisement data from database through hibernate interface
        * @param id
        * @return advertisement
        * @throws java.lang.ClassNotFoundException
        */
        public advertisement getAAdvertisement(int id) throws AdvertisementException, ClassNotFoundException;
        
        /** 
	 Updates a consumer
	 The updateAdvertisement takes in a advertisement object as input and will pass it to the advertisementSvcImpl 
	 @param advertisement The advertisement to be updated
	 @return  void 
	 @exception ConsumerException  
	*/

	public boolean updateAdvertisement(advertisement advertisement);

	/** 
	 delete a consumer
	 The deleteConsumer takes in a advertisement object as input and will pass it to the advertisementSvcImpl 
	 @param advertisement The advertisement to be deleted
	 @return  void 
	 @exception ConsumerException  
	*/

	public boolean deleteAdvertisement(advertisement advertisement);
}