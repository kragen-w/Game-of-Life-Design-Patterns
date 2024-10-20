package life2state;

public class DeadState implements CellState{

	public CellState die() {
		return this;
		
	}

	public CellState live() {
		return new AliveState();
		
	}

	public boolean isAlive() {
		return false;
	}
	
	
		
		
}
	 

