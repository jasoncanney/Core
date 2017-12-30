/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Logger;

/**
 *
 * @author Jason
 */
class DateAndTimeDeserialize extends JsonDeserializer<Date> {
    
    private SimpleDateFormat dateFormat;
    // private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("DateAndTimeDeserialize.class");
    
    public DateAndTimeDeserialize() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
        
        String date = paramJsonParser.getText().trim();
        
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            log.info ("Unable to deserialize timestamp: " + date, e);
            throw new RuntimeException(e); 
        }
        // return paramDeserializationContext.parseDate(str);
    }
}
