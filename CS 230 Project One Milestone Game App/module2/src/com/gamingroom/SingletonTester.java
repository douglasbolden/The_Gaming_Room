package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author Douglas Bolden
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		GameService service = GameService.getInstance(); // replace null with the SINGLE INSTANCE.
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}
		
		// a simple for loop to print the teams
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(Game.getTeam(i));
		}
		
		// a simple for loop to print the players
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(Team.getPlayer(i));
		}		
	}	
}