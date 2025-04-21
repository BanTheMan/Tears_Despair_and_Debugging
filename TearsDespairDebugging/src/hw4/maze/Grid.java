package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	// declare class variables
	private ArrayList<Row> rows = new ArrayList<>();

	public Grid(ArrayList<Row> rows) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Row> getRows() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRows(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Grid [rows=[");
		
		for (Row row : this.rows) {
			string.append(row.toString());
			string.append(", ");
		}
		
		string.append("]]");
		
		return string.toString();
	}
	
	

}
