package generator;

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
	
	public static boolean checkunique(int[] key) {
		int temp;
		
		for(int c = 0; c < key.length; c++) {
			
			temp = key[c];
			
			for(int d = 0; d < key.length; d++) {
				if(temp == key[d] && d != c) {
					//this means a repeated number was found in the key, so, we're going to have to generate a new one until this does not happen..
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		//1. Generate 6 random numbers between 1 and 49 and print them.
		
		Random randomnumber = new Random(); //object of type Random
		int rand;
		int[] a = new int[6];
		
		// Getting the value of N for step 4
		
		int N;
		
		Scanner keyboard = new Scanner(System.in);
		
		try {
		
		System.out.print("Valor de N: ");
		
		N = keyboard.nextInt();
		
		}
		
		catch(InputMismatchException exception) {
			System.out.print("The value you typed in for N is not an integer.");
			return;
		}
		
		if(N < 0) {
			System.out.print("The value you typed in for N is negative, it must be positive.");
			return;
		}
		
		int[][] matrix = new int[N][6];
		
		System.out.println("Não pode repetir: ");

while(true) {
	
for(int z = 0; z < N; z++) {
	while(true) {
		
		for(int i = 0; i<=5; i++) {
			rand = randomnumber.nextInt(49);
			
			//you don't want 0 though if it's 0, it's actually 1, also saving into array for later.
			if(rand == 0) {
				a[i] = rand + 1;
			} else {
				a[i] = rand; 
			}
		}
		
		if(checkunique(a)) {
			
			//if it's valid key, add to matrix
			
			//each iteration changes a column of the matrix (adds a key) up to the value of N.
			//the matrix initially starts with N keys all set to 000000.
			
			//before adding to the matrix, sort it out.
			Arrays.sort(a);
			
			/*
			for(int k = 0; k < 6; k++) {
				matrix[z][k] = a[k];
			}*/
			
			matrix[z] = a.clone();
			
			break; //if it returns true, it's a valid key. If it returns false, generate another one, cycle loops back.
		}
	}
}
	if(checkbets(matrix, N)) {
		//if it returns true, valid matrix.
		break;
	}
}
		
	for(int i = 0; i<N; i++) {
		for(int j = 0; j<6; j++) {
			System.out.println(matrix[i][j]);
		}
		
		System.out.println(" ");
	}
	
	}
}
	
	