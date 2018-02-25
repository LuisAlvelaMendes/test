package userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

import generator.Bet;
import generator.randomPrinter;

public class Input {

	public static void main(String[] args) {
		int N;
		String bettype;
		Scanner keyboard = new Scanner(System.in);
		int matrix[][];
		
		System.out.println("Type of bet (Simple or Multiple): ");
		
		bettype = keyboard.nextLine();
		
		if(bettype == "Simple") {
			
			System.out.println("Number of bets to generate: ");
			
			try {
			
			N = keyboard.nextInt();
			
			}
			
			catch(InputMismatchException exception) {
				System.out.println("The value you typed in is not an integer.");
				return;
			}
			
			if(N < 0) {
				System.out.println("The value you typed in is negative, it must be positive.");
				return;
			}
			
			Bet bet = new Bet(5, bettype);
			
			matrix = randomPrinter.generatelogic(N, bet).clone();
			
			for(int i = 0; i<N; i++) {
				//you can have N simple bets, each bet will always have 5 elements.
				for(int j = 0; j<5; j++) {
					System.out.println(matrix[i][j]);
				}
				
				System.out.println(" ");
			}
			
		} else if (bettype == "Multiple") {
			
			System.out.println("How many numbers for the bet: ");
			
			try {
				
			N = keyboard.nextInt();
			
			}
			
			catch(InputMismatchException exception) {
				System.out.println("The value you typed in is not an integer.");
				return;
			}
			
			if(N < 0) {
				System.out.println("The value you typed in is negative, it must be positive.");
				return;
			}
			
			Bet bet = new Bet(N, bettype);
			
			matrix = randomPrinter.generatelogic(N, bet).clone();
			
			//you can have 1 multiple bet, with N elements.
			for(int j = 0; j<N; j++) {
				System.out.println(matrix[0][j]);
			}
				
			System.out.println(" ");
		}
		
		else {
			System.out.println("Invalid. Must be 'Simple' or 'Multiple'.");
			return;
		}

	}

}
