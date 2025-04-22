package hw4.maze;

import java.util.ArrayList;

/**
 * Author: Ivan Rhodes
 */
public class Row {
	
	// declare class variables
	private ArrayList<Cell> cells;

	/**
	 * Row constructor
	 * @param cells ArrayList in row
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Retrieve cells in row
	 * @return ArrayList of cells
	 */
	public ArrayList<Cell> getCells() {
		return this.cells;
	}

	/**
	 * Change cells in row
	 * @param cellList ArrayList to set cells in row to
	 */
	public void setCells(ArrayList<Cell> cellList) {
		this.cells = cellList;
	}

	/**
	 * String representation of Row
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Row [cells=[");
		
		for (Cell cell : this.cells) {
			string.append(cell.toString());
			if (cell != this.cells.getLast()) {string.append(", ");}
		}
		
		string.append("]]");
		
		return string.toString();
	}
	
	

}
