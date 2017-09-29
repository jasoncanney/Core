package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/** 
*/


/** 
 @author Jason L. Canney
 
 
 
*/

public class ConsumerHistoryException extends RuntimeException
{

	/** @param serialVersionUID = unique identifier 
	 @param Throwable exception 
	 @param inMessage is a string 
	*/
	private static final long serialVersionUID = 1L;
	private static RuntimeException inNestedException;
	private static String inMessage;

	/** 
	 @param string 
	 @param ioeinMessage 
	*/
	public ConsumerHistoryException(String string, IOException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - ConsumerHistorySvcxxxImpl");
	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public ConsumerHistoryException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - ConsumerHistorySvcxxxImpl");
	}

	/** 
	 @param string 
	*/
	public ConsumerHistoryException(String string)
	{
		super(inMessage);
	}

}