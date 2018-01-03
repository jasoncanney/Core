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
import org.hibernate.query.Query;

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
  * Set myads data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storemyAds(myads myads)
        {
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storemyAds - myAdSvcHibernateImpl.java");
            myads appdb  = myads;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                log.info(appdb.toString());               
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                log.info("myads saved. Check database for data!");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
                status = true;
            }
            return status;
       }  
        
    /**
     * Pulls data from database through hibernate interface
     * @return <list> of myads
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<myads> getmyAds() throws myAdsException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getmyAds - myAdSvcHibernateImpl.java");
            List<myads> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                // query myads
                theApplications = session.createQuery("from myads").getResultList();
                log.info ("session.createQuery passed");
                // For logging what is in the List
                displaymyAds(theApplications);
                log.info("myads queried and put into List.");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }     
            finally{
                session.close();    
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
            Transaction tx;
            int i = id;  
            List<myads> theApplications = null;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAmyAds - myAdSvcHibernateImpl.java");
            // Use the Hibernate factory to get a session
            Session session = fetchSession();
            log.info ("fetched session");

            try {
                tx = session.beginTransaction();
                log.info ("beginTransaction");          
                String hql = "from myads where consumerID = :id";   
                System.out.println(hql);
                Query query = session.createQuery(hql);
                query.setParameter("id", i);
                List result = query.list();
                tx.commit();
                System.out.println("resultset:"+result);
                theApplications = result;
                
            } catch (Exception e) {
        
                if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
    
            } finally {
                session.close();
            }    
          return theApplications;        
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
            Transaction tx;
            boolean status = false;
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
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
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
                tx.commit();
                log.info("advertisement updated. Check database for data!");
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            
            }finally 
            {
                session.close();
                status = true;
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
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deletemyAds - myAdSvcHibernateImpl.java");
            myads appdb  = myads;
            Session session = fetchSession();
            log.info ("fetched session");

            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(myads passed in)");
                log.info("myads deleted. Check database for data not there!");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                
              } 
            }
            finally{
                session.close();                                                 // added this line to fix session closing
                status = true;
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
