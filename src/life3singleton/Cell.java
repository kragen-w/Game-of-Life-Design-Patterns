package life3singleton;
import java.util.List;
import java.util.ArrayList;



public class Cell {

	public CellState state;
	public List<Cell> neighbors;
	public Cell() {
		state = DeadState.create();
		neighbors  = new ArrayList<Cell>(); 
		
		
	}
	
	public void die() {
		state = state.die();
	}
	public void live() {
		state = state.live();
	}
	
	public boolean isAlive() {
		return state.isAlive();
	}
	
	public void addNeighbor(Cell neighborCell) {
		neighbors.add(neighborCell);
	}
	
	public int nbrAliveNeighbors() {
		return neighbors.size();
	}
	
}
