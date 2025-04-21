package hw4.game;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

/**
 * 
 */
public class Game {
	
	// declare class variables
	
	private Grid grid;
	private Player player;

	public static void setupGame() {
		
		
	}
	
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Game(int N) {
		this.grid = createRandomGrid(N);
				}
	
	public Grid createRandomGrid(int N) {
		Grid grid = new Grid(N);
		Random rand = new Random;
		
		int exitRow = rand.nextInt(N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				Cell cell = new Cell();
				
				cell.setUp(CWALL);
				cell.setDown(WALL);
				cell.setDown(WALL);
				cell.setRight(WALL);
				
				if (j == 0 & i == exitRow )
				{ cell.setLeft(EXIT); }
			
		}
		
		return null;
	}

	public Grid getGrid() {
		return this.grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean play(Movement move, Player player) {
		// return false if move is invalid
		// use player getters and setters to move them appropriately
		return true;
	}

	@Override
	public String toString() {
		return "Game [" + this.grid +  "]";
	}

	
	
}
