package hw4.maze;

import java.util.ArrayList;

/**
 * Author: Ivan Rhodes
 */
public class Grid {
	
	// declare class variables
	private ArrayList<Row> rows = new ArrayList<>();

	/**
	 * Grid constructor
	 * @param rows ArrayList in Grid
	 */
	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	/**
	 * Retrieve rows in Grid
	 * @return ArrayList of rows
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

	/**
	 * Change rows in Grid
	 * @param rows ArrayList to set rows in grid to
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * String representation of Grid
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Grid [rows=[");
		
		for (Row row : this.rows) {
			string.append(row.toString());
			if (row != this.rows.getLast()) {string.append(", ");}
		}
		
		string.append("]]");
		
		return string.toString();
	}
	
	

}
