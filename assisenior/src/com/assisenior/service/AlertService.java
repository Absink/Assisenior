package com.assisenior.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.assisenior.model.AssistedPerson;
import com.assisenior.model.Contact;

public class AlertService {
	
	/* Type d'incident :
	 * 1)chute
	 * 2)appel a l'aide
	 * 3)position intérieure
	 * 4)rythme cardiaque
	 * 5)position exterieur
	 * 
	 * Type criticité :
	 * 1)appel secours
	 * 2)appel contact
	 */
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");		
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
		
	public static void alerter (int typeIncident, int criticite, int assistedPerson) {				
		String incident;
		switch(typeIncident) {
			case 1: incident = "Chute";
			case 2: incident = "Appel a l'aide";
			case 3: incident = "Immobilité longue dans une pièce";
			case 4: incident = "Problème cardiaque";
			case 5: incident = "Sortie du pèrimètre exterieur";
		}		
		//TODO : Créer fonction de service "AssistedPersonService" pour trouver assistedPerson par id
		//assistedPerson = AssistedPersonService.findById(assistedPerson);
		if(criticite == 1) {
			appelSecours(incident);
		} else if (criticite == 2) {
			appelProche(incident, assistedPerson);
		}
	}
	
	private static void appelSecours(String incident) {
		/* TODO : 
		 * - récupérer le tel des secours
		 * - appel secours
		 */
	}
	
	private static void appelProche(String incident, AssistedPerson person) {
		/* TODO : 
		 * - récupérer la liste des proches par priority
		 * - récupérer le téléphone
		 * - appel du premier, deuxieme .... 
		 * - Si pas de réponse, lancer méthode 'appelSecours'
		 */
	}
}