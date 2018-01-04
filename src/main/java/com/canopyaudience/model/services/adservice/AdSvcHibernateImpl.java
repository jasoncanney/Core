/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adservice;

import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.services.exception.AdvertisementException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class AdSvcHibernateImpl implements IAdSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("AdSvcHibernateImpl.class");
	
 /**
  * Set adimpression data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storeAdvertisement(advertisement advertisement)
        {
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storeAdvertisement - AdSvcHibernateImpl.java");
            advertisement appdb  = advertisement;
            Session session = fetchSession();
            log.info ("fetched session");

            try 
            {
                log.info(appdb.toString());
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                tx.commit();
                log.info("advertisement saved. Check database for data!");
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
     * @return <list> of adimpression
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<advertisement> getAdvertisement() throws AdvertisementException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAdvertisement - AdSvcHibernateImpl.java");            
            List<advertisement> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                // query students
                theApplications = session.createQuery("from advertisement").getResultList();
                log.info ("session.createQuery passed");
                // For logging what is in the List
                // displayAdvertisements(theApplications);
                tx.commit();
                log.info("advertisement queried and put into List.");
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
            }
            return theApplications;
       }  
    }
    
    /**
     * Pulls an advertisement data from database through hibernate interface
     * @param id
     * @return advertisement
     * @throws java.lang.ClassNotFoundException
     */
    public advertisement getAAdvertisement(int id) throws AdvertisementException, ClassNotFoundException {
        
        {
            
            int i = id;
            advertisement c = new advertisement();
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAdvertisement - AdSvcHibernateImpl.java");
            List<advertisement> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                c = session.get(advertisement.class, i);
                tx.commit();
                log.info("advertisement  for one id queried and put into List.");
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
            }
            return c;
       }  
    }
    
  /**
  * Updates Application object received from GUI and put in database
  * @param adimpression
  * @return boolean
  */
  @Override
  public boolean updateAdvertisement(advertisement advertisement)
        {
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("updateAdvertisement - AdSvcHibernateImpl.java");
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            advertisement appdb  = advertisement;
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            advertisement appnew = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            { 
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting advertisement with adID:" + appdb.getAdID());   
                // retrieve the current application object from the database
                appnew = session.get(advertisement.class, appdb.getAdID());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setAdtitle(appdb.getAdtitle());
                appnew.setAddemo01(appdb.getAddemo01());
                appnew.setAddemo02(appdb.getAddemo02());
                appnew.setAddemo03(appdb.getAddemo03());
                appnew.setAddemo04(appdb.getAddemo04());
                appnew.setAddescription(appdb.getAddescription());
                appnew.setAdowner(appdb.getAdowner());
                appnew.setAdbrand(appdb.getAdbrand());
                appnew.setAdPCC(appdb.getAdPCC());
                appnew.setAdURL(appdb.getAdURL());
                appnew.setAdCampID(appdb.getAdCampID());
		System.out.println("Updating advertisement...");
                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
		// commit the transaction
		tx.commit();
                log.info("advertisement updated. Check database for data!");
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
     * Deletes data from database through hibernate interface
     * @return boolean of applications
     */
    @Override
    public boolean deleteAdvertisement(advertisement advertisement)
        {
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deleteAdvertisement - AdSvcHibernateImpl.java");
            advertisement appdb  = advertisement;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {    
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(advertisement passed in)");
                tx.commit();
                log.info("advertisement deleted. Check database for data not there!");
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
        
        private static void displayAdvertisements(List<advertisement> theAdvertisements) {
		for (advertisement tempAdvertisement : theAdvertisements) {
			log.info(tempAdvertisement);
		}
	}

}// end class AdImpressionSvcHibernateImpl
