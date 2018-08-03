package com.assisenior.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the capteur database table.
 * 
 */
@Entity
@Table(name="capteur")
@NamedQuery(name="Capteur.findAll", query="SELECT c FROM Capteur c")
public class Capteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String max_time;
	
	private String for_person;

	public Capteur() {
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMax_time() {
		return max_time;
	}

	public void setMax_time(String max_time) {
		this.max_time = max_time;
	}

	public String getFor_person() {
		return for_person;
	}

	public void setFor_person(String for_person) {
		this.for_person = for_person;
	}

}