package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author Douglas Bolden
 *
 */
public class Game extends Entity {
	
	/**
	 * A list of the active teams
	 */
	private static List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Returns the team instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested team instance
	 */
	static Team getTeam(int index) {
		return teams.get(index);
	}
	
	/**
	 * Construct a new team instance
	 * 
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public static Team addTeam(String name) {

		// a local game instance
		Team team = null;
		
		// Make an iterator of the list of teams.
		Iterator<Team> it = teams.iterator();
		
		// Check the next item in the list to make sure it exists.
		while(it.hasNext()) {
			
			// Make a local variable.
			Team exists = it.next();
			
			// Check if the current variable's name is the same as the passed parameter.
			if (exists.getName() == name) {
				
				// If it does match, make it reference the original instance.
				team = exists;
			}
		}	
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			
			//Reference the Singleton Instance!
			GameService service = GameService.getInstance();
			
			team = new Team(service.getNextTeamId(), name);
			teams.add(team);
		}
		
		// return the new/existing game instance to the caller
		return team;
	}
	
	@Override
	public String toString() {
		return "Game [id= " + id + ", name= " + name + "]";
	}
}