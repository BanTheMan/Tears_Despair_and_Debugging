package hw4.game;

import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	
	// declare class variables
	
	private Grid grid = null;

	public static void setupGame() {
		
	}
	
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Game(int i) {
		// TODO Auto-generated constructor stub
	}

	public Grid getGrid() {
		return this.grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Object play(Movement right, Player player) {
		return null;
	}

	public Grid createRandomGrid(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// add ToString
	
}
