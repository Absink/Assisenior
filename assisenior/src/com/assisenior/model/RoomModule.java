package com.assisenior.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="Room_module")
@NamedQuery(name="RoomModule.findAll", query="SELECT r FROM RoomModule r")
public class RoomModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private int for_room;

	
	public RoomModule() {
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

	public int getFor_room() {
		return for_room;
	}

	public void setFor_room(int for_room) {
		this.for_room = for_room;
	}
}