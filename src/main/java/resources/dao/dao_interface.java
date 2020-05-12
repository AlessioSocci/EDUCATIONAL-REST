package resources.dao;

import java.util.List;

import resource.entity.Contact;

public interface dao_interface 
{
	// CRUD operations
	
	// CREATE
	public Contact addContact(Contact contact) throws daoException;
	
	// READ
	public List<Contact> findAll() throws daoException;
	public List<Contact> findById(int id) throws daoException;
	public List<Contact> findByCountry(String country) throws daoException;
	public List<Contact> findByCity(String city) throws daoException;
	
	// UPDATE
	public Contact updateContact(int id, Contact contact) throws daoException;
	
	// DELETE
	public String deleteContact(int id) throws daoException;
}
