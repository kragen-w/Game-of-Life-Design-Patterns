package life6visitor;

import java.util.ArrayList;


public class GameOfLife{
		
	    
	    private ArrayList<LifeObserver> observers;
	    
	 
	    // rows and cols for the game
	    private int rows;
	    private int cols;
	    private Cell grid[][]; 
	   
	    
	    public GameOfLife(int rows, int cols) {
	        
	    	observers = new ArrayList<>();
	    	this.rows = rows;
			this.cols = cols;
			
			
			this.grid = new Cell[rows][cols];
			setupGrid(this.grid);

	        // Draw the initial board
	        notifyObservers();
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
	    
	    
	    
	   	public void advance() {
	   	setupGrid(grid);
	   	//the list of commands is created
	   		ArrayList<LifeCommand> commands = new ArrayList<>();
	   		//the standard visitor is created
	   		StandardLifeVisitor visitor = new StandardLifeVisitor();
	        for (int i = 0; i < rows; i++) {
	          for (int j = 0; j < cols; j++) {
	        	  
	        	  //for each cell in the grid, the visitor visits it, and passes along the list of commands
	        	  visitor.visit(grid[i][j], commands);
	        	  
	          }
	          
	       }
	        //for every command in the list, the command is executed
	        for (LifeCommand command: commands) {
	        	command.execute();
	        }
	        //each observer is notified of the changes
	        notifyObservers();
	    }
	   	
	   	//these two fucntion are unused, but serve to add and subract observers from the list
	   	
	   public void attach(LifeObserver o) {
		   observers.add(o);
	   }
	   
	   public void detatch(LifeObserver o) {
		   observers.remove(o);
	   }
		
	   public void notifyObservers() {
		 //this function goes through all of the observers in the list and updates them
		   //this would update each window of the game if there were mulpiple running
		   for (LifeObserver observer:observers) {
			  observer.updateObserver();
		   }
	   }
	 //these functions allow the game of life UI to access the rows and colums, and even specific
	   //cells in the list
	   
	   public int getRows() {
		   return rows;
	   }
	   public int getCols() {
		   return cols;
	   }
	   public Cell getCell(int row, int col) {
		   return grid[row][col];
	   }
	
	}
	        	
		
	        


