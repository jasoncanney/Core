package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.adimpression.IAdImpressionSvc;
import com.canopyaudience.model.services.exception.AdImpressionException;
import java.util.List;
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
                adSvc.storeAdImpression(a);
		return true;

	}
	/** 
	 Business use case for "retrieve adimpression list"
	 
	 @return Set<adimpression> 
        * @throws java.lang.ClassNotFoundException 
	*/
	public final List<adimpression>  Get() throws AdImpressionException, ClassNotFoundException
	{
		return adSvc.getAdImpression();
	}
        
        /** 
	 Business use case for "retrieve single adimpression"
         * @param id
	 @return adimpression
         * @throws java.lang.ClassNotFoundException
        */
	public final adimpression GetA(int id) throws AdImpressionException, ClassNotFoundException
	{
		return adSvc.getAAdImpression(id);
	}
        
	/** 
	 Business use case for "update adimpression"
	 
	 @param c
        * @return boolean
	*/
	public final boolean Update(adimpression c)
	{
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
		adSvc.deleteAdImpression(c);
		return true;
	}

}