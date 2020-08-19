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
		currentCell.setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> uvNeighbors = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if(uvNeighbors.size() > 0) {
			//C1. select one at random.
			Random randy = new Random();
			int holder = randy.nextInt(uvNeighbors.size());

			//C2. push it to the stack
			uncheckedCells.push(uvNeighbors.get(holder));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, uvNeighbors.get(holder));
			//C4. make the new cell the current cell and mark it as visited
			currentCell = uvNeighbors.get(holder);
			currentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		else {
			//D1. if the stack is not empty
			if (!uncheckedCells.isEmpty()) {
				// D1a. pop a cell from the stack
				currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
				
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
	}
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		System.out.println("Wall Removal");
		if(c1.getX() + 1 == c2.getX()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
			System.out.println("Removed East Wall");
		}
		else if(c1.getX() - 1 == c2.getX()) {
			c1.setWestWall(false);
			c2.setEastWall(false);
			System.out.println("Removed West Wall");
		}
		else if(c1.getY() + 1 == c2.getY()) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
			System.out.println("Removed South Wall");
		}
		else if(c1.getY() - 1 == c2.getY()) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
			System.out.println("Removed North Wall");
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> holder = new ArrayList<Cell>();
		if(c.getX() < width-1) {
			if(!Maze.cells[c.getX()+1][c.getY()].hasBeenVisited()) {
				holder.add(Maze.cells[c.getX()+1][c.getY()]);
			}
		}
		if(c.getX() > 0) {
			if(!Maze.cells[c.getX()-1][c.getY()].hasBeenVisited()) {
				holder.add(Maze.cells[c.getX()-1][c.getY()]);
			}
		}
		if(c.getY() < height-1) {
			if(!Maze.cells[c.getX()][c.getY()+1].hasBeenVisited()) {
				holder.add(Maze.cells[c.getX()][c.getY()+1]);
			}
		}
		if(c.getY() > 0) {
			if(!Maze.cells[c.getX()][c.getY()-1].hasBeenVisited()) {
				holder.add(Maze.cells[c.getX()][c.getY()-1]);
			}
		}
		return holder;
	}
}
