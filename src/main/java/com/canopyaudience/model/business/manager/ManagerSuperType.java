package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.services.factory.Factory;
import com.canopyaudience.model.services.*;

/** 
 Used as an abstract class for the managers in the business layer
 Static code below is executed anytime any of the managers in the 
 business layer are executed that inherit this abstract class
 
 @author Jason Canney
 
*/
public abstract class ManagerSuperType
{

	private Factory factory;


	protected final IService getService(String name)
	{
		return factory.getService(name);
	}

}