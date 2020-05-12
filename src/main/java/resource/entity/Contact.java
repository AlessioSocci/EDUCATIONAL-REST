package resource.entity;

public class Contact 
{
	private Integer contac_id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String city;
	private String country;
	
	public Contact()
	{
		
	}

	public Integer getContact_id() 
	{
		return contac_id;
	}

	public void setContact_id(Integer contac_id)
	{
		this.contac_id = contac_id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String coutntry) 
	{
		this.country = coutntry;
	}
	
}
