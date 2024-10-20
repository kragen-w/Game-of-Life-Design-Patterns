package life2state;

public class AliveState implements CellState{

	
	public CellState die() {
		
		return new DeadState();
		
	}

	
	public CellState live() {
		return this;
		
	}

	
	public boolean isAlive() {
		return true;
		
	}

	
	 
}