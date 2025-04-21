package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	// declare class variables
	private ArrayList<Cell> cells = new ArrayList<Cell>();

	public Row(ArrayList<Cell> cells) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cell> getCells() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCells(ArrayList<Cell> cellList) {
		// TODO Auto-generated method stub
		
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
