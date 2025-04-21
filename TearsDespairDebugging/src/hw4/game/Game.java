package hw4.game;

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
		// TODO Auto-generated constructor stub
	}
	
	public Grid createRandomGrid(int N) {
		// TODO Auto-generated method stub
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
		return "Game [grid="
				+ "Grid [rows=["
				+ "Row [cells=["
				+ "Cell [left=EXIT, right=APERTURE, up=WALL, down=APERTURE], "
				+ "Cell [left=APERTURE, right=WALL, up=WALL, down=APERTURE], "
				+ "Cell [left=WALL, right=WALL, up=WALL, down=APERTURE]]], "
				+ "Row [cells=["
				+ "Cell [left=WALL, right=WALL, up=APERTURE, down=APERTURE], "
				+ "Cell [left=WALL, right=APERTURE, up=APERTURE, down=APERTURE], "
				+ "Cell [left=APERTURE, right=WALL, up=APERTURE, down=APERTURE]]], "
				+ "Row [cells=["
				+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
				+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
				+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL]]]]]]";
	}

	
	
}
