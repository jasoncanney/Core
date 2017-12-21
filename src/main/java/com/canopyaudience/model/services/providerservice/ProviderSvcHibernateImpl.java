/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.providerservice;

import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.services.exception.ConsumerException;
import com.canopyaudience.model.services.exception.ProviderException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
// @Repository
public class ProviderSvcHibernateImpl implements IProviderSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("ProviderSvcHibernateImpl.class");
	
 /**
  * Store provider information into the database
  * @return boolean
  */
  @Override
  public boolean storeProvider(provider provider)
        {
            boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storeProvider - ProviderSvcHibernateImpl.java");
            provider appdb  = provider;
            Transaction tx = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {    
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                log.info("consumer saved. Check database for data!");
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
            }
            return status;
       }  

    /**
     * Pulls data from database through hibernate interface
     * @return <list> of adimpression
     * @throws java.lang.ClassNotFoundException
     */
     @Override
    public List<provider> getProvider() throws ProviderException, ClassNotFoundException {
        
        {
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getProvider - ProviderSvcHibernateImpl.java");
            Transaction tx = null;
            List<provider> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = session.createQuery("from provider").getResultList();
                log.info ("session.createQuery passed");
                log.info("provider queried and put into List.");
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
            }
            return theApplications;

       }  
    }
   
    /**
     * Pulls data from database through hibernate interface
     * @param id
     * @return provider object
     * @throws java.lang.ClassNotFoundException
     */
    public provider getAProvider(int id) throws ProviderException, ClassNotFoundException {
        
        {
            
            int i = id;
            provider c = new provider();
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAProvider - ProviderSvcHibernateImpl.java");
            Transaction tx = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                c = session.get(provider.class, i);
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
            }
            return c;              
       }  
    }
  
    /**
  * Updates consumerHistory object received from GUI and put in database
  * @return boolean
  */
  @Override
  public boolean updateProvider(provider provider)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updateProvider - ProviderSvcHibernateImpl.java");
 
            // updateProvider takes in an provider object
            // this object includes the updates received and that need to be stored in the db
            provider appdb  = provider;
            // create a new provider object.  This is where the current provider object gets stored and 
            // will be used to make updates and store back in the db
            provider appnew = null;
            Transaction tx = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting provider with providerid:" + appdb.getProviderID());   
                // retrieve the current application object from the database
                appnew = session.get(provider.class, appdb.getProviderID());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setProviderName(appdb.getProviderName());
                
		System.out.println("Updating provider...");
                // provider object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                log.info("provider updated. Check database for data!");
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
            }
            return status;
       }  
     /**
     * Deletes data from database through hibernate interface
     * @param provider
     * @return boolean of applications
     */
    @Override
    public boolean deleteProvider(provider provider)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deleteProvider - ProviderSvcHibernateImpl.java");
            provider appdb  = provider;
            Transaction tx = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(provider passed in)");
                log.info("provider deleted. Check database for data not there!");
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
