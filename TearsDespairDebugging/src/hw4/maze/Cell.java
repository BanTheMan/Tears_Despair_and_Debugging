package hw4.maze;

public class Cell {
	
	// declare class variables
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		// TODO Auto-generated constructor stub
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public CellComponents getRight() {
		// TODO Auto-generated method stub
		return right;
	}

	public CellComponents getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	public CellComponents getDown() {
		// TODO Auto-generated method stub
		return down;
	}
	
	public CellComponents getUp() {
		// TODO Auto-generated method stub
		return up;
	}
	
	// Verify new components abide by rules

	public void setUp(CellComponents newUpComponent) {
		// TODO Auto-generated method stub
		this.up = newUpComponent;
	}

	public void setDown(CellComponents newDownComponent) {
		// TODO Auto-generated method stub
		this.up = newDownComponent;
	}

	public void setLeft(CellComponents newLeftComponent) {
		// TODO Auto-generated method stub
		this.up = newLeftComponent;
	}

	public void setRight(CellComponents newRightComponent) {
		// TODO Auto-generated method stub
		this.right = newRightComponent;
	}

	@Override
	public String toString() {
		return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	}
	
	

}
