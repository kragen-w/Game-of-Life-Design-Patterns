package life6visitor;

public abstract class LifeCommand {
	//abstract class that parents both live and die commands, has an instance variable of a cell
	protected Cell cell;
	public LifeCommand(Cell c) {
		this.cell = c;
	}
	public abstract void execute();
}
