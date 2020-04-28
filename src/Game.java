import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Map m = new Map();
		boolean gameOver = false;
		
		Piece[][] objectiveMap = m.makeObjectiveMap(); 
		String[][] visualMap = m.makeFreshMap(objectiveMap);
		m.printMap(visualMap);

		while(!gameOver) {
			//Scanner call to receive P1 command
			Scanner s = new Scanner(System.in);
		    System.out.println("P1 Move: ");
		    String p1Move = s.nextLine();
		    String[] p1MoveCommands = p1Move.split("\\s+");

		    
		    if(p1MoveCommands.length > 2 || (p1MoveCommands[0].length() != 2 || p1MoveCommands[1].length() != 2)) {
		    	System.out.println("Invalid Move.  Try Again.");
		    }
		    else {
		    	//Type of piece from command
		    	Piece[][] tempMap = objectiveMap;
		    	PName name = getPName(p1MoveCommands[0]);
		    	
		    	//Current coordinates of piece that is to be moved
		    	int currY = letterToNum(p1MoveCommands[0].charAt(0));
		    	int currX = swapInts(Character.getNumericValue(p1MoveCommands[0].charAt(1)));
		    	System.out.println("(" + currX + ", " + currY + ")");
		    	
		    	//Updated coordinates of where piece is to be moved.
		    	int newY = letterToNum(p1MoveCommands[1].charAt(0));
		    	int newX = swapInts(Character.getNumericValue(p1MoveCommands[1].charAt(1))); 
		    	System.out.println("(" + newX + ", " + newY + ")");
		    	
		    	//Determines if player is white or black
		    	boolean player = objectiveMap[currX][currY].getPlayer();
		    	
		    	//Checks for valid pawn move for P1.
		    	if(objectiveMap[currX][currY].getName() == PName.PAWN) {
		    		if(validatePawnMove(name, player, currX - newX)) {
						objectiveMap = objectiveMap[currX][currY].move(objectiveMap, newX, newY, player);
			    	}
			    	else {
			    		System.out.println("Invalid Pawn Move For Player 1: Your Pawn Cannot Move Backwards.");
			    	}
		    	}
		    	
		    	
//		    	if(name != PName.PAWN && name != PName.EMPTY) {
//		    		
//		    	}
		    	System.out.println(" ");
		    	visualMap = m.makeFreshMap(objectiveMap);
				m.printMap(visualMap);
		    }

		}
	}
	
	public static int letterToNum(char c) {
		if(c == 'A' || c == 'a') {
			return 0;
		}
		else if(c == 'B' || c == 'b') {
			return 1;
		}
		else if(c == 'C' || c == 'c') {
			return 2;
		}
		else if(c == 'D' || c == 'd') {
			return 3;
		}
		else if(c == 'E' || c == 'e') {
			return 4;
		}
		else if(c == 'F' || c == 'f') {
			return 5;
		}
		else if(c == 'G' || c == 'g') {
			return 6;
		}
		else if(c == 'H' || c == 'h') {
			return 7;
		}
		return -1;
	}
	
	public static int swapInts(int n) {
		if(n == 1) {
			return 7;
		}
		else if(n == 2) {
			return 6;
		}
		else if(n == 3) {
			return 5;
		}
		else if(n == 4) {
			return 4;
		}
		else if(n == 5) {
			return 3;
		}
		else if(n == 6) {
			return 2;
		}
		else if(n == 7) {
			return 1;
		}
		else if(n == 8) {
			return 0;
		}
		
		return -1;
	}
	
	public static PName getPName(String s) {
		if(s.equals("p") || s.equals("P") || s.toLowerCase().equals("pawn")) {
			return PName.PAWN;
		}
		
		return PName.EMPTY;
	}
	
	public static boolean validatePawnMove(PName name, boolean player, int sumOfX) {
		if(sumOfX >= 0) {
			return true;			
		}
		
		return false;
	}
}
