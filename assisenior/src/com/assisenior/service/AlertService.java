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
	
		
	public static void alerter (int typeIncident, int criticite, int idAssistedPerson) {				
		String incident = null;
		switch(typeIncident) {
			case 1: incident = "Chute";
			case 2: incident = "Appel a l'aide";
			case 3: incident = "Immobilité longue dans une pièce";
			case 4: incident = "Problème cardiaque";
			case 5: incident = "Sortie du pèrimètre exterieur";
		}
		AssistedPerson assistedPerson = AssistedPersonService.findById(idAssistedPerson);
		if(criticite == 1) {
			appelSecours(incident);
		} else if (criticite == 2) {
			appelProche(incident, assistedPerson);
		}
	}
	
	private static void appelSecours(String incident) {
		System.out.println("[ASSISENIOR] APPEL SECOURS");
		/* TODO : 
		 * - récupérer le tel des secours
		 * - appel secours
		 */
	}
	
	private static void appelProche(String incident, AssistedPerson person) {
		System.out.println("[ASSISENIOR] APPEL PROCHES");
		
		// Répuparation de la liste de contacts
		List<Contact> contacts = ContactService.ListForPerson(person.getId());
		int countAppel = 0;
		int priority = 1;
		boolean r�ponseContact = false;
		
		// Appel des contacts par ordre de priorité
		while(!r�ponseContact && contacts.size() != countAppel) {
			for (Contact c: contacts) {
				if(c.getPriority()==priority) {
					countAppel++;
					if(r�ponse(c)){
						System.out.println("[ASSISENIOR] COMMUNICATION ETABLIE AVEC " +c.getLastname() + " " +c.getFirstname());
						r�ponseContact = true;
						break;					
					}
					priority++;
				}
			}
		}
		
		// Appel des secours
		if(!r�ponseContact) {
			System.out.println("[ASSISENIOR] AUCUNE REPONSES DES CONTACTS");
			appelSecours(incident);
		}			
	}
	
	
	private static boolean r�ponse(Contact c) {
		// Simulation d'appel
		System.out.println("Appel au " + c.getPhone() +"...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Test réponse pour simulation
		if(c.getPhone().equals("0203010203"))
			return true;
		else
			return false;
	}
}