package com.alonepmk.Model;


public class Account
{

    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
    private int gender;
    private String city;
    private String country;
    private String password;
    private int emailConfirmCode;
    private int confirmation;
    //Above are Mandatory
    
    private String fullName;
    
    public Account()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
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

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getEmailConfirmCode()
    {
        return emailConfirmCode;
    }

    public void setEmailConfirmCode(int code)
    {
        emailConfirmCode = code;
    }

    public int getConfirmation()
    {
        return confirmation;
    }

    public void setConfirmation(int confirmation)
    {
        this.confirmation = confirmation;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
}
