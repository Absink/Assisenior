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
	 * 3)position int�rieure
	 * 4)rythme cardiaque
	 * 5)position exterieur
	 * 
	 * Type criticit� :
	 * 1)appel secours
	 * 2)appel contact
	 */
	
	@PersistenceContext
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("assisenior");		
	private static EntityManager em = factory.createEntityManager();
	private static Query query;
	
		
	public static void alerter (int typeIncident, int criticit�, int assistedPerson) {				
		String incident;
		switch(typeIncident) {
			case 1: incident = "Chute";
			case 2: incident = "Appel � l'aide";
			case 3: incident = "Immobilit� longue dans une pi�ce";
			case 4: incident = "Probl�me cardiaque";
			case 5: incident = "Sortie du p�rim�tre ext�rieur";
		}		
		//TODO : Cr�er fonction de service "AssistedPersonService" pour trouver assistedPerson par id
		//assistedPerson = AssistedPersonService.findById(assistedPerson);
		if(criticit� == 1) {
			appelSecours(incident);
		} else if (criticit� == 2) {
			appelProche(incident, assistedPerson);
		}
	}
	
	private static void appelSecours(String incident) {
		/* TODO : 
		 * - r�cup�rer le tel des secours
		 * - appel secours
		 */
	}
	
	private static void appelProche(String incident, AssistedPerson person) {
		/* TODO : 
		 * - r�cup�rer a liste des proches par priority
		 * - r�cup�rer le t�l�phone
		 * - appel du premier, deuxieme .... 
		 * - Si pas de r�ponse, lancer m�thode 'appelSecours'
		 */
	}
}