package com.assisenior.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.assisenior.model.AssistedPerson;

public class DetectionChuteService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");
	
	public static void controlChute (float alpha, float beta, float gamma) {
		if(alpha==0 && beta==0 && gamma==0) {
			AlertService.alerter(1, 2, AssistedPerson.getInstance().getId());
		}
	}
}