package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.couponservice.ICouponSvc;
import com.canopyaudience.model.services.exception.CouponException;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class couponManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        ICouponSvc coupSvc = (ICouponSvc)context.getBean("ICouponSvc");
        
	/** 
	 Business use case for "store coupon"
	 
	 @param c
	*/
	public final boolean Create(coupon c)
	{
		// Factory factory = Factory.getInstance();
		// ICouponSvc coupSvc = (ICouponSvc)factory.getService("ICouponSvc");
		coupSvc.storeCoupon(c);
		return true;
	}

	/** 
	 Business use case for "retrieve coupon list"
	 
	 @param id
	 @return Set<coupon>
	*/
	public final Set<coupon> Get() throws CouponException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// ICouponSvc coupSvc = (ICouponSvc)factory.getService("ICouponSvc");
		return coupSvc.getCoupon();
	}
  
	/** 
	 Business use case for "update coupon"
	 
	 @param c
	*/
	public final boolean Update(coupon c)
	{
		// Factory factory = Factory.getInstance();
		// ICouponSvc coupSvc = (ICouponSvc)factory.getService("ICouponSvc");
		coupSvc.updateCoupon(c);
		return true;

	}

	/** 
	 Business use case for "delete coupon"
	 
	 @param c
	*/
	public final boolean Delete(coupon c)
	{
		// Factory factory = Factory.getInstance();
		// ICouponSvc coupSvc = (ICouponSvc)factory.getService("ICouponSvc");
		coupSvc.deleteCoupon(c);
		return true;
	}

}