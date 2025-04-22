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
		
		Random rand = new Random();

		ArrayList<ArrayList<Cell>> newGrid = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			ArrayList<Cell> row = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				
				Cell newCell = new Cell(
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL
						);

				
				if (j == 0 && i == 0 ) // Upper Left Corner
				{ newCell.setLeft(CellComponents.EXIT); 
				
				}
				
				row.add(newCell);
				
			}
			
			newGrid.add(row);

		}
		
		
		
		//Guarantee a Path
		
		int i = N - 1, j = N -1; // Bottom Right Corner
			
		while ( i > 0 || j > 0 )
			{
	
				int path = rand.nextInt(2); // 0 UP ; 1 LEFT
					if (path == 0 && i > 0)
					{
						newGrid.get(i).get(j).setUp(CellComponents.APERTURE);
						newGrid.get(i-1).get(j).setDown(CellComponents.APERTURE);
						i--;
					}
			
					else if (path == 1 && j > 0)
					{
						newGrid.get(i).get(j).setLeft(CellComponents.APERTURE);
						newGrid.get(i).get(j-1).setRight(CellComponents.APERTURE);
						j--;
					}
			}
		
		
			// Add random two-way aperture. WIP
			
			
		for ( i = 0; i < N; i++ )
			{
			
			for ( j = 0; j < N; j++)
				{
				
				Cell cell = newGrid.get(i).get(j);
				ArrayList<String> direct = new ArrayList<>();
				
				
				int apAmmount = rand.nextInt(3);
				
				String locationCase;
				
				
				if (i == 0 && j == 0)
					{
						locationCase = "EXIT"; //TOPLEFT
					}
				
				if (i == 0 && j == N -1)
					{
						locationCase = "TOPRIGHT";
							
					}
				
				if (i == N-1 && j == 0)
					{
						locationCase = "BOTTOMLEFT";
							
					}
				
				if (i == N -1 && j == N -1 )
					{
						locationCase = "BOTTOMRIGHT";
						
					}
				
				
				
				
				
				
				
				
				
				}
			
			
			}
		
	}
	
	

	public Grid getGrid() {
		return this.grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean play(Movement move, Player player) {
		Row row = player.getCurrentRow();
		
		
		//WIP
		
		
		return true;
	}

	@Override
	public String toString() {
		return "Game [" + this.grid +  "]";
	}

	
	
}
