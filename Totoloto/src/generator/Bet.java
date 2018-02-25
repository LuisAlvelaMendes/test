package generator;

import java.util.Arrays;

public class Bet {
	private int size;
	private int numbers[] = new int[49];
	private String type;

	public Bet(int sizearray, String bettype) {
		// TODO Auto-generated constructor stub
		
		//this is only here in case you make a mistake and try to create a simple bet with more than 5 numbers.
		if(type == "Simple") {
			sizearray = 5;
		}
		
		size = sizearray;
		type = bettype;
	}
	
	public void setNumber(int item, int i) {
		numbers[i] = item;
	}
	
	public int[] getNumbers() {return numbers;};
	
	public String getType() {return type;};
	
	public int getSize() {return size;};
	
	//public void sortNumbers() {Arrays.sort(numbers);};
}
