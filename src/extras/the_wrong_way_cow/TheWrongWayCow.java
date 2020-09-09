//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.HashMap;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	int north = 0;
    	int south = 0;
    	int west = 0;
    	int east = 0;
    	HashMap<String, int[]> cows = new HashMap<String, int[]>();
    	//Check Facing North
    	for(int i = 0; i < field.length; i++) {
    		for(int j = 0; j < field[0].length; j++) {
    			if(field[i][j] == 'c') {
    				if(i+1  < field.length && field[i+1][j] == 'o') {
    					if(field[i+2][j] == 'w') {
    						north++;
    						System.out.println("Confirmed north cow " + north);
    						int[] northCow = {j, i};
    						cows.put("north cow", northCow);
    						if(south > 1 || west > 1 || east > 1 && north == 1) {
    							return northCow;
    						}
    						else if(north > 1 && west == 1) {
    							return cows.get("west cow");
    						}
    						else if(north > 1 && south == 1) {
    							return cows.get("south cow");
    						}
    						else if(north > 1 && east == 1) {
    							return cows.get("east cow");
    						}
    					}
    				}
    	//Check Facing West
    				else if(j+1 < field[0].length && field[i][j+1] == 'o') {
    					if(field[i][j+2] == 'w') {
    						west++;
    						System.out.println("Confirmed west cow " + west);
    						int[] westCow = {j, i};
    						cows.put("west cow", westCow);
    						if(south > 1 || north > 1 || east > 1 && west == 1) {
    							return westCow;
    						}
    						else if(west > 1 && north == 1) {
    							return cows.get("north cow");
    						}
    						else if(west > 1 && south == 1) {
    							return cows.get("south cow");
    						}
    						else if(west > 1 && east == 1) {
    							return cows.get("east cow");
    						}
    							}
    				}
    	//Check Facing South
    				else if(i-1 > 0 && field[i-1][j] == 'o') {
    					if(field[i-2][j] == 'w') {
    						south++;
    						System.out.println("Confirmed south cow " + south);
    						int[] southCow = {j, i};
    						cows.put("south cow", southCow);
    						if(north > 1 || west > 1 || east > 1 && south == 1) {
    							return southCow;
    						}
    						else if(south > 1 && north == 1) {
    							return cows.get("north cow");
    						}
    						else if(south > 1 && east == 1) {
    							return cows.get("east cow");
    						}
    						else if(south > 1 && west == 1) {
    							return cows.get("west cow");
    						}
    					}
    				}
    		
    	//Check Facing East
    				else if(j > field.length-1 && field[i][j-1] == 'o') {
    					System.out.println("East yes");
    					if(field[i][j-2] == 'w') {
    						east++;
    						System.out.println("Confirmed east cow " + east);
    						int[] eastCow = {j, i};
    						cows.put("east cow", eastCow);
    						if(south > 1 || west > 1 || north > 1 && east == 1) {
    							return eastCow;
    						}
    						else if(east > 1 && north == 1) {
    							return cows.get("north cow");
    						}
    						else if(east > 1 && south == 1) {
    							return cows.get("south cow");
    						}
    						else if(east > 1 && west == 1) {
    							return cows.get("west cow");
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	if(north == 1) {
    		System.out.println(cows.get("north cow"));
    		return cows.get("north cow");
    	}
    	else if(south == 1) {
    		System.out.println(cows.get("south cow"));
    		return cows.get("south cow");
    	}
    	else if(west == 1) {
    		System.out.println(cows.get("west cow"));
    		return cows.get("west cow");
    	}
    	else if(east == 1) {
    		System.out.println(cows.get("east cow"));
    		return cows.get("east cow");
    	}
    	
        return null;
    }

}
