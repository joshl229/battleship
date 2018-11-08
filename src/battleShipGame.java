import java.util.Scanner;
public class battleShipGame
{
	public static void main(String args[])
	{
		// Creates the scanner for user input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose your difficulty:\n1) Hard\n2) Easy");
		
		// Chooses the difficulty
		int difficulty = input.nextInt();
		int turns;
		
		if (difficulty == 1)
			turns = 3;
		else
			turns = 5;
		
		// Creates a battleship board and displays it
		battleShipBoard Board = new battleShipBoard();
		System.out.println(Board);
		
		
		// Creates the 2D Array that will be used for the users input
		int [][] guess = new int [1][2];
		
		// Creates a loop that will allow the user to guess and will display the board
		while(turns != 0)
		{
			System.out.println("Enter the row:");
			guess[0][0] = input.nextInt();
			
			System.out.println("Enter the column");
			guess[0][1] = input.nextInt();
			
			Board.placeOrError(guess);
			System.out.println(Board);
			
			turns-=1;
		}
		
		if (Board.winOrLose())
		{
			System.out.println("Congrats on winning!");
		}
		else
		{
			System.out.println("You lost!");
		}
		
	}
}
