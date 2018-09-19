package com.assisenior.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.Contact;
import com.assisenior.model.Emergency;

public class EmergencyService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");	
	
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
	
	public static List<Emergency> ListSecoursForPerson(int idPerson) {
		query = em.createQuery("SELECT e FROM Emergency e WHERE e.for_person=" + idPerson);
		return (List) query.getResultList();
	}
	
	public static Emergency RecupEmergency(int idPerson) {
		query = em.createQuery("SELECT e FROM Emergency e");
		List results = (List) query.getResultList();
		Emergency em = new Emergency();
		
		for(int i=0; i < results.size(); i++) {
			em = (Emergency) results.get(i);
			return em;
		}
		return null;					
	}

}
