package com.techouts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.techouts.entities.Person;

public class PersonDao {
	
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
    public Person save(Person p)
    {
    	this.template.save(p);
    	
    
    	return p;
    }

	

	public List<Person> getPersons()
	{
		List<Person> person=this.template.loadAll(Person.class);
		return person;
	}
    
    
	/*
	 * public int login(String name,String password) { List<Person> person =
	 * getPersons(); System.out.println(person.size()); for (Person p : person) {
	 * System.out.println(!(p.getName().contains(name))); if
	 * (!(p.getName().contains(name))) {
	 * 
	 * } } for(Person p1:person) { if (p1.getName().equals(name) &&
	 * p1.getPassword().equals(password)) { return 1; } }
	 * 
	 * return 2; }
	 */
	
	/*
	 * public int login(String name,String password) { List<Person> person =
	 * getPersons(); for (Person p : person) {
	 * 
	 * 
	 * for (Person person2 : person) { if(p.getName().equalsIgnoreCase(name) &&
	 * person2.getPassword().equalsIgnoreCase(password)) { return 1; } }
	 * 
	 * } return 2;
	 * 
	 * }
	 */
	
	public int ifRegistered(String email)
	{
		if(email!=null)
		{
		List<Person> user = getPersons();
		for (Person p : user) {
			if (p.getEmail().contains(email))
			{
		    return 1;
	        }
		}
		}
		return 0;
	}
	
	public List<Person> getPersonByName(String username)
	{
		String query="from Person where name= :username";
		List<Person> person=(List<Person>) this.template.findByNamedParam(query, "username", username);
		return person;
	}

}
