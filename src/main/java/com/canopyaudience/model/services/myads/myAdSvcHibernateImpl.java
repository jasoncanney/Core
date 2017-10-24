/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.myads;

import com.canopyaudience.model.domain.myads;
import com.canopyaudience.model.services.exception.myAdsException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class myAdSvcHibernateImpl implements ImyAdSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("myAdSvcHibernateImpl.class");
	
 /**
  * Set adimpression data received from GUI and put in database
  * @return boolean
  */
 
        @Override
  public boolean storemyAds(myads myads)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storemyAds - myAdSvcHibernateImpl.java");
 
            myads appdb  = myads;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info(appdb.toString());
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                session.getTransaction().commit();                               // added this line to fix session closing
                session.close();                                                 // added this line to fix session closing
                log.info("myads saved. Check database for data!");
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     //tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
         
	
    
    /**
     * Pulls data from database through hibernate interface
     * @return <list> of adimpression
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<myads> getmyAds() throws myAdsException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getmyAds - myAdSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<myads> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query myads
                theApplications = session.createQuery("from myads").getResultList();
                log.info ("session.createQuery passed");
                // For logging what is in the List
                // displayAdvertisements(theApplications);
                session.close();    
                log.info("myads queried and put into List.");
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     //tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }     
            return theApplications;
       }  
    }
    
    
    /**
     * Pulls an all myads for a single consumerID from database through hibernate interface
     * @param id
     * @return advertisement
     * @throws java.lang.ClassNotFoundException
     */
    public List<myads> getAmyAds(int id) throws myAdsException, ClassNotFoundException {
        
        {
            
            int i = id;
            // myads c = new myads();
            
            
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getAmyAds - myAdSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<myads> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = session.createQuery("SELECT * FROM myads WHERE consumerID = id").setParameter("id", id).getResultList();
                // c = session.get(myads.class, i);
                session.close();   
                
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     //tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }     
            return theApplications;
            // return c;
       }  
    }
    
  /**
  * Updates myads object received from GUI and put in database
  * @param myads
  * @return boolean
  */
  @Override
  public boolean updatemyAds(myads myads)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updatemyAds - myAdSvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            myads appdb  = myads;

            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            myads appnew = null;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting myads with IDentifier:" + appdb.getIDentifier());
                
                // retrieve the current application object from the database
                appnew = session.get(myads.class, appdb.getIDentifier());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setConsumerID(appdb.getConsumerID());
                appnew.setAdID(appdb.getAdID());
                appnew.setAdURL(appdb.getAdURL());
                appnew.setAdPCC(appdb.getAdPCC());
                appnew.setAdtitle(appdb.getAdtitle());
                appnew.setAddescription(appdb.getAddescription());
                appnew.setAdowner(appdb.getAdowner());
                appnew.setCouponID(appdb.getCouponID());
                appnew.setCouponURL(appdb.getCouponURL());
                appnew.setCouponTitle(appdb.getCouponTitle());
                appnew.setCouponDescription(appdb.getCouponDescription());
                appnew.setCouponValue(appdb.getCouponValue());
                appnew.setAdCampID(appdb.getAdCampID());
	
		System.out.println("Updating myads...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                
                // tx.commit();
                session.close();                                                 // added this line to fix session closing

                log.info("advertisement updated. Check database for data!");
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     //tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
     /**
     * Deletes data from database through hibernate interface
     * @return boolean of applications
     */
    @Override
    public boolean deletemyAds(myads myads)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deletemyAds - myAdSvcHibernateImpl.java");
 
            myads appdb  = myads;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(myads passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                // tx.commit();
                log.info("myads deleted. Check database for data not there!");
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
        
        private static void displaymyAds(List<myads> theAdvertisements) {
            theAdvertisements.forEach((tempAdvertisement) -> {
                log.info(tempAdvertisement);
            });
	}

}// end class AdImpressionSvcHibernateImpl
