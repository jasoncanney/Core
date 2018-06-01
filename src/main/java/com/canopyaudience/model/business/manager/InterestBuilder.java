/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.domain.consumer;
import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.domain.interest;
import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Jason
 */
public class InterestBuilder {
    
        //create an instance of the preference business manager object
        preferenceManager prefmgr = new preferenceManager();
        //create an instance of the adimpression business manager object
        adImpManager admgr = new adImpManager();
        //create an instance of the interest business manager object
        intManager intmgr = new intManager();
        //create an instance of the advertisement business manager object
        adManager advertmgr = new adManager();
        // create an instance of the consumer business manager object
        consumerManager conmgr = new consumerManager();
        // create an instance of the provider business manager object
        providerManager provmgr = new providerManager();
        
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("InterestBuilder.class");
        
        /** 
	 Business use case for "Build Interests"
        * @param id	 
        * @return 	 
        * @throws java.lang.ClassNotFoundException	 
	*/
	public final boolean BuildNewInterestsForAUser(int id) throws PreferenceException, ClassNotFoundException
	{
                int i = id;
                int count = 0;                                                          // counter for main algorithm loop
                int weight = 0;                                                         // weight counter for updating interest weights in main algorithm
                String adPCC;
                preference p = new preference();                                        // create new preference object
                interest r = new interest();                                            // create new interest object
                adimpression a = new adimpression();                                    // create new adimpression object
                advertisement advert = new advertisement();                             // create new advertisement object
                consumer con = new consumer();                                          // create new consumer object
                provider prov = new provider();                                         // create a new provider object
                
                List<preference> thePreferences = null;
                List<adimpression> theAdImpressions = null;
                List<interest> theInterests = null;
                List<advertisement> theAdvertisements = null;

		thePreferences = prefmgr.GetAList(id);
                log.info (thePreferences);
                theAdImpressions = admgr.GetAList(id);
                log.info (theAdImpressions);
                theInterests = intmgr.GetA(id);                                         // Retrieve all interests for this user from the database
                intmgr.DeleteAllRecos(theInterests);                                    // Delete current interests for this user from the database Note: List still exists and will be restored to the DB at the end of this class
                log.info (theInterests);
                theAdvertisements = advertmgr.Get();
                con = conmgr.GetA(id);                                                  // Retrieve consumer object for this user from the database
                prov = provmgr.GetA(id);                                                // Retrieve provider object for this user from the database
                
                // Start of main patent algorithm to build weighted interests
                // Leverages preferences + machine learning to build intelligent interests
                // for individual consumers
                
                while (count < thePreferences.size()) {                                 // start of main canopy audience interest weighting loop - patent logic
                   p = thePreferences.get(count);                                       // pull out current preference for using in algorithm 
                   advert = theAdvertisements.get(p.getAdvertisementID());              // pull advertisement object from list to get to PCC value
                   adPCC = advert.getAdPCC();                                           // store PCC value 
                   if (p.getPreferenceChoice()==1){                                     // If current preference is positive then
                       // start of function.  Pass in weight value of 1, 1.  For next function you'll pass in weight of -1 and -2 
                       if (theInterests.contains(p.getAdvertisementID())){              // if current Recommendations list contains preference AdID then
                           r = theInterests.get(p.getAdvertisementID());                // pull that interest with the matching AdID into a interest domain object
                           weight =  r.getIntWeight();                                  // get current weight of interest
                           weight++;                                                    // increment interest weight +1
                           r.setIntWeight(weight);                                      // store the weight back in the interest object
                           theInterests.set(count, r);                                  // replace the previous interest with the updated weighted interest
                           // adimpression logic check section
                           if (theAdImpressions.contains(adPCC)){
                               r = theInterests.get(p.getAdvertisementID());            // pull that interest with the matching AdID into a interest domain object
                               weight =  r.getIntWeight();                              // get current weight of interest
                               weight++;                                                // increment interest weight +1
                               r.setIntWeight(weight);                                  // store the weight back in the interest object
                               theInterests.set(count, r);                              // replace the previous interest with the updated weighted interest
                            }  
                        }
                       else {
                           // Build the Recommendation to Create
                           // ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                           // Date now = Date.from(Instant.MIN);
                           r.setIntDate(System.currentTimeMillis());                                // Current date stamp
                           r.setIntWeight(1);
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(con.getProviderID());                                    // Retrieves Provider ID based on current consumer ID
                           r.setProviderName(prov.getProviderName());                               // Retrieves Provider name based on individual consumer ID
                           r.setLocationZip(con.getDeviceLocID());                                  // Retrieves Device Location ID stored in consumer object
                           r.setDemographic(con.getDemoID());                                       // Retrieves demographic identifier stored in consumer object
                           r.setAdID(advert.getAdID());
                           r.setAdPCC(advert.getAdPCC());
                           r.setAdURL(advert.getAdURL());
                           r.setAdOwner(advert.getAdowner());
                           // Add the Recommendation to the List
                           theInterests.add(r);
                        }
                   // end of function
                   }
                   if(p.getPreferenceChoice()==0){                                      // If current preference is negative then
                       if (theInterests.contains(p.getAdvertisementID())){              // if current Recommendations list contains preference AdID then
                           r = theInterests.get(p.getAdvertisementID());                // pull that interest with the matching AdID into a interest domain object
                           weight =  r.getIntWeight();                                  // get current weight of interest
                           weight--;                                                    // decrement interest weight -1
                           r.setIntWeight(weight);                                      // store the weight back in the interest object
                           theInterests.set(count, r);                                  // replace the previous interest with the updated weighted interest
                       // adimpression logic check section
                       if (theAdImpressions.contains(adPCC)){
                           r = theInterests.get(p.getAdvertisementID());                // pull that interest with the matching AdID into a interest domain object
                           weight =  r.getIntWeight();                                  // get current weight of interest
                           weight = weight -2;                                          // decrementcrement interest weight -2 
                           r.setIntWeight(weight);                                      // store the weight back in the interest object
                           theInterests.set(count, r);                                  // replace the previous interest with the updated weighted interest 
                        } 
                        else {
                           // Build the Recommendation to Create
                           // Date now = Date.from(Instant.MIN);
                           r.setIntDate(System.currentTimeMillis());                                                      // Current date stamp                           
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(con.getProviderID());                                    // Retrieves Provider ID based on current consumer ID
                           r.setProviderName(prov.getProviderName());                               // Retrieves Provider name based on individual consumer ID
                           r.setLocationZip(con.getDeviceLocID());                                  // Retrieves Device Location ID stored in consumer object
                           r.setDemographic(con.getDemoID());                                       // Retrieves demographic identifier stored in consumer object
                           r.setAdID(advert.getAdID());
                           r.setAdPCC(advert.getAdPCC());
                           r.setAdURL(advert.getAdURL());
                           r.setAdOwner(advert.getAdowner());
                           // Add the Recommendation to the List
                           theInterests.add(r);
                            }
                        } 
                    // 
                    }
                count++;
            }
                // Store all interests back into the list
                intmgr.StoreAllInts(theInterests);                               // Note: original interests for this user were deleted from the DB above.  there will be no update conflict
            
            return true;
                   
    }
}
