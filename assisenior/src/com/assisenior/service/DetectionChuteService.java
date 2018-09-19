package com.assisenior.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.assisenior.model.AssistedPerson;

public class DetectionChuteService {
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");
	
	private static float a=1000;
	private static float b=1000;
	private static float c=1000;
	
	public static void controlChute (float alpha, float beta, float gamma) {
		// Initialisation des valeurs
		if(a == 1000 && b == 1000 && c == 1000) {
			a = alpha;
			b = beta;
			c = gamma;
		} else {
		
		// Traitement de calculs
			if(alpha==0 && beta==0 && gamma==0) {
				AlertService.alerter(1, 2, AssistedPerson.getInstance().getId());
			}
			
			
		}
		
		
	}
	
	public void initValues() {
		
	}
}