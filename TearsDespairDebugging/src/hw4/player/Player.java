package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	
	// declare class variables
	private Row currentRow;
	private Cell currentCell;

	public Player(Row row, Cell cell) {
		this.currentRow = row;
		this.currentCell = cell;
	}

	public Row getCurrentRow() {
		return this.currentRow;
	}

	public Cell getCurrentCell() {
		return this.currentCell;
	}
	
	public void setCurrentRow(Row newRow) {
		this.currentRow = newRow;
	}
	
	public void setCurrentCell(Cell newCell) {
		this.currentCell = newCell;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + this.currentCell + ", currentRow=" + this.currentRow + "]";
	}

}
