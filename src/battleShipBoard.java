import java.lang.Math;

public class battleShipBoard
{
	private static char gameBoard [][] = new char [3][3];
	private static int coordinates[][] = new int[3][2];
	
	// Sets up a new gameBoard
	public battleShipBoard()
	{
		System.out.println("Welcome to Battleship!");
		reset();
		shipCoordinates();
	}
	
	
	// First randomly chooses between whether the ship will be diagonal, vertical, or horizontal
	// It then randomly chooses a set of coordinates that satisfy the ships orientation
	public static void shipCoordinates()
	{
		int orientation = (int)(3*Math.random()+1);
		
		// Chooses set of coordinates for a horizontal orientation
		if (orientation == 1)
		{
			int setOne = (int)(3*Math.random()+1);
			
			if (setOne == 1)
			{
				// A ship coordinate at row 1, column 1
				coordinates[0][0] = 1;
				coordinates[0][1] = 1; 
				
				// A ship coordinate at row 1, column 2
				coordinates[1][0] = 1;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 1, column 3
				coordinates[2][0] = 1;
				coordinates[2][1] = 3;
			}
			
			if (setOne == 2)
			{
				// A ship coordinate at row 2, column 1
				coordinates[0][0] = 2;
				coordinates[0][1] = 1; 
				
				// A ship coordinate at row 2, column 2
				coordinates[1][0] = 2;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 2, column 3
				coordinates[2][0] = 2;
				coordinates[2][1] = 3;
			}
			
			if (setOne == 3)
			{
				// A ship coordinate at row 3, column 1
				coordinates[0][0] = 3;
				coordinates[0][1] = 1; 
				
				// A ship coordinate at row 3, column 2
				coordinates[1][0] = 3;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 3, column 3
				coordinates[2][0] = 3;
				coordinates[2][1] = 3;
			}
		}
		
		// Set of coordinates for a vertical orientation
		if (orientation == 2)
		{
			int setOne = (int)(3*Math.random()+1);
			
			if (setOne == 1)
			{
				// A ship coordinate at row 1, column 1
				coordinates[0][0] = 1;
				coordinates[0][1] = 1; 
				
				// A ship coordinate at row 2, column 1
				coordinates[1][0] = 2;
				coordinates[1][1] = 1;
				
				// A ship coordinate at row 3, column 1
				coordinates[2][0] = 3;
				coordinates[2][1] = 1;
			}
			
			if (setOne == 2)
			{
				// A ship coordinate at row 1, column 2
				coordinates[0][0] = 1;
				coordinates[0][1] = 2; 
				
				// A ship coordinate at row 2, column 2
				coordinates[1][0] = 2;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 3, column 2
				coordinates[2][0] = 3;
				coordinates[2][1] = 2;
			}
			
			if (setOne == 3)
			{
				// A ship coordinate at row 1, column 3
				coordinates[0][0] = 1;
				coordinates[0][1] = 3; 
				
				// A ship coordinate at row 2, column 3
				coordinates[1][0] = 2;
				coordinates[1][1] = 3;
				
				// A ship coordinate at row 3, column 3
				coordinates[2][0] = 3;
				coordinates[2][1] = 3;
			}
		}
		
		// Chooses set of coordinates for a diagonal orientation
		if (orientation == 3)
		{
			int setOne = (int)(2*Math.random()+1);
			
			if (setOne == 1)
			{
				// A ship coordinate at row 1, column 1
				coordinates[0][0] = 1;
				coordinates[0][1] = 1; 
				
				// A ship coordinate at row 2, column 2
				coordinates[1][0] = 2;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 3, column 3
				coordinates[2][0] = 3;
				coordinates[2][1] = 3;
			}
			
			if (setOne == 2)
			{
				// A ship coordinate at row 1, column 3
				coordinates[0][0] = 1;
				coordinates[0][1] = 3; 
				
				// A ship coordinate at row 2, column 2
				coordinates[1][0] = 2;
				coordinates[1][1] = 2;
				
				// A ship coordinate at row 3, column 1
				coordinates[2][0] = 3;
				coordinates[2][1] = 1;
			}
		}
	}
	
	// Determines if there was a hit or a miss
	// Column 1 is the predicted row and Column 2 is the predicted column
	public static boolean hitOrMiss(int [][] input)
	{
		
		// If the predicted row is the same as the first coordinate of the ship
		// Check to see if the predicted column is the same as the first column of the ship
		// If that's true, then it was a hit and the board will be marked accordingly
		if (input[0][0] == coordinates[0][0])
		{
			if(input[0][1] == coordinates[0][1])
				return true; 
		}
		
		// If the predicted row is the same as the second coordinate of the ship
		// Check to see if the predicted column is the same as the second column of the ship
		// If that's true, then it was a hit and the board will be marked accordingly
		else if (input[0][0] == coordinates[1][0])
		{
			if(input[0][1] == coordinates[1][1])
				return true;
		}
		
		// If the predicted row is the same as the third coordinate of the ship
		// Check to see if the predicted column is the same as the third column of the ship
		// If that's true, then it was a hit and the board will be marked accordingly
		else if (input[0][0] == coordinates[2][0])
		{
			if (input[0][1] == coordinates[2][1])
			{
				return true;
			}
		}
		
		// If none of the coordinates match, return false
		return false; 
	}
	
	
	public static void placeOrError(int [][] input)
	{
		// If the row or column is greater than 3, then it is not on the grid
		if((input[0][0] > 3) || (input[0][1] > 3))
		{
			System.out.println("This point is not on the grid!");
			System.out.println("\n");
		}
	
		// If that coordinate was already hit, then don't place 
		else if(gameBoard[input[0][0]-1][input[0][1]-1] == 'X')
		{
			System.out.println("You have already hit this point!");
			System.out.println("\n");
		}
		
		// If it was a hit, then place an X on that spot
		else if(hitOrMiss(input))
		{
			gameBoard[input[0][0]-1][input[0][1]-1] = 'X';
			System.out.println("You hit the ship!");
			System.out.println("\n");
		}
			

		// If it was not a hit, then don't place
		else
		{
			System.out.println("Ha! You missed!");
			System.out.println("\n");
		}
	}
	
	// Determines if you won or lost based on if you got 3 X's
	public static boolean winOrLose()
	{
		
		int hits = 0;
		
		for (int row = 0; row < gameBoard.length; row++)
		{
			for(int col = 0; col < gameBoard[0].length; col++)
			{
				if(gameBoard[row][col] == 'X')
					hits++;
			}
		}
		
		if (hits == 3)
			return true;
		else 
			return false;
	}
	
	// Creates a clean board
	public static void reset()
	{
		for (int row = 0; row < gameBoard.length; row++)
		{
			for(int col = 0; col < gameBoard[0].length; col++)
			{
				gameBoard[row][col] = '-';
			}
		}
	}
	
	// Displays the board 
	public String toString()
	{
		String display = "";
		
		for (int row = 0; row < gameBoard.length; row++)
		{
			for(int col = 0; col < gameBoard[0].length; col++)
			{
				display += gameBoard[row][col] + " ";
			}
			display += "\n";
		}
		
		return display;
	}
}
