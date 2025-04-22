package hw4.maze;

/**
 * Author: Ivan Rhodes
 * Cell class for maze implementation
 */
public class Cell {
	
	// declare class variables
	private CellComponents left, right, up, down;

	/**
	 * Cell constructor
	 * @param left side component of cell
	 * @param right side component of cell
	 * @param up (top) side component of cell
	 * @param down (bottom) side component of cell
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	/**
	 * Retrieve right side component of cell
	 * @return cell component
	 */
	public CellComponents getRight() {
		
		return this.right;
	}

	/**
	 * Retrieve left side component of cell
	 * @return cell component
	 */
	public CellComponents getLeft() {
		
		return this.left;
	}

	/**
	 * Retrieve down (bottom) side component of cell
	 * @return cell component
	 */
	public CellComponents getDown() {
		
		return this.down;
	}
	
	/**
	 * Retrieve up (top) side component of cell
	 * @return cell component
	 */
	public CellComponents getUp() {
		
		return this.up;
	}
	
	// Verify new components abide by rules

	/**
	 * Change up (top) side component of cell
	 * @param newUpComponent = cell component to change up (top) side to.
	 */
	public void setUp(CellComponents newUpComponent) {
		this.up = (newUpComponent != null) ? newUpComponent : CellComponents.WALL;
	}

	/**
	 * Change down (bottom) side component of cell
	 * @param newDownComponent = cell component to change down (bottom) side to.
	 */
	public void setDown(CellComponents newDownComponent) {
		this.down = (newDownComponent != null) ? newDownComponent : CellComponents.WALL;
	}

	/**
	 * Change left side component of cell
	 * @param newLeftComponent = cell component to change left side to.
	 */
	public void setLeft(CellComponents newLeftComponent) {
		this.left = (newLeftComponent != null) ? newLeftComponent : CellComponents.WALL;
	}

	/**
	 * Change right side component of cell
	 * @param newRightComponent = cell component to change right side to.
	 */
	public void setRight(CellComponents newRightComponent) {
		this.right = (newRightComponent != null) ? newRightComponent : CellComponents.WALL;
	}

	/**
	 * String representation of the Cell class
	 */
	@Override
	public String toString() {
		return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	}
	
	

}
