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
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeAdvertisement - AdSvcHibernateImpl.java");
 
            advertisement appdb  = advertisement;
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
                log.info("advertisement saved. Check database for data!");
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
    public List<advertisement> getAdvertisement() throws AdvertisementException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getAdvertisement - AdSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<advertisement> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from advertisement").getResultList();
                log.info ("session.createQuery passed");
                // For logging what is in the List
                // displayAdvertisements(theApplications);
                session.close();    
                log.info("advertisement queried and put into List.");
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
     * Pulls an advertisement data from database through hibernate interface
     * @param id
     * @return advertisement
     * @throws java.lang.ClassNotFoundException
     */
    public advertisement getAAdvertisement(int id) throws AdvertisementException, ClassNotFoundException {
        
        {
            
            int i = id;
            advertisement c = new advertisement();
            
            
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getAdvertisement - AdSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<advertisement> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                c = session.get(advertisement.class, i);
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
          boolean status = true;
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
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting advertisement with adID:" + appdb.getadId());
                
                // retrieve the current application object from the database
                appnew = session.get(advertisement.class, appdb.getadId());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setadTitle(appdb.getadTitle());
                appnew.setadDemo01(appdb.getadDemo01());
                appnew.setadDemo02(appdb.getadDemo02());
                appnew.setadDemo03(appdb.getadDemo03());
                appnew.setadDemo04(appdb.getadDemo04());
                appnew.setadDescription(appdb.getadDescription());
                appnew.setadOwner(appdb.getadOwner());
                appnew.setadBrand(appdb.getadBrand());
                appnew.setadPcc(appdb.getadPcc());
                appnew.setadUrl(appdb.getadUrl());
                appnew.setadCampId(appdb.getadCampId());
	
		System.out.println("Updating advertisement...");

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
    public boolean deleteAdvertisement(advertisement advertisement)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deleteAdvertisement - AdSvcHibernateImpl.java");
 
            advertisement appdb  = advertisement;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(advertisement passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                // tx.commit();
                log.info("advertisement deleted. Check database for data not there!");
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
        
        private static void displayAdvertisements(List<advertisement> theAdvertisements) {
		for (advertisement tempAdvertisement : theAdvertisements) {
			log.info(tempAdvertisement);
		}
	}

}// end class AdImpressionSvcHibernateImpl
