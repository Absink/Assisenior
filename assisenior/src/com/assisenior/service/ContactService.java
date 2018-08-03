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

}
