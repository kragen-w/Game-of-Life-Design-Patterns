package life6visitor;

import java.util.List;

public class StandardLifeVisitor extends LifeVisitor{

	//this visitor impliments the normal set of rules for the game of life
	public void visitLiveCell(Cell e, List<LifeCommand> commands) {
		if (e.nbrAliveNeighbors() == 2 || e.nbrAliveNeighbors() == 3){
			//a live command appended to the list, only if the alive cell has 2 or 3 neigbors
			  commands.add(new LiveCommand(e));
  	  }
  	  else {
		  //a die command is appended to the list, if the alive cell doesnt have 2 or 3 neighbors
  		  commands.add(new DieCommand(e));
  	  }
		
	}

	public void visitDeadCell(Cell e, List<LifeCommand> commands) {
		if (e.nbrAliveNeighbors() == 3) {
  		  //a live command appended to the list, only if the dead cell has 3 neigbors        			  

			  commands.add(new LiveCommand(e));
		  }
		
	}

	
}
