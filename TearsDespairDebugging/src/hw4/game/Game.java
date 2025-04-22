package hw4.game;

import java.util.Random;
import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.Row;
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
		int exitRow = rand.nextInt(N);
		
		ArrayList<Row> allRows = new ArrayList<Row>();
		
		for (int i = 0; i < N; i++) {
			ArrayList<Cell> cellList = new ArrayList<Cell>();
			
			for (int j = 0; j < N; j++) {
				
				Cell newCell = new Cell(
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL
						);

				
				if (j == 0 && i == exitRow )
				{ newCell.setLeft(CellComponents.EXIT); }
				
				cellList.add(newCell);
			
			}
			
			Row newRow = new Row(cellList);
			allRows.add(newRow);

		}
		
		return new Grid(allRows);
	}
	
	

	public Grid getGrid() {
		return this.grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean play(Movement move, Player player) {
		Row row = player.getCurrentRow();
		
		
		
		
		
		return true;
	}

	@Override
	public String toString() {
		return "Game [" + this.grid +  "]";
	}

	
	
}
