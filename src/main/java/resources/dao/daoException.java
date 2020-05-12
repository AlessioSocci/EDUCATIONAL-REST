package resources.dao;

public class daoException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public daoException() 
	{
		super();
	}

	public daoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) 
	{
		super(arg0, arg1, arg2, arg3);
	}

	public daoException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
	}

	public daoException(String arg0) 
	{
		super(arg0);
	}

	public daoException(Throwable arg0) 
	{
		super(arg0);
	}

}
