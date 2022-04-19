package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * A singleton service for the game engine
 * 
 * @author Douglas Bolden
 */
public class GameService{

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/**
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/**
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	
	/**
	 * Holds the next Team identifier
	 */
	private static long nextTeamId = 1;
	
	// make instances of the GameService() to be compared
	private static GameService service = new GameService();
	
	// hide it!
	private GameService() {}
	
	// reference the single instance.
	public static GameService getInstance() {
		return service;
	}
	
	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Make an iterator of the list of games.
		Iterator<Game> it = games.iterator();
		
		// Check the next item in the list to make sure it exists.
		while(it.hasNext()) {
			
			// Make a local variable.
			Game exists = it.next();
			
			// Check if the current variable's name is the same as the passed parameter.
			if (exists.getName() == name) {
				
				// If it does match, make it reference the original instance.
				game = exists;
			}
		}	
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		
		// return the new/existing game instance to the caller
		return game;
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		//Make an iterator of the list of games.
		Iterator<Game> it = games.iterator();
		
		// Check the next item in the list to make sure it exists.
		while(it.hasNext()) {
			
			// Make a local variable.
			Game exists = it.next();
			
			// Check if the current variable's name is the same as the passed parameter.
			if (exists.getId() == id) {
				
				// If it does match, make it reference the original instance.
				game = exists;
			}
		}
		
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
		
		// a local game instance
		Game game = null;
		
		//Make an iterator of the list of games.
		Iterator<Game> it = games.iterator();
		
		// Check the next item in the list to make sure it exists.
		while(it.hasNext()) {
			
			// Make a local variable.
			Game exists = it.next();
			
			// Check if the current variable's name is the same as the passed parameter.
			if (exists.getName() == name) {
				
				// If it does match, make it reference the original instance.
				game = exists;
			}
		}
		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns list of players.
	 * @return returns list of players.
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/**
	 * Returns list of teams.
	 * @return returns list of teams.
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}