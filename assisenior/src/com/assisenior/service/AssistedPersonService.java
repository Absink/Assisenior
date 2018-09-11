package com.assisenior.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.AssistedPerson;

public class AssistedPersonService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");		
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
		
	public static AssistedPerson findById(int id) {	
		query = em.createQuery("SELECT a FROM AssistedPerson a WHERE a.id = :id");		
		query.setParameter("id", id);		
		List results = (List) query.getResultList();
		
		AssistedPerson assistedPerson = AssistedPerson.getInstance();
		for(int i=0; i < results.size(); i++) {
			assistedPerson = (AssistedPerson) results.get(i);
			break;
		}
		return assistedPerson;
	}
}