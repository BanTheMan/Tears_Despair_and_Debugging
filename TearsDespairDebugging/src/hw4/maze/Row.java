package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	// declare class variables
	private ArrayList<Cell> cells = new ArrayList<Cell>();

	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public ArrayList<Cell> getCells() {
		return this.cells;
	}

	public void setCells(ArrayList<Cell> cellList) {
		this.cells = cellList;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Row [cells=[");
		
		for (Cell cell : this.cells) {
			string.append(cell.toString());
			string.append(", \n");
		}
		
		string.append("]]");
		
		return string.toString();
	}
	
	

}
