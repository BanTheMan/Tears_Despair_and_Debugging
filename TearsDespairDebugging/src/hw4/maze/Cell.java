package hw4.maze;

public class Cell {
	
	// declare class variables
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public CellComponents getRight() {
		
		return this.right;
	}

	public CellComponents getLeft() {
		
		return this.left;
	}

	public CellComponents getDown() {
		
		return this.down;
	}
	
	public CellComponents getUp() {
		
		return this.up;
	}
	
	// Verify new components abide by rules

	public void setUp(CellComponents newUpComponent) {
		this.up = (newUpComponent != null) ? newUpComponent : CellComponents.WALL;
	}

	public void setDown(CellComponents newDownComponent) {
		this.down = (newDownComponent != null) ? newDownComponent : CellComponents.WALL;
	}

	public void setLeft(CellComponents newLeftComponent) {
		this.left = (newLeftComponent != null) ? newLeftComponent : CellComponents.WALL;
	}

	public void setRight(CellComponents newRightComponent) {
		this.right = (newRightComponent != null) ? newRightComponent : CellComponents.WALL;
	}

	@Override
	public String toString() {
		return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	}
	
	

}
