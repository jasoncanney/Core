/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.loginservice;

import com.canopyaudience.model.domain.login;
import com.canopyaudience.model.services.exception.LoginException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class LoginSvcHibernateImpl implements ILoginSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("LoginSvcHibernateImpl.class");
	
 /**
  * Set login data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storeLogin(login login)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeLogin - LoginSvcHibernateImpl.java");
 
            login appdb  = login;
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
                log.info("login saved. Check database for data!");
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
     * @return <list> of login
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<login> getLogin() throws LoginException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getLogin - LoginSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<login> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from login").getResultList();
                log.info ("session.createQuery passed");
                session.close();  
                log.info("login queried and put into List.");
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
  * Updates login object received from GUI and put in database
  * @return boolean
  */
  @Override
  public boolean updateLogin(login login)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updateLogin - LoginSvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            login appdb  = login;
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            login appnew = null;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting login with userName:" + appdb.getuserName());
                
                // retrieve the current application object from the database
                appnew = session.get(login.class, appdb.getuserName());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setpassWord(appdb.getpassWord());
                

		System.out.println("Updating login...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                log.info("login updated. Check database for data!");
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
     * @param login
     * @return boolean of applications
     */
    @Override
    public boolean deleteLogin(login login)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deleteLogin - LoginSvcHibernateImpl.java");
 
            login appdb  = login;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(login passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                log.info("login deleted. Check database for data not there!");
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
