package life6visitor;

public class LiveCommand extends LifeCommand{
	public LiveCommand(Cell c) {
		super(c);
	}
	//the cell lives when executed
	public void execute() {
		cell.live();
	}
	
	
}
