package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author Douglas Bolden
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		GameService service = GameService.getInstance(); // replace null with the SINGLE INSTANCE.
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		Game game2 = service.addGame("Game #2");
		Game game3 = service.addGame("Game #3");
		Game game4 = service.addGame("Game #4");
		System.out.println(game1);
		System.out.println(game2);
		System.out.println(game3);
		System.out.println(game4);
		
		// initialize with some team data
		Team team1 = Game.addTeam("Tennessee");
		Team team2 = Game.addTeam("Maine");
		Team team3 = Game.addTeam("Texas");
		Team team4 = Game.addTeam("Nevada");
		System.out.println(team1);
		System.out.println(team2);
		System.out.println(team3);
		System.out.println(team4);
		
		// initialize with some player data
		Player player1 = Team.addPlayer("Jump");
		Player player2 = Team.addPlayer("Pawn");
		Player player3 = Team.addPlayer("Jim");
		Player player4 = Team.addPlayer("Jank");
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}