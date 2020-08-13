package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		selectNextPath(Maze.cells[randGen.nextInt(width)][randGen.nextInt(height)]);
		
		//5. call selectNextPath method with the randomly selected cell
		
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> uvNeighbors = new ArrayList<Cell>();
		//C. if has unvisited neighbors,
			uvNeighbors.addAll(getUnvisitedNeighbors(currentCell));
			//C1. select one at random.
			Random randy = new Random();
			int holder = randy.nextInt(uvNeighbors.size());

			//C2. push it to the stack
			uncheckedCells.push(uvNeighbors.get(holder));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, uvNeighbors.get(holder));
			//C4. make the new cell the current cell and mark it as visited
			currentCell = uvNeighbors.get(holder);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
			
		//D. if all neighbors are visited
		if()
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
