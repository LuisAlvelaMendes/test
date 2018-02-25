package generator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class randomPrinter {
	
	public static boolean checkbets(int[][] matrix, int N) {
		
		int temp[] = new int[6];
		
		for(int a = 0; a<N; a++) {
			
			temp = matrix[a].clone();
			
			for(int j = 0; j < N; j++) {
				if(temp.equals(matrix[j]) && a != j) {
					//found two bets that are the same!
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean checkunique(int[] key, int size) {
		int temp;
		
		for(int c = 0; c < size; c++) {
			
			temp = key[c];
			
			for(int d = 0; d < size; d++) {
				if(temp == key[d] && d != c) {
					//this means a repeated number was found in the key, so, we're going to have to generate a new one until this does not happen..
					return false;
				}
			}
		}
		
		return true;
	}

	public static int[][] generatelogic(int number, Bet bet) {
		
		//1. Generate random numbers between 1 and 49 and print them.
		
		Random randomnumber = new Random(); //object of type Random
		int rand;
		int N = 0;
		String simple = "Simple";
		String multiple = "Multiple";
		
		//Bet can be either simple or multiple
		//In case it's simple, N becomes the amount of bets to generate like before.
		//If it is multiple, N becomes 1 (only one bet) but the inner for cycle will have bet.size()
		
		if(bet.getType().equals(simple)) {
			//amount of bets to generate
			N = number;
		}
		
		if(bet.getType().equals(multiple)) {
			N = 1;
		}
		
		//matrix that holds bets
		int[][] matrix = new int[N+1][bet.getSize()+1];

while(true) {
	
for(int z = 0; z < N; z++) {
	while(true) {
		
		for(int i = 0; i<bet.getSize(); i++) {
			rand = randomnumber.nextInt(50);
			
			//you don't want 0 though if it's 0, it's actually 1, also saving into array for later.
			if(rand == 0) {
				bet.setNumber(rand + 1, i);
			} else {
				bet.setNumber(rand, i); 
			}
		}
		
		if(checkunique(bet.getNumbers(), bet.getSize())) {
			
			//if it's valid key, add to matrix
			
			//each iteration changes a column of the matrix (adds a key) up to the value of N.
			//the matrix initially starts with N keys all set to 000000.
			
			//before adding to the matrix, sort it out.
			
			//bet.sortNumbers();
			
			matrix[z] = bet.getNumbers().clone();
			
			break; //if it returns true, it's a valid key. If it returns false, generate another one, cycle loops back.
		}
	}
}
	if(checkbets(matrix, N)) {
		//if it returns true, valid matrix.
		break;
	}
}

	//now we have to generate the extra lucky number from 1 to 13
	int luckynumber = 0;
	
	rand = randomnumber.nextInt(14);
	
	//you don't want 0 though if it's 0, it's actually 1, also saving into array for later.
	if(rand == 0) {
		luckynumber = 1;
	} else {
		luckynumber = rand;
	}
	
	//we will place this number at the end of matrix
	
	matrix[N][bet.getSize()] = luckynumber;

	return matrix;
	
	}
}
	
	