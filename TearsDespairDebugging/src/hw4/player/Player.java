package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Author: Brandon Gomes
 * Player Agent class
 */
public class Player {
	
	// declare class variables
	private Row currentRow;
	private Cell currentCell;

	/**
	 * Player constructor
	 * @param row the player currently occupies
	 * @param cell the player currently occupies
	 */
	public Player(Row row, Cell cell) {
		this.currentRow = row;
		this.currentCell = cell;
	}

	/**
	 * Retrieve the currently occupied row
	 * @return the row the player currently occupies
	 */
	public Row getCurrentRow() {
		return this.currentRow;
	}

	/**
	 * Retrieve the currently occupied cell
	 * @return the cell the player currently occupies
	 */
	public Cell getCurrentCell() {
		return this.currentCell;
	}
	
	/**
	 * Move the player to a new row
	 * @param the row the player will now occupy
	 */
	public void setCurrentRow(Row newRow) {
		// find index of cell in row
		int i = 0;
		for (Cell cell : this.currentRow.getCells()) {
			if (this.currentCell == cell) {break;}
			i++;
		}
		this.currentRow = newRow;
		// set cell to same cell index in new row
		setCurrentCell(this.currentRow.getCells().get(i));
	}
	
	/**
	 * Move the player to a new cell
	 * @param newCell the player will now occupy
	 */
	public void setCurrentCell(Cell newCell) {
		this.currentCell = newCell;
	}

	/**
	 * String representation of Player object
	 */
	@Override
	public String toString() {
		return "Player [currentCell=" + this.currentCell + ", currentRow=" + this.currentRow + "]";
	}

}
