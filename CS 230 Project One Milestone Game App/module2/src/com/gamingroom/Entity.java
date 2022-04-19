package com.gamingroom;

public class Entity {
	/**
	 * Holds the next id identifier
	 */
	protected long id;
	
	/**
	 * Holds the next name identifier
	 */
	protected String name;
	
	/**
	 * Constructor with an identifier and name
	 */
	protected Entity() {}
	
	/**
	 * Constructor with an identifier and name
	 */
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id= " + id  + ", name= " + name + "]";
	}
}