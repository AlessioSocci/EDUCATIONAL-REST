package resources.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resource.entity.Contact;
import resource.utils.DButils;

public class dao implements dao_interface
{
	
	// CREATE
	@Override
	public Contact addContact(Contact contact) throws daoException 
	{
		String sql = "INSERT INTO contacts(contact_id, name, gender, email, phone, city, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql))
		{
//			ResultSet key = stm.getGeneratedKeys();
//			
//			key.next();
//			
//			stm.setInt(1,  key.getInt(1));
			
//			contact.setContact_id(key.getInt(1));
			
			stm.setInt(1, contact.getContact_id());
			stm.setString(2, contact.getName());
			stm.setString(3, contact.getGender());
			stm.setString(4, contact.getEmail());
			stm.setString(5, contact.getPhone());
			stm.setString(6, contact.getCity());
			stm.setString(7, contact.getCountry());
			
			stm.executeUpdate();
			
			stm.close();
			con.close();
			
			return contact;
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
	}
	
	// READ
	@Override
	public List<Contact> findAll() throws daoException
	{
		String sql = "SELECT * FROM contacts";
		
		List<Contact> list = new ArrayList<>();
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery();)
		{
			while(rs.next()) 
			{
				Contact c = new Contact();
				c.setContact_id(rs.getInt("contact_id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				
				list.add(c);
			}
			
			stm.close();
			rs.close();
			con.close();
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
		
		return list;
	}
	
	@Override
	public List<Contact> findById(int id) throws daoException 
	{
		String sql = "SELECT * FROM contacts WHERE contact_id = ?";
		
		List<Contact> list = new ArrayList<>();
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql);)
		{
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) 
			{
				Contact c = new Contact();
				c.setContact_id(rs.getInt("contact_id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				
				list.add(c);
			}
			
			System.out.println("records finded");
	
			rs.close();
			stm.close();
			con.close();
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
		
		return list;
	}

	@Override
	public List<Contact> findByCountry(String country) throws daoException 
	{
		String sql = "SELECT * FROM contacts WHERE country =  ?";
		
		List<Contact> list = new ArrayList<>();
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql);)
		{	
			stm.setString(1, country);
		
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) 
			{
				Contact c = new Contact();
				c.setContact_id(rs.getInt("contact_id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				
				list.add(c);
			}
			
			System.out.println("records finded");
			
			rs.close();
			stm.close();
			con.close();
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
		
		return list;
	}
	
	@Override
	public List<Contact> findByCity(String city) throws daoException 
	{
		String sql = "SELECT * FROM contacts WHERE city = ?";
		
		List<Contact> list = new ArrayList<>();
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql);)
		{	
			stm.setString(1, city);
		
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) 
			{
				Contact c = new Contact();
				c.setContact_id(rs.getInt("contact_id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				
				list.add(c);
			}
			
			System.out.println("records finded");
			
			rs.close();
			stm.close();
			con.close();
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
		
		return list;
	}
	
	// UPDATE
	@Override
	public Contact updateContact(int id, Contact contact) throws daoException
	{
		String sql = "UPDATE contacts SET name = ?, gender = ?, email = ?, phone = ?, city = ?, country = ? WHERE contact_id = ?";
			
			try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql);)
			{
				stm.setString(1,  contact.getName());
				stm.setString(2,  contact.getGender());
				stm.setString(3,  contact.getEmail());
				stm.setString(4,  contact.getPhone());
				stm.setString(5,  contact.getCity());
				stm.setString(6,  contact.getCountry());
				stm.setInt(7, id);
				
				int count = stm.executeUpdate();
			
				if(count==0)
				{
					throw new daoException("no updated, invalid id");
				}
				
				System.out.println("records updated");

				stm.close();
				con.close();
			}
			catch(Exception ex)
			{
				throw new daoException(ex);
			}
			
			return contact;
	}
	
	// DELETE
	@Override
	public String deleteContact(int id) throws daoException
	{	
		String sql = "DELETE FROM contacts WHERE contact_id = ?";
		
		try(Connection con = DButils.getConnection(); PreparedStatement stm = con.prepareStatement(sql);)
		{		
			
			stm.setInt(1, id);
			
			int count = stm.executeUpdate();
			
			if(count==0)
			{
				throw new daoException("no deleted, invalid id");
			}
			
			System.out.println("records deleted");

			stm.close();
			con.close();
		}
		catch(Exception ex)
		{
			throw new daoException(ex);
		}
	
		return ("deleted");
	}
	
}

