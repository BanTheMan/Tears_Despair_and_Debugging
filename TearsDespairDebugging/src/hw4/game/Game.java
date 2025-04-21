package hw4.game;

import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
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
		// Grid constructor takes ArrayList<Row>
//		Grid grid = new Grid(N);
		Random rand = new Random();
		
		// Exit row must be left (first) row
//		int exitRow = rand.nextInt(N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				Cell cell = new Cell(
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL);
				
				// Redundant with appropriate constructor call :P
//				cell.setUp(WALL);
//				cell.setDown(WALL);
//				cell.setDown(WALL);
//				cell.setRight(WALL);
				
				// keep in mind that only 1 cell in the left row should have exit
//				if (j == 0 & i == exitRow )
//				{ cell.setLeft(CellComponents.EXIT); }
			
			}
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
