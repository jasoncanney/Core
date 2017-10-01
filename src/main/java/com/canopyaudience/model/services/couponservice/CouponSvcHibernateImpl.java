/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.couponservice;

import com.canopyaudience.model.domain.coupon;
import com.canopyaudience.model.services.exception.CouponException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class CouponSvcHibernateImpl implements ICouponSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("CouponSvcHibernateImpl.class");
	
 /**
  * Set coupon data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storeCoupon(coupon coupon)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeCoupon - CouponSvcHibernateImpl.java");
 
            coupon appdb  = coupon;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                session.getTransaction().commit();    
                log.info("coupon saved. Check database for data!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  

    /**
     * Pulls data from database through hibernate interface
     * @return <list> of coupon
     * @throws java.lang.ClassNotFoundException
     */
        @Override
    public List<coupon> getCoupon() throws CouponException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getCoupon - CouponSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<coupon> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from coupon").getResultList();
                log.info ("session.createQuery passed");
                session.close();   
                log.info("coupon queried and put into List.");
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }     
            return theApplications;
       }  
    }
    /**
  * Updates coupon object received from GUI and put in database
  * @return boolean
  */
  @Override
  public boolean updateCoupon(coupon coupon)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updateCoupon - CouponSvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            coupon appdb  = coupon;
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            coupon appnew = null;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting coupon with couponid:" + appdb.getCouponID());
                
                // retrieve the current application object from the database
                appnew = session.get(coupon.class, appdb.getCouponID());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setCouponTitle(appdb.getCouponTitle());
                appnew.setCouponDescription(appdb.getCouponDescription());
                appnew.setCouponValue(appdb.getCouponValue());
                appnew.setCouponStartActive(appdb.getCouponStartActive());
                appnew.setCouponEndActive(appdb.getCouponEndActive());
                appnew.setCouponLocationsZip(appdb.getCouponLocationsZip());

		System.out.println("Updating coupon...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                
                log.info("coupon updated. Check database for data!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
     /**
     * Deletes data from database through hibernate interface
     * @param coupon
     * @return boolean of applications
     */
    @Override
    public boolean deleteCoupon(coupon coupon)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deleteCoupon - CouponSvcHibernateImpl.java");
 
            coupon appdb  = coupon;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(coupon passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                log.info("coupon deleted. Check database for data not there!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
    /**
	 * Gets a hibernate session from HibernateFactory
	 * 
	 * @return org.hibernate.Session
	 * 
	 */
	private Session fetchSession()
	{
			log.info ("******Fetching Hibernate Session");

			Session session = HibernateFactory.currentSession();

			return session;
	    
	} //end fetchConnection

}// end class AdImpressionSvcHibernateImpl
