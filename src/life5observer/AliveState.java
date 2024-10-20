package life5observer;

public class AliveState implements CellState{
	private static AliveState state;
	
	public static AliveState create() {
		if (state == null) {
			state = new AliveState();
		
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
		return true;
		
	}

	
	 
}