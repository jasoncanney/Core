package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.IntException;
import com.canopyaudience.model.services.interestservice.IIntSvc;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class intManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IIntSvc intSvc = (IIntSvc)context.getBean("IIntSvc");
        
	/** 
	 Business use case for "store interest"
	 
	 @param c
        * @return 
	*/
	public final boolean Create(interest c)
	{
		intSvc.storeInt(c);
		return true;
	}
	
        /** 
	 Business use case for "store a LIST of interests"
	 @param c
        * @return 
	*/
	public final boolean StoreAllInts(List<interest> c)
	{
            int i = 0;
        
            while (i < c.size()) {
            intSvc.storeInt(c.get(i));
            i++;
            }
	
            return true;
	}
        
        /** 
	 Business use case for retrieving Mahout preference list
	 
	 @return Set<interest> 
        * @throws java.lang.ClassNotFoundException 
	*/
	public final List<interest>  Get() throws IntException, ClassNotFoundException
	{
		return intSvc.getInt();
	}
        
        /** 
	 Business use case for "retrieve list of interests for a single consumerID"
         * @param id
	 @return interest
         * @throws java.lang.ClassNotFoundException
	*/
	public final List<interest> GetA(int id) throws IntException, ClassNotFoundException
	{
		return intSvc.getAInt(id);
	}
        
        /** 
	 Business use case for "update preference"
	 
	 @param c
        * @return 
	*/
	public final boolean Update(interest c)
	{
		intSvc.updateInt(c);
		return true;

	}

        
        /** 
	 Business use case for "delete a LIST of interests"
	 @param c
        * @return 
	*/
	public final boolean DeleteAllRecos(List<interest> c)
	{
            int i = 0;
        
            while (i < c.size()) {
            intSvc.deleteInt(c.get(i));
            i++;
            }
	
            return true;
	}
                
	/** 
	 Business use case for "delete interest"
	 
	 @param c
        * @return 
	*/
	public final boolean Delete(interest c)
	{
		intSvc.deleteInt(c);
		return true;
	}

}