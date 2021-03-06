package implementation;

import java.util.Scanner;

public class textReverse {
	private static int count = 0;

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter a word to be reversed: ");
		String stringToReverse = input.nextLine();
		reverseString(stringToReverse);
	}

	public static void reverseString(String stringToReverse) {
		System.out.print(stringToReverse.charAt(stringToReverse.length()-1));
		count++;
		reverseString(stringToReverse, stringToReverse.length()-1);
	}

	public static void reverseString(String stringToReverse, int last){
		if(last >= 1){
			System.out.print(stringToReverse.charAt(last-1));
			count++;
			reverseString(stringToReverse, last-1);
		}else{
			System.out.println("\nNumber of characters: "+count);
			count = 0;
		}
	}
}