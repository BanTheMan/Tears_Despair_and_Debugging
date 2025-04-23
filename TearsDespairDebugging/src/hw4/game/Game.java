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
 * Author: Nate Spencer
 */
public class Game {
	
	// declare class variables
	
	private Grid grid;
	
	/**
	 * Description
	 * @param grid
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	/**
	 * 
	 * Description
	 * @param N size of Grid
	 */
	public Game(int N) {
		this.grid = createRandomGrid(N);
	}
	
	/**
	 * Description
	 * @param N size of Grid
	 * @return created Grid.
	 */
	public Grid createRandomGrid(int N) {
		
		if (N < 3 || N > 7)
		{ return null; }
		
		Random rand = new Random();

		ArrayList<ArrayList<Cell>> newGrid = new ArrayList<>();
		
		//Create a grid of cells with walls
		for (int i = 0; i < N; i++) {
			ArrayList<Cell> row = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				
				Cell newCell = new Cell(
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL,
						CellComponents.WALL
						);

				
				if (j == 0 && i == 0 ) // Upper Left Corner as EXIT
				{ newCell.setLeft(CellComponents.EXIT); 
				
				}
				
				row.add(newCell);
				
			}
			
			newGrid.add(row);

		}
		
		
		
		//Guarantee an exit Path
		
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
		
			
		
		//Adding aperture for each room, random amount.
		for ( i = 0; i < N; i++ )
			{
			
			for ( j = 0; j < N; j++)
				{
				
				Cell cell = newGrid.get(i).get(j);
						
				int apAmount = 1 + rand.nextInt(3); //Random APERTURE between 1-3 amount
				
				String locationCase;
				
				
				//EDGE CASE CELLS
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
				
				else if (j == N-1 )
					{
						locationCase = "NORIGHT";
					}
				
				else if (j == 0 )
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
		
		//Turn the final product into a grid and return
		
		ArrayList<Row> rows = new ArrayList<>();
		for (ArrayList<Cell> cellRow : newGrid) {
			rows.add(new Row(cellRow));
		}
		return new Grid(rows);
		
	}
	
	

	/**
	 * Description
	 * @return grid given
	 */
	public Grid getGrid() {
		return this.grid;
	}
	
	/**
	 * Description
	 * @param grid
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * @param move (movement being requested)
	 * @param player (player being used)
	 * @return (returns whether or not movement failed or happened) 
	 */
	public boolean play(Movement move, Player player) {
		
	    if (move == null || player == null) {
	    	System.out.println("System Error. NULL move or NULL player.");
	        return false;
	    }
		
		Row currentRow = player.getCurrentRow();
		Cell currentCell = player.getCurrentCell();
		
		int currentRowIndex = 0;
		int currentColIndex = 0;
		
	    for (int i = 0; i < currentRow.getCells().size(); i++) {
	        if (currentRow.getCells().get(i) == currentCell) {
	            currentColIndex = i;
	            break;
	        }
	    }
		

	    ArrayList<Row> allRows = this.grid.getRows();
	    for (int i = 0; i < allRows.size(); i++) {
	        if (allRows.get(i) == currentRow) {
	            currentRowIndex = i;
	            break;
	        }
	    }
		
	    switch (move) {
        case UP:
            if (currentCell.getUp() == CellComponents.APERTURE && currentRowIndex > 0) {
                player.setCurrentRow(allRows.get(currentRowIndex - 1));
                return true;
            }
            break;
        case DOWN:
            if (currentCell.getDown() == CellComponents.APERTURE && currentRowIndex < allRows.size() - 1) {
                player.setCurrentRow(allRows.get(currentRowIndex + 1));
                return true;
            }
            break;
        case LEFT:
            if (currentCell.getLeft() == CellComponents.EXIT) {


                // Check if they just passed through the exit
                System.out.println("Player escaped through the EXIT!");
                return true;
            } else if (currentCell.getLeft() == CellComponents.APERTURE && currentColIndex > 0) {
                player.setCurrentCell(currentRow.getCells().get(currentColIndex - 1));
                return true;
            }
            break;
        case RIGHT:
            if (currentCell.getRight() == CellComponents.APERTURE && currentColIndex < currentRow.getCells().size() - 1) {
                player.setCurrentCell(currentRow.getCells().get(currentColIndex + 1));
                return true;
            }
            break;
            
         
    }

	    return false;
	    
	}
	
	/**
	 * Description
	 * @param player being passed
	 */
	public void visualizeGrid(Player player) {
		for (Row row : this.grid.getRows()) {
			for (Cell cell : row.getCells()) {
				if (player.getCurrentCell() == cell) {
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
	
	
				

	/**
	 * String representation of Game object
	 */
	@Override
	public String toString() {
		return "Game [grid=" + this.grid +  "]";
	}

	
	
}
