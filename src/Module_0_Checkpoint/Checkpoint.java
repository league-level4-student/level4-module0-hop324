package Module_0_Checkpoint;

import java.util.Random;

public class Checkpoint {
	public static void main(String [] args) {	
		int[][] array = new int[5][5];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				Random randy = new Random();
				array[i][j] = randy.nextInt(100);
			}
		}
		printArray(array);
	}
	
	public static void printArray(int[][] ints) {
		for(int i = 0; i < ints.length; i++) {
			for(int j = 0; j < ints.length; j++) {
				System.out.println(ints[i][j]);
			}
		}
	}
}
