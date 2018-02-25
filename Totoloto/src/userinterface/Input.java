package userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

import generator.Bet;
import generator.randomPrinter;

public class Input {

	public static void main(String[] args) {
		int N;
		String bettype;
		String simple = "Simple";
		String multiple = "Multiple";
		Scanner keyboard = new Scanner(System.in);
		int matrix[][];
		int apostaseq;
		
		System.out.print("Type of bet (Simple or Multiple): ");
		
		bettype = keyboard.nextLine();
		
		if(bettype.equals(simple)) {
			
			System.out.print("Number of bets to generate (maximum 10): ");
			
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
			
			if(N > 10) {
				System.out.println("You can only go up to 10 bets.");
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
			
			System.out.println("And the Lucky Number: ");
			System.out.print(matrix[N][5]);
			
		} else if (bettype.equals(multiple)) {
			
			System.out.print("How many numbers for the bet (4,6,7,8,9,10,11): ");
			
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
			
			switch(N) {
			
			case 4:
				apostaseq = 45;
				break;
				
			case 7:
				apostaseq = 21;
				break;
				
			case 6:
				apostaseq = 6;
				break;
				
			case 8:
				apostaseq = 56;
				break;
				
			case 9:
				apostaseq = 126;
				break;
			
			case 10:
				apostaseq = 252;
				break;
			
			case 11:
				apostaseq = 462;
				break;
				
			default:
				System.out.println("You didn't select a valid number for the bet.");
				return;
			}
			
			Bet bet = new Bet(N, bettype);
			
			matrix = randomPrinter.generatelogic(N, bet).clone();
			
			//you can have 1 multiple bet, with N elements.
			for(int j = 0; j<N; j++) {
				System.out.println(matrix[0][j]);
			}
			
			System.out.println(" ");
				
			System.out.println("And the Lucky Number: ");
			System.out.print(matrix[1][N]);
			
			System.out.println(" ");
			
			System.out.println("This was equivalent to this number of normal bets: ");
			System.out.print(apostaseq);
		}
		
		else {
			System.out.println("Invalid. Must be 'Simple' or 'Multiple'.");
			return;
		}

	}

}
