package life4command;

import java.awt.Color;
import java.util.ArrayList;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;


// Game of life main application using DuDraw
// Use mouse clicks to toggle cells
// Use space bar to advance game

public class GameOfLifeApp implements DrawListener {
	// width and height in pixels
	private int width;
    private int height;
    private Draw window;
    
 
    // rows and cols for the game
    private int rows;
    private int cols;
    private Cell grid[][]; 
   
    
    public GameOfLifeApp(String title, int rows, int cols, int width, int height) {
        
    	// Save the instance variables
    	this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;
		
		this.grid = new Cell[rows][cols];
		setupGrid(this.grid);
		
         
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
 		
        int cellWidth = width / cols;
        int cellHeight = height / rows;
     
        for (int i = 0; i <= rows; i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= cols; i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
     
    private void setupGrid(Cell[][] g) {
    	if (g[0][0] == null) {
    		for (int i = 0; i < cols; i++) {
            	for (int j = 0; j < rows; j++) {
            		g[i][j] = new Cell();
            		
            	}
        
            }
    	}
    	else {
    		
    		for (int i = 0; i < cols; i++) {
            	for (int j = 0; j < rows; j++) {
            		grid[j][i].neighbors.clear();
                    int x = 0;
                    int y = j - 1;
                    if (y < 0) {
                        y = rows - 1;
                    }
                    for (int rCt = 1; rCt <= 3; rCt++) {
                        x = i - 1;
                        if (x < 0) {
                            x = cols - 1;
                        }
                        for (int cCt = 1; cCt <= 3; cCt++) {
                            if (x != i || y != j) {
                                if (grid[y][x].isAlive()) {
                                    grid[j][i].addNeighbor(grid[y][x]);;
                                }
                            }
                            x = (x + 1) % cols;
                        }
                        y = (y + 1) % rows;
                    }
                    
            	}
            }
    	}
    
    }
    
    
    private void drawLives() {
    	int cellWidth = width / cols;
        int cellHeight = height / rows;
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (grid[i][j].isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }
   

   	public void advance() {
   	setupGrid(grid);
   	//the list of commands is created
   		ArrayList<LifeCommand> commands = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
        	  
        	  if (grid[i][j].isAlive()) {
        		  if (grid[i][j].nbrAliveNeighbors() == 2 || grid[i][j].nbrAliveNeighbors() == 3){
            		  //a live command appended to the list, only if the alive cell has 2 or 3 neigbors
        			  commands.add(new LiveCommand(grid[i][j]));
            	  }
            	  else {
            		  //a die command is appended to the list, if the alive cell doesnt have 2 or 3 neighbors
            		  commands.add(new DieCommand(grid[i][j]));
            	  }
        	  }
        	  else {
        		  
        		  if (grid[i][j].nbrAliveNeighbors() == 3) {
            		  //a live command appended to the list, only if the dead cell has 3 neigbors        			  
        			  commands.add(new LiveCommand(grid[i][j]));
        		  }
        		  
        	  }
        	  
          }
          
       }
        //for every command in the list, the command is executed
        for (LifeCommand command: commands) {
        	command.execute();
        }
        update();
    }

    // Below are the mouse/key listeners
    
	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / cols;
        int cellHeight = height / rows;
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
       
        if (grid[cellLocRow][cellLocCol].isAlive()) {
        	grid[cellLocRow][cellLocCol].die();
        }
        else {
        	grid[cellLocRow][cellLocCol].live();
        }
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
	}
//	public void toString(Cell[][] g) {
//		for (int i = cols-1; i >= 0; i--) {
//        	for (int j = 0; j < rows; j++) {
//        		System.out.print(g[i][j].nbrAliveNeighbors());
//        	}
//        	System.out.println("");
//		}
//	}
}
        	
	
        
