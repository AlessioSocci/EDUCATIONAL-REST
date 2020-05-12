package resources.object;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import resource.entity.Contact;
import resources.dao.daoException;
import resources.dao.daoFactory;
import resources.dao.dao_interface;

@Path("/resources")
public class Resources 
{
	private dao_interface dao;
		
	public Resources() throws daoException
	{
		dao = daoFactory.getDao_interface();
	}
	
	// CREATE
	@Path("/create")
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewContact(Contact contact) throws daoException 
	{
		contact = dao.addContact(contact);
		
		return Response.ok(contact).build();
	}
	
	// READ
	@Path("/find")
	@GET
	@Produces({"application/json"})
	public Response getAllContact() throws daoException
	{
		return Response.ok(dao.findAll()).build();
	}
	
	@Path("/find/id/{contacts_id}")
	@GET
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response getContactById(@PathParam("contacts_id") Integer id) throws daoException
	{
		return Response.ok(dao.findById(id)).build();
	}
	
	@Path("/find/city/{contacts_city}")
	@GET
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response getContactByCity(@PathParam("contacts_city") String city) throws daoException
	{
		return Response.ok(dao.findByCity(city)).build();
	}
	
	
	@Path("/find/country/{contacts_country}")
	@GET
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response getContactByCountry(@PathParam("contacts_country") String country) throws daoException
	{
		return Response.ok(dao.findByCountry(country)).build();
	}

	// UPDATE
	@Path("/update/{contact_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateContact(@PathParam("contact_id") Integer id, Contact contact) throws daoException 
	{
		contact.setContact_id(id);
		contact = dao.updateContact(id, contact);
		
		return Response.ok(contact).build();
	}
	
	//DELETE
	@Path("/delete/{contact_id}")
	@DELETE
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response deleteContact(@PathParam("contact_id") Integer id) throws daoException 
	{
		return Response.ok(dao.deleteContact(id)).build();
	}
	
}
