package life6visitor;

import java.util.List;

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

	//if the state is dead, then the visitor will use it's visit dead cell method
	public void accept(LifeVisitor visitor, List<LifeCommand> commands, Cell c) {
		visitor.visitDeadCell(c, commands);
		
	}
	
	
	
		
		
}
	 

