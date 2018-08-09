package com.assisenior.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DetectionChuteService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");;	
	
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
	
	public static void dataChute (int x, int y, int z) {
		
	}

}
