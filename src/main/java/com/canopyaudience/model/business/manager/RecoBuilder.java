/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.domain.recommendation;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Jason
 */
public class RecoBuilder {
    
        // create reference to the actual config file
        // ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        
        //create an instance of the preference business manager object
        preferenceManager prefmgr = new preferenceManager();
        //create an instance of the adimpression business manager object
        adImpManager admgr = new adImpManager();
        //create an instance of the recommendation business manager object
        recoManager recmgr = new recoManager();
        
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("RecoBuilder.class");
        
        /** 
	 Business use case for "Build Recommendations"
        * @param id	 
        * @return 	 
        * @throws java.lang.ClassNotFoundException	 
	*/
	public final boolean BuildNewRecsForAUser(int id) throws PreferenceException, ClassNotFoundException
	{
                int i = id;
                List<preference> thePreferences = null;
                List<adimpression> theAdImpressions = null;
                List<recommendation> theRecommendations = null;

		thePreferences = prefmgr.GetAList(id);
                log.info (thePreferences);
                theAdImpressions = admgr.GetAList(id);
                log.info (theAdImpressions);
                theRecommendations = recmgr.GetA(id);
                log.info (theRecommendations);
                
                int count = 0;
                int weight = 0;
                preference p = new preference();
                recommendation r = new recommendation();
                adimpression a = new adimpression();
                
                
                
                
                while (count < thePreferences.size()) {
              
                   // pull out current preference for using in algorithm 
                   p = thePreferences.get(count);
                   if (p.getPreferenceChoice()==1){                                      // If current preference is positive then
                       if (theRecommendations.contains(p.getAdvertisementID())){        // if current Recommendations list contains preference AdID then
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight++;                                                    // increment recommendation weight +1
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation
                       }
                       if(p.getPreferenceChoice()==0){
                           
                           // update this section to match algorithm
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight++;                                                    // increment recommendation weight +1
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation
                           
                           
                           
                       } else {
                          // if (p.)   // put logic here to see if there is a matching ad impression to the AdID / AdPCC in adimpressions data set
                           
                       }
                   } 
                    
                
                    // Is thePreference[count] positive or negative
                    // Does thePreferences[count] exist in theRecommendations list
                    // If yes and If preference positive, increment theRecommendations weight value +1
                    // If yes and if preference negative, decrement theRecommendation weight -2
                    // If no and If preference positive, add new recommendation with a negative weighting
                    
                    // for thePreference[count].advertisementID, Look-up adPCC in advertisement table
                    // does consumerID + adPCC exist in theAdImpressions
                    // If yes and preference positive, increment theRecommendations weight value +1
                    // If yes and preference negative, decrement theRecommendation weight -2 
                    
                    // Store recommendations to database
                    
                    count++;
                }
                
                
                
                
                
                
                
		return true;
	}
        
        
        
    
    
}
