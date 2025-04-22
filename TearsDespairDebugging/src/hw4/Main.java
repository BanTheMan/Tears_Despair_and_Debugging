package hw4;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Main {
	
	private static Game game;
	private static Grid grid;
	private static Player player;
	
	public static void main(String[] args) {
		Game.setupGame();
		game = new Game(grid);
		
		Cell cell00 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell01 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell02 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell10 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell11 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell12 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell20 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell21 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell22 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);


		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(0, cell00);
		cells.add(1, cell01);
		cells.add(2, cell02);
		Row row0 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell10);
		cells.add(1, cell11);
		cells.add(2, cell12);
		Row row1 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell20);
		cells.add(1, cell21);
		cells.add(2, cell22);
		Row row2 = new Row(cells);

		ArrayList<Row> rows = new ArrayList<Row>();
		rows.add(0, row0);
		rows.add(1, row1);
		rows.add(2, row2);
		grid = new Grid(rows);
		player = new Player(grid.getRows().get(2), 
				grid.getRows().get(2).getCells().get(2));
		
	}
	
	public static void navigate() {
		
	}
	
	public static boolean isExitable(Grid grid, Row currentRow, Cell currentCell) {
		// find row index
		int j = 0;
		for (Row row : grid.getRows()) {
			if (currentRow == row) {break;}
			j++;
		}
		// find cell index
		int i = 0;
		for (Cell cell : currentRow.getCells()) {
			if (currentCell == cell) {break;}
			i++;
		}
		
		// assuming edge of maze is always a wall
		if (currentCell.getUp() == CellComponents.APERTURE) {
			
		}
		return false;
	}
	
}
