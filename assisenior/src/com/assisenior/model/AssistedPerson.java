package com.assisenior.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the assistedPerson database table.
 * 
 */
@Entity
@Table(name="assisted_person")
@NamedQuery(name="AssistedPerson.findAll", query="SELECT a FROM AssistedPerson a")
public class AssistedPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ddnaissance;

	private String lastname;
	
	private String firstname;
	
	private String address;
	
	private String phone;
	
	private int minHeartRateThreshold;
	
	private int maxHeartRateThreshold;
	
	private int displacementRadius;
	
	private int referent_admin;

	// une seule personne a monitorer --> Singleton
	private AssistedPerson() {
	}
	
	private static AssistedPerson instance = new AssistedPerson() ;
	
	public static AssistedPerson getInstance() {
			      return instance ;
	}
	
	public AssistedPerson(String lastname, String firstname, String phone) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
	}

	public int getMaximumHeartRate() {
		
		
		
		if (this.getMaxHeartRateThreshold()!=0) {
			// si une spécification médicale fait que le rythme max est donné en base
			return this.getMaxHeartRateThreshold();
		}else {
			
			// calcul de l'age
			
				//récupérer année de naissance
			String dateNaissance = this.getDdnaissance();
			String anneeNaissance=dateNaissance.substring(0, 3);
			int anneeNaissanceInt=Integer.parseInt(anneeNaissance);
			
				//récupérer année en cours
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			
			
			int age=year-anneeNaissanceInt;
			
			// calcul fréquence cardiaque maximale = 191.5 - 0.007 x âge²
			
			System.out.println("Fréquence max = "+ (191.5-(0.007*Math.sqrt(age))));			
			return (int) (191.5-(0.007*Math.sqrt(age)));
			
		}
		
		

		
	}
	

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDdnaissance() {
		return "1970-01-01";
	}

	public void setDdnaissance(String ddnaissance) {
		this.ddnaissance = ddnaissance;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getMinHeartRateThreshold() {
		return 60;
	}

	public void setMinHeartRateThreshold(int minHeartRateThreshold) {
		this.minHeartRateThreshold = minHeartRateThreshold;
	}

	public int getMaxHeartRateThreshold() {
		return 0;
	}

	public void setMaxHeartRateThreshold(int maxHeartRateThreshold) {
		this.maxHeartRateThreshold = maxHeartRateThreshold;
	}

	public int getDisplacementRadius() {
		return displacementRadius;
	}

	public void setDisplacementRadius(int displacementRadius) {
		this.displacementRadius = displacementRadius;
	}

	public int getReferent_admin() {
		return referent_admin;
	}

	public void setReferent_admin(int referent_admin) {
		this.referent_admin = referent_admin;
	}
}