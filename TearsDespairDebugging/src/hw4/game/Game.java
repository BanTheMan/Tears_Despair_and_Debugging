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
						
				int apAmount = 1 + rand.nextInt(3); //Amount of added aperture. Only 2 possible due to duel aperture doubling amount.
				
				String locationCase;
				
				
				if (i == 0 && j == 0)
					{
						locationCase = "EXITCELL"; //TOPLEFT
					}
				
				else if (i == 0 && j == N -1)
					{
						locationCase = "TOPRIGHT";
							
					}
				
				else if (i == N-1 && j == 0)
					{
						locationCase = "BOTTOMLEFT";
							
					}
				
				else if (i == N -1 && j == N -1 )
					{
						locationCase = "BOTTOMRIGHT";
						
					}
				
				else if (j == 0 )
					{
						locationCase = "NORIGHT";
					}
				
				else if (j == N-1 )
					{
						locationCase = "NOLEFT";
					}
				
				else if (i == 0 )
					{
						locationCase = "NOUP";
					}
					
				else if (i == N-1 )
					{
						locationCase = "NOBOTTOM";
					}
					
				else
					{
						locationCase = "INSIDE";
					}
					
			
				int k = 0;
				int currentAp = 0;
				
				
				switch (locationCase)
				{
				
				case "EXITCELL" ->
				{
					if (apAmount == 3) //Corners only can have 2 possible aperture.
					{
						apAmount--;
					}
					
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
				
					while(k < apAmount)
					{
						int direction = rand.nextInt(2); // 0 RIGHT, 1 DOWN
						
						if(direction == 0 && cell.getRight() != CellComponents.APERTURE )
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j+1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
							newGrid.get(i+1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				case "TOPRIGHT" ->
				{
					if (apAmount == 3) //Corners only can have 2 possible aperture.
					{
						apAmount--;
					}
					
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(2); // 0 LEFT, 1 DOWN
						
						if(direction == 0 && cell.getLeft() != CellComponents.APERTURE )
						{
							cell.setLeft(CellComponents.APERTURE);
				            newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
				            newGrid.get(i + 1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				case "BOTTOMRIGHT" ->
				{
					if (apAmount == 3) //Corners only can have 2 possible aperture.
					{
						apAmount--;
					}
					
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(2); // 0 LEFT, 1 UP
						
						if(direction == 0 && cell.getLeft() != CellComponents.APERTURE )
						{
							cell.setLeft(CellComponents.APERTURE);
							newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getUp() != CellComponents.APERTURE)
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				

				case "BOTTOMLEFT" ->
				{
					if (apAmount == 3) //Corners only can have 2 possible aperture.
					{
						apAmount--;
					}
					
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(2); // 0 RIGHT, 1 UP
						
						if(direction == 0 && cell.getRight() != CellComponents.APERTURE )
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j + 1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getUp() != CellComponents.APERTURE)
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				
				
				
				case "NORIGHT" ->
				{

					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(3); // 0 UP; 1 LEFT; 2 DOWN
						
						if(direction == 0 && cell.getUp() != CellComponents.APERTURE )
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getLeft() != CellComponents.APERTURE)
						{
							cell.setLeft(CellComponents.APERTURE);
							newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 2 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
							newGrid.get(i + 1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				case "NOLEFT" ->
				{
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(3); // 0 UP; 1 RIGHT; 2 DOWN
						
						if(direction == 0 && cell.getUp() != CellComponents.APERTURE )
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getRight() != CellComponents.APERTURE)
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j + 1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 2 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
							newGrid.get(i + 1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				case "NOUP" ->
				{
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(3); // 0 LEFT; 1 RIGHT; 2 DOWN
						
						if(direction == 0 && cell.getLeft() != CellComponents.APERTURE )
						{
							cell.setLeft(CellComponents.APERTURE);
							newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getRight() != CellComponents.APERTURE)
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j + 1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 2 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
							newGrid.get(i + 1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				case "NODOWN" ->
				{
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(3); // 0 LEFT; 1 RIGHT; 2 UP
						
						if(direction == 0 && cell.getLeft() != CellComponents.APERTURE )
						{
							cell.setLeft(CellComponents.APERTURE);
							newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getRight() != CellComponents.APERTURE)
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j + 1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 2 && cell.getUp() != CellComponents.APERTURE)
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
				
				
				
				
				case "INSIDE" ->
				{
					if(cell.getUp() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getDown() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getRight() == CellComponents.APERTURE)
					{ currentAp++; }
					if(cell.getLeft() == CellComponents.APERTURE)
					{ currentAp++; }
					
					k = k + currentAp;
					
					while(k < apAmount)
					{
						int direction = rand.nextInt(4); // 0 UP; 1 RIGHT; 2 DOWN; 3 LEFT
						
						if(direction == 0 && cell.getUp() != CellComponents.APERTURE )
						{
							cell.setUp(CellComponents.APERTURE);
							newGrid.get(i - 1).get(j).setDown(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 1 && cell.getRight() != CellComponents.APERTURE)
						{
							cell.setRight(CellComponents.APERTURE);
							newGrid.get(i).get(j + 1).setLeft(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 2 && cell.getDown() != CellComponents.APERTURE)
						{
							cell.setDown(CellComponents.APERTURE);
							newGrid.get(i + 1).get(j).setUp(CellComponents.APERTURE);
							k++;
						}
						
						else if(direction == 3 && cell.getLeft() != CellComponents.APERTURE)
						{
							cell.setLeft(CellComponents.APERTURE);
							newGrid.get(i).get(j - 1).setRight(CellComponents.APERTURE);
							k++;
						}
						
					}
				
				}
			
				
			} //end switch case
			
				
			}
		
		}
		
		ArrayList<Row> rows = new ArrayList<>();
		for (ArrayList<Cell> cellRow : newGrid) {
			rows.add(new Row(cellRow));
		}
		return new Grid(rows);
		
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
	
	public void visualizeGrid() {
		for (Row row : this.grid.getRows()) {
			for (Cell cell : row.getCells()) {
				if (this.player.getCurrentCell() == cell) {
					System.out.print("A ");
				} 
				
				else if (cell.getLeft() == CellComponents.EXIT) {
					System.out.print("E ");
				} 

				else {
					System.out.print("S ");
				}
			}
			System.out.println();
		}
	}
	
	
				

	@Override
	public String toString() {
		return "Game [" + this.grid +  "]";
	}

	
	
}
