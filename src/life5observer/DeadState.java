package life5observer;

public class DeadState implements CellState{
	private static DeadState state;
	
	public static DeadState create() {
		if (state == null) {
			state = new DeadState();
		}
		return state;
	}
	
	
	public CellState die() {
		return DeadState.create();
		
	}

	public CellState live() {
		return AliveState.create();
		
	}

	public boolean isAlive() {
		return false;
	}
	
	
		
		
}
	 

