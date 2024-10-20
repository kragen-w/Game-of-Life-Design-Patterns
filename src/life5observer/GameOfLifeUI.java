package life5observer;

import java.awt.Color;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameOfLifeUI extends LifeObserver implements DrawListener{
	
	// width and height in pixels
	private int width;
    private int height;
    private Draw window;

 
    // rows and cols for the game

    
    
    public GameOfLifeUI(String title, int width, int height, GameOfLife g) {
        
    	// Save the instance variables
    	super(g);
    	
		this.width = width;
		this.height = height;
		
		//the ui itself is attatched to the game of life
		g.attach(this);
		
         
        // Setup the DuDraw board
        window = new Draw(title);
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);
       
		// Add the mouse/key listeners
        window.addListener(this);
        
        // Draw the initial board
	    update();
    }
    
	    
	private void drawGrid() {
	        
    	window.setPenColor(Color.black);
 		
        int cellWidth = width / game.getCols();
        int cellHeight = height / game.getRows();
     
        for (int i = 0; i <= game.getRows(); i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= game.getCols(); i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
	private void drawLives() {
    	int cellWidth = width / game.getCols();
        int cellHeight = height / game.getRows();
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < game.getRows(); i++) {
        	for (int j = 0; j < game.getCols(); j++) {
        		if (game.getCell(i, j).isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }
	public void keyReleased(int key) {
		// Do nothing
	}

	public void keyTyped(char key) {
		// Do nothing
	}

	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / game.getCols();
        int cellHeight = height / game.getRows();
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
       
        if (game.getCell(cellLocRow, cellLocCol).isAlive()) {
        	game.getCell(cellLocRow, cellLocCol).die();
        }
        else {
        	game.getCell(cellLocRow, cellLocCol).live();
        }
		update();        
	}

	public void mouseReleased(double x, double y) {
		// Do nothing
	}
	
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
	}
	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			game.advance();
		}
	}


	@Override
	public void updateObserver() {
		// The updateObserver function just calls the already existing update function of the UI
		update();
		
	}
}
