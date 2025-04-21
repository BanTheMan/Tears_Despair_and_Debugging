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
		if(newUpComponent == null) {
			this.up = CellComponents.Wall; 
		}
		this.up = newUpComponent;
	}

	public void setDown(CellComponents newDownComponent) {
		if(newDownComponent == null) {
			this.down = CellComponents.Wall; 
		}
		this.down = newDownComponent;
	}

	public void setLeft(CellComponents newLeftComponent) {
		if(newLeftComponent == null) {
			this.left = .Wall; 
		}
		this.left = newLeftComponent;
	}

	public void setRight(CellComponents newRightComponent) {
		if(newRightComponent == null) {
			this.right = CellComponents.Wall; 
		}
		this.right = newRightComponent;
	}

	@Override
	public String toString() {
		return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	}
	
	

}
