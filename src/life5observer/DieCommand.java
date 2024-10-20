package life5observer;

public class DieCommand extends LifeCommand{
	public DieCommand(Cell c) {
		super(c);
	}
	//the cell dies when executed
	public void execute() {
		cell.die();
	}
	
}
