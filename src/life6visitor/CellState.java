package life6visitor;

import java.util.List;

public interface CellState {
	public CellState die();
	public CellState live();
	public boolean isAlive();
	//abstract method for the dead and alive classes to interact with visitors
	public void accept(LifeVisitor visitor, List<LifeCommand> commands, Cell c);
	
	
		
	
}
