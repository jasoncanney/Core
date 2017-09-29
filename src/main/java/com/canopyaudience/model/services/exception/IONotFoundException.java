package com.canopyaudience.model.services.exception;

/** 
*/

public class IONotFoundException extends RuntimeException
{
	public IONotFoundException()
	{
	}

	public IONotFoundException(String message)
	{
		super(message);
	}

	public IONotFoundException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}

}