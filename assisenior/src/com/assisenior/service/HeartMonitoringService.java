package com.assisenior.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.AssistedPerson;

public class HeartMonitoringService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");
	
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
	
	public static void heartMonitoring (int heartbeat) {
		
		
		if(heartbeat<AssistedPerson.getInstance().getMinHeartRateThreshold()||heartbeat>AssistedPerson.getInstance().getMaximumHeartRate()) {
			
			AlertService.alerter(4, 1, AssistedPerson.getInstance().getId());
			System.out.println("[ASSISENIOR] APPEL SECOURS");
		
		}else {
			System.out.println("[ASSISENIOR] RAS");	
		}
		
		

	}

}
