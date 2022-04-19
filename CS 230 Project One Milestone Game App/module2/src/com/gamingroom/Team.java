package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author Douglas Bolden
 *
 */
public class Team extends Entity {	
	
	/**
	 * A list of the active Players
	 */
	private static List<Player> players = new ArrayList<Player>();
	
	/**
	 * Returns the player instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested player instance
	 */
	static Player getPlayer(int index) {
		return players.get(index);
	}
	
	/**
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Construct a new player instance
	 * 
	 * @param name the unique name of the player
	 * @return the player instance (new or existing)
	 */
	public static Player addPlayer(String name) {

		// a local player instance
		Player player = null;
		
		// Make an iterator of the list of players.
		Iterator<Player> it = players.iterator();
		
		// Check the next item in the list to make sure it exists.
		while(it.hasNext()) {
			
			// Make a local variable.
			Player exists = it.next();
			
			// Check if the current variable's name is the same as the passed parameter.
			if (exists.getName() == name) {
				
				// If it does match, make it reference the original instance.
				player = exists;
			}
		}
		
		// if not found, make a new player instance and add to list of players
		if (player == null) {
			
			//Reference the Singleton Instance!
			GameService service = GameService.getInstance();
			
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing player instance to the caller
		return player;
	}
	
	@Override
	public String toString() {
		return "Team [id= " + id + ", name= " + name + "]";
	}
}