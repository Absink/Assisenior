package com.assisenior.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.Contact;

public class ContactService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");	
	
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
		
	public static List<Contact> find(int idPerson) {
		query = em.createQuery("SELECT c FROM Contact c WHERE c.for_person = :param1");
		query.setParameter("param", idPerson);
		return (List) query.getResultList();
	}
	
	public static Contact findByLogin(String login, String password) {
		query = em.createQuery("SELECT c FROM Contact c WHERE c.login = :login AND c.password = :pass");
		query.setParameter("login", login);
		query.setParameter("pass", password);
		
		List results = (List) query.getResultList();
		Contact contact = new Contact();
		for(int i=0; i < results.size(); i++) {
			contact = (Contact) results.get(i);
			break;
		}
		
		if (login.equalsIgnoreCase(contact.getLogin()) && password.equals(contact.getPassword())) {
			return contact;
		} else {
			return null;
		}
	}

}
