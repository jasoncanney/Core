package com.canopyaudience.model.services.exception;

public class SQLServiceLoadException extends RuntimeException
{
	public SQLServiceLoadException()
	{
	}

	public SQLServiceLoadException(String message)
	{
		super(message);
		System.out.println("SQLServiceLoadException" + message);

	}

	public SQLServiceLoadException(String message, RuntimeException innerException)
	{
		super(message, innerException);
		System.out.println("SQLServiceLoadException - innerException" + message);

	}

}