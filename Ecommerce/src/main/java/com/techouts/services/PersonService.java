package com.techouts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.PersonDao;
import com.techouts.entities.Person;

@Service
public class PersonService {
	
	 @Autowired
	 private PersonDao personDao;

		public PersonDao getPersonDao() {
			return personDao;
		}

		public void setPersonDao(PersonDao personDao) {
			this.personDao = personDao;
		}

		public Person save(Person p)
		{
			personDao.save(p);
			return p;
		}

		public List<Person> getPersons()
		{
			List<Person> person=personDao.getPersons();
			return person;
		}
		
		/*
		 * public int login(String name,String password) { int num=personDao.login(name,
		 * password); return num; }
		 */
        
		public int ifRegistered(String email)
		{
			int num=personDao.ifRegistered(email);
			
			return num;
		}
        
		public List<Person> getPersonByName(String username)
		{
			List<Person> p=personDao.getPersonByName(username);
			return p;
		}
}
