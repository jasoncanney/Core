/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.interestservice;

import com.canopyaudience.model.domain.interest;
import com.canopyaudience.model.services.exception.IntException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Jason
 */
public class IntSvcHibernateImpl implements IIntSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("IntSvcHibernateImpl.class");
	
 /**
  * Set interest data received from GUI and put in database
  * @return boolean
  */
 
  public boolean storeInt(interest interest)
        {
          boolean status = true;
          Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storeInt - IntSvcHibernateImpl.java");
            interest appdb  = interest;
            Session session = fetchSession();
            log.info ("fetched session");
                  
            try 
            {    
                tx = session.beginTransaction();
                log.info(appdb.toString());
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                tx.commit();
                log.info("interest saved. Check database for data!");
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
     * @return <list> of interest
     * @throws java.lang.ClassNotFoundException
     */
    public List<interest> getInt() throws IntException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getInt - IntSvcHibernateImpl.java");
            List<interest> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = session.createQuery("from interest").getResultList();
                log.info ("session.createQuery passed");
                tx.commit();
                log.info("interest queried and put into List.");
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
     * Pulls single interest from database through hibernate interface
     * @return interest
     * @throws java.lang.ClassNotFoundException
     */
    public List<interest> getAInt(int id) throws IntException, ClassNotFoundException {
        
        {
            int i = id;
            List<interest> theApplications = null;
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAInt - IntSvcHibernateImpl.java");
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            { 
                tx=session.beginTransaction();
                log.info ("beginTransaction");
                String hql = "from interest where consumerID = :id";   
                // System.out.println(hql);
                Query query = session.createQuery(hql);
                query.setParameter("id", i);
                List result = query.list();
                tx.commit();
                log.info("outputting the resultset to system.out.println");
                System.out.println("resultset:"+result);
                theApplications = result;
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
     * @return <list> of interest
     * @throws java.lang.ClassNotFoundException
     * @throws org.apache.mahout.cf.taste.common.TasteException
     */
    @Override
    public AbstractJDBCDataModel getMahoutInterest() throws IntException, ClassNotFoundException, TasteException {
        {
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getMahoutInterest - IntSvcHibernateImpl.java");
            AbstractJDBCDataModel theApplications = new MySQLJDBCDataModel();
            Session session = fetchSession();
            log.info ("fetched session");
            try 
            {
                Transaction tx = session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = (AbstractJDBCDataModel) session.createQuery("ConsumerID, IntWeight, AdID from interest").getResultList();
                log.info ("session.createQuery passed");
                log.info("interest queried and put into List.");
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
    * Updates interest object received from GUI and put in database
    * @return boolean
    */
  public boolean updateInt(interest interest)
        {
            boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("updateInt - IntSvcHibernateImpl.java");
            // updateApplication takes in an interest object
            // this object includes the updates received and that need to be stored in the db
            interest appdb  = interest;
            // create a new interest object.  This is where the current interest object gets stored and 
            // will be used to make updates and store back in the db
            interest appnew = null;
            Session session = fetchSession();  
            log.info ("fetched session");
            
            try 
            {
                Transaction tx = session.beginTransaction();
                log.info(appdb.toString());
                log.info ("beginTransaction, Getting interest with recoID:" + appdb.getIntID());
                // retrieve the current interest object from the database
                appnew = session.get(interest.class, appdb.getIntID());
                // update all fields in the current interest object except the PK of RecoID  
                
                appnew.setIntDate(appdb.getIntDate());
                appnew.setIntWeight(appdb.getIntWeight());
                appnew.setConsumerId(appdb.getConsumerId());
                appnew.setProviderId(appdb.getProviderId());
                appnew.setProviderName(appdb.getProviderName());
                appnew.setLocationZip(appdb.getLocationZip());
                appnew.setDemographic(appdb.getDemographic());
                appnew.setAdID(appdb.getAdID());
                appnew.setAdURL(appdb.getAdURL());
                appnew.setAdPCC(appdb.getAdPCC());
                appnew.setAdOwner(appdb.getAdOwner());

                log.info(appnew.toString());
		System.out.println("Updating interest...");
                // interest object is updated in the db based on the Primary Key that was unchanged
                session.saveOrUpdate(appnew);
                tx.commit();
                //session.update(appnew);
                log.info("interest updated. Check database for data!");
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
     * @param interest
     * @return boolean of interest
     */
    public boolean deleteInt(interest interest)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deleteInt - IntSvcHibernateImpl.java");
            interest appdb  = interest;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                Transaction tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(interest passed in)");
                log.info("interest deleted. Check database for data not there!");
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
                // tx.commit;
                // added this line to fix session closing
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
