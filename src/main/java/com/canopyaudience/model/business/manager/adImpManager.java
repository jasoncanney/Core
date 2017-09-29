package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.services.factory.Factory;
import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.adimpression.IAdImpressionSvc;
import com.canopyaudience.model.services.exception.AdImpressionException;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class adImpManager extends ManagerSuperType
{
    
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IAdImpressionSvc adSvc = (IAdImpressionSvc)context.getBean("IAdImpressionSvc");
    
	/** 
	 Business use case for "store adimpression"
        * @param a
        * @return boolean
	*/
	public final boolean Create(adimpression a)
	{
		// Factory factory = Factory.getInstance();
		// IAdImpressionSvc adSvc = (IAdImpressionSvc)factory.getService("IAdImpressionSvc");
                adSvc.storeAdImpression(a);
		return true;

	}

	/** 
	 Business use case for "retrieve adimpression list"
	 
	 @return Set<adimpression> 
        * @throws java.lang.ClassNotFoundException 
	*/
	public final Set<adimpression>  Get() throws AdImpressionException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// IAdImpressionSvc adSvc = (IAdImpressionSvc)factory.getService("IAdImpressionSvc");
		return adSvc.getAdImpression();
	}
        
	/** 
	 Business use case for "update adimpression"
	 
	 @param c
        * @return boolean
	*/
	public final boolean Update(adimpression c)
	{
		// Factory factory = Factory.getInstance();
		// IAdImpressionSvc adSvc = (IAdImpressionSvc)factory.getService("IAdImpressionSvc");
		adSvc.updateAdImpression(c);
		return true;

	}

	/** 
	 Business use case for "delete adimpression"
	 
	 @param c
        * @return boolean
	*/
	public final boolean Delete(adimpression c)
	{
		// Factory factory = Factory.getInstance();
		// IAdImpressionSvc adSvc = (IAdImpressionSvc)factory.getService("IAdImpressionSvc");
		adSvc.deleteAdImpression(c);
		return true;
	}

}