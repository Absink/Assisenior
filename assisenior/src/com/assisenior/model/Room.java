package com.assisenior.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="room")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private int maxDurationOfPresence;
	
	private int timeOfEntry;
	
	private int for_person;

	
	public Room() {
	}


	public int getId() {
		return id;
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

	public int getMaxDurationOfPresence() {
		return maxDurationOfPresence;
	}

	public void setMaxDurationOfPresence(int maxDurationOfPresence) {
		this.maxDurationOfPresence = maxDurationOfPresence;
	}

	public int getTimeOfEntry() {
		return timeOfEntry;
	}

	public void setTimeOfEntry(int timeOfEntry) {
		this.timeOfEntry = timeOfEntry;
	}

	public int getFor_person() {
		return for_person;
	}

	public void setFor_person(int for_person) {
		this.for_person = for_person;
	}

}