package life5observer;

public abstract class LifeObserver {
	//this abstract class parents the gameoflifeUI, it has an instance variable that is the game
	protected GameOfLife game;
	public LifeObserver(GameOfLife g) {
		this.game = g;
	}
	public abstract void updateObserver();
		
}
