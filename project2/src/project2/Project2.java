package project2;

import java.util.Scanner;

/**
 * Asks user to select a job, an integer, then it loops
 * @author Justin Homme
 *@version Spring 2021
 */
public class Project2 {
	/**
	 * prints out the factors of x
	 * within the method itself (no return value)
	 * @param x enter a positive integer (x)
	 */
	static void factors(int x) {
		System.out.println("The factors of " + x + " are: ");
		int z = 0;
		for(int i = 1; i <= x; i++) { // loops to divide x by each integer from 1 to (and including) x
			if((x % i) == 0) { // if x % i is 0 then we know i goes into x evenly and is a factor
				System.out.println(x / i); // when i is determined to be a factor it is printed out in a list
				z++; // for every factor, z gains a value of 1 
			}
		}
		if(z > 2) {
			System.out.println(x + " is not prime."); // if z is greater than 2, it has more than 2 factors (not prime)
		}
		else {
			System.out.println(x + " is prime."); // if z only has 2 factors, it is prime
		}
	}
	/**
	 * calculates the nth harmonic of the integer x
	 * @param x input a positive integer (x) 
	 * @return answer as a double for the main method to print
	 */
	static double harmonic(int x) { // double instead of void since it returns a double
		double answer = 0; // answer created outside of the loop so it can be returned
		for(double i = 1; i <= x; i++) { // initialize i as a double to make sure 1/i makes a double
			answer = answer + (1/i);
		}
		return answer; // returns answer to be called by main
	}
	/**
	 * determines whether the input (x) is a perfect number and returns a boolean value for main to use
	 * @param x input a positive integer
	 * @return answer a boolean (true if x is a perfect number and false if x is not)
	 */
	static boolean perfect(int x) { // method type is boolean to return a true or false 'answer'
		boolean answer;
		int z = 0;
		for(int i = 2; i <= x; i++) { // i starts at 2 instead of 1 in order to prevent the value of x from being added
			if(x % i == 0) {
				z += (x / i); // if i started at 1, the first cycle would add x/1 to z; instead, z contains all factors but x itself
			}
		}
			if(z == x) { // compares z to x since a perfect number would cause the sum of its factors (except x) to equal x
				answer = true; 
			}
			else { // if z is not equal to x it is not perfect so no need for comparison
				answer = false; 
			}
		return answer; // returns 'answer' 
	}
	/**
	 * The Main method which handles all input and calls other methods
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = 1; // 'n' set to 1 so it won't immediately terminate the while loop
		int x;
		
		while(n != 0) { // will loop until the condition (n != 0) is broken. when the user inputs 0, the loop ends
			System.out.println("Please choose an option:");
			System.out.println("0: Quit");
			System.out.println("1: Print the factors of an input number");
			System.out.println("2: Find the nth harmonic number");
			System.out.println("3: Determine whether a number is a perfect number");
			
			n = input.nextInt();{ // user inputs a value to select their option
			
				switch(n) {
				case 0: // this prevents an input of 0 from activating the 'default' of the switch
					break;
				case 1:
					System.out.println("Please enter a positive integer"); // this prompt is in all three cases because each 'break's
					x = input.nextInt(); // assigns the integer input to x
					factors(x); // calls the method 'factors' with x as the parameter
					break;
				case 2: 
					System.out.println("Please enter a positive integer");
					x = input.nextInt();
					switch(x) { // determines the ending for each x value (example: 1st vs 2nd vs 3rd vs 4th, 5th etc.)
					case 1:
						System.out.println("The " + x + "st harmonic number is " + harmonic(x)); // calls harmonic to return a double
						break;
					case 2:
						System.out.println("The " + x + "nd harmonic number is " + harmonic(x));
						break;
					case 3:
						System.out.println("The " + x + "rd harmonic number is " + harmonic(x));
						break;
					default: // anything above x = 4 is assumed to have a 'th' ending
						System.out.println("The " + x + "th harmonic number is " + harmonic(x));
						break; // final break in the inside switch
					}	
					break; // break for the case 2 of the outside switch
				case 3:
					System.out.println("Please enter a positive integer");
					x = input.nextInt();
					if(perfect(x) == true) { // calls the method 'perfect' to return a true or false boolean value
						System.out.println(x + " is a perfect number.");
					}
					else { // if the returned value is not true, it must be false
						System.out.println(x + " is not a perfect number.");
					}
					break;
				default: // if the user inputs any number which is not an option they will be told is is invalid and the loop will continue
					System.out.println("That is not a valid option");
					break;
				}
			}
		}
		System.out.println("Goodbye"); // if the loop ends (with n = 0) the user is issued a goodbye 
		input.close(); // closes the Scanner input since the loop is over and it will not be used again
	}
}
