package urgeToMerge;


import java.util.Scanner;


/**
 * Main class of Urge to Merge game.
 * This class contains the main method and is currently
 * being used to test features of the application.
 * 
 * @author Andy Rock
 * @version 1.0 January 6, 2016
**/
public class Main
{
	/**
	 * Initial testing
	**/
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to Urge to Merge!");
		System.out.print("Hit enter to begin...");
		in.nextLine();

		in.close();
	}
}