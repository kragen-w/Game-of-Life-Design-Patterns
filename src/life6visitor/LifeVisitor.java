package life6visitor;

import java.util.List;

public abstract class LifeVisitor {
	//visitor abstract that takes in a cell and a list of commands
	public void visit(Cell c, List<LifeCommand> commands) {
		c.accept(this, commands);
	}
	//abstract methods that each type of visitor will see
	public abstract void visitLiveCell(Cell e, List<LifeCommand> commands); 
	public abstract void visitDeadCell(Cell e, List<LifeCommand> commands);
}
