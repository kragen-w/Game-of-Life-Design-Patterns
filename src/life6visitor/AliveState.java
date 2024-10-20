package life6visitor;

import java.util.List;

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
	//if the state is alive, then the visitor will use it's visit alive cell method
	public void accept(LifeVisitor visitor, List<LifeCommand> commands, Cell c) {
		visitor.visitLiveCell(c, commands);
		
	}
	
	

	
	 
}