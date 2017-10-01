package com.canopyaudience.model.services.couponservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.CouponException;
import java.util.List;

/** 
 This interface defines methods for persisting of coupon.cs
 to and from a file system
 @author Jason L. Canney 
 @param NAME is a string used to identify the service
  
*/
public interface ICouponSvc extends IService
{
	/** 
	 Persists a coupon
	 The storeCoupon takes in a coupon object as input and will pass it to the CouponSvcSQLImpl 
	 @param coupon The coupon to be persisted 
	 @return  boolean true/false 
	 @exception CouponException  
	*/
	public boolean storeCoupon(coupon coupon);

	/** 
	 Retrieves a coupon
	 The getCoupon takes an ID as an argument and retrieves it through the CouponSvcSQLImpl class 
	 @param none The unique identifier for the coupon to be retrieved 
	 @return  The collection 
	 @exception CouponException 
	 @exception ClassNotFoundException  
	*/
	public List<coupon> getCoupon()throws CouponException, ClassNotFoundException;

	/** 
	 Updates a coupon
	 The updateCoupon takes in a coupon object as input and will pass it to the CouponSvcImpl 
	 @param coupon The consumer to be updated
	 @return  void 
	 @exception CouponException  
	*/
	public boolean updateCoupon(coupon coupon);

	/** 
	 delete a coupon
	 The deleteCoupon takes in a coupon object as input and will pass it to the CouponSvcImpl 
	 @param coupon The consumer to be updated
	 @return  void 
	 @exception CouponException  
	*/
	public boolean deleteCoupon(coupon coupon);
}