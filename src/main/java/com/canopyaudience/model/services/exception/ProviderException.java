package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/** 
*/


/** 
 @author Jason L. Canney
 
 
 
*/

public class ProviderException extends RuntimeException
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
	public ProviderException(String string, IOException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - ProviderSvcxxxImpl");
	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public ProviderException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - ProviderSvcxxxImpl");
	}

	/** 
	 @param string 
	*/
	public ProviderException(String string)
	{
		super(inMessage);
	}

}