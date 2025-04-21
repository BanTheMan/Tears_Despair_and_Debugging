package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	// declare class variables
	private ArrayList<Row> rows = new ArrayList<>();

	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

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
