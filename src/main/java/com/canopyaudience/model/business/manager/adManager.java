package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.adservice.IAdSvc;
import com.canopyaudience.model.services.exception.AdvertisementException;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class adManager extends ManagerSuperType
{
        
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IAdSvc adSvc = (IAdSvc)context.getBean("IAdSvc");
    
	/** 
	 Business use case for "store advertisement"
	 
	 @param c
	*/
	public final boolean Create(advertisement a)
	{
		// Factory factory = Factory.getInstance();
		// IAdSvc adSvc = (IAdSvc)factory.getService("IAdSvc");
		adSvc.storeAdvertisement(a);
		return true;

	}

	/** 
	 Business use case for "retrieve advertisement list"
	 
	 @param id
	 @return Set<advertisement> 
	*/
	public final List<advertisement>  Get() throws AdvertisementException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// IAdSvc adSvc = (IAdSvc)factory.getService("IAdSvc");
		return adSvc.getAdvertisement();
	}
        
        /** 
	 Business use case for "retrieve single advertisement"
         * @param id
	 @return advertisement
         * @throws java.lang.ClassNotFoundException
        */
	public final advertisement GetA(int id) throws AdvertisementException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// IConsumerSvc consSvc = (IConsumerSvc)factory.getService("IConsumerSvc");
		return adSvc.getAAdvertisement(id);
	}
        
	/** 
	 Business use case for "update advertisement"
	 
	 @param c
	*/
	public final boolean Update(advertisement c)
	{
		// Factory factory = Factory.getInstance();
		// IAdSvc adSvc = (IAdSvc)factory.getService("IAdSvc");
		adSvc.updateAdvertisement(c);
		return true;

	}

	/** 
	 Business use case for "delete advertisement"
	 
	 @param c
	*/
	public final boolean Delete(advertisement c)
	{
		// Factory factory = Factory.getInstance();
		// IAdSvc adSvc = (IAdSvc)factory.getService("IAdSvc");
		adSvc.deleteAdvertisement(c);
		return true;
	}

}