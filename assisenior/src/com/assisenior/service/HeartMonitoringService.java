package com.assisenior.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.assisenior.model.AssistedPerson;

public class HeartMonitoringService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");
		
	public static void controlHeartBeat (int heartbeat) {		
		if(heartbeat<AssistedPerson.getInstance().getMinHeartRateThreshold()||heartbeat>AssistedPerson.getInstance().getMaximumHeartRate()) {		
			AlertService.alerter(4, 1, AssistedPerson.getInstance().getId());
		}
	}
}
