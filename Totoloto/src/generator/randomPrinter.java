package generator;

//random "class"
import java.util.Random;

public class randomPrinter {
	
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
		
		System.out.println("Não pode repetir: ");
 		
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
			break; //if it returns true, it's a valid key. If it returns false, generate another one, cycle loops back.
		}
	}
	
	for(int i = 0; i<a.length; i++) {
		System.out.println(a[i]);
	}
	
	}
}
	
	