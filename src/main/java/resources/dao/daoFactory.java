package resources.dao;

import resource.entity.Contact;

public final class daoFactory 
{
	private static final String IMPL_TYPE = "jdbc";
	
	private daoFactory()
	{
		
	}
	
	public static dao_interface getDao_interface() throws daoException
	{
		switch(IMPL_TYPE)
		{
			case "jdbc" :
				
				return new dao();
			
			default: 
				
				throw new daoException("no implementation");
		}
	}
}
