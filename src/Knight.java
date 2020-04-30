
public class Knight extends Piece {
	int mMoveCount;
	PName mName;
	int mX;
	int mY;
	boolean mPlayer;
	
	public Knight(PName name, int x, int y, boolean player) {
		mMoveCount = 0;
		mName = name;
		mX = x;
		mY = y;
		mPlayer = player;
	}

	@Override
	public int getMoveCount() {
		return mMoveCount;
	}

	@Override
	public void setMoveCount(int moveCount) {
		mMoveCount = moveCount;
	}

	@Override
	public PName getName() {
		return mName;
	}

	@Override
	public void setName(PName name) {
		mName = name;
	}
	
	@Override
	public boolean getPlayer() {
		return mPlayer;
	}

	@Override
	public void setPlayer(boolean player) {
		mPlayer = player;
	}

	@Override
	public Piece[][] move(Piece[][] map, int newX, int newY, boolean player) {
		//Validates user input and returns plain map if either method return true
		if(checkForCollision(mX, mY, newX, newY, map) || checkForInvalidMoves(mX, mY, newX, newY, map)) {
			return map;
		}
				
		//The move is valid, so switch turns for players
		if(Game.player1Turn == true) {
			Game.player1Turn = false;
		}
		else {
			Game.player1Turn = true;
		}
		if(Game.player2Turn == true) {
			Game.player2Turn = false;
		}
		else {
			Game.player2Turn = true;
		}
		
		if(checkForValidAttack(mX, mY, newX, newY, map)) {
			//Switches the places of the empty piece and where the piece is moving to.s
			Piece temp = new Empty(PName.EMPTY);
			map[newX][newY] = map[mX][mY];
			map[mX][mY] = temp;	
			
			//Updates the piece's x and y coordinates
			mX = newX;
			mY = newY;
			
			//Updates the piece's move count.
			map[mX][mY].setMoveCount(map[mX][mY].getMoveCount() + 1);
			
			return map;
		}
		
		//Switches the places of the empty piece and where the piece is moving to.s
		Piece temp = map[newX][newY];
		map[newX][newY] = map[mX][mY];
		map[mX][mY] = temp;	
		
		//Updates the piece's x and y coordinates
		mX = newX;
		mY = newY;
		
		//Updates the piece's move count.
		map[mX][mY].setMoveCount(map[mX][mY].getMoveCount() + 1);
		
		return map;
		
	}


	@Override
	public boolean checkForCollision(int currX, int currY, int newX, int newY, Piece[][] map) {
		PName name = map[newX][newY].getName();
		if(name == PName.EMPTY) {
			return false;
		}
		else {
			if(map[currX][currY].getPlayer() == map[newX][newY].getPlayer()) {
				System.out.println("Invalid Move:  You cannot move to your a spot occupied by one of your pieces");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkForInvalidMoves(int currX, int currY, int newX, int newY, Piece[][] map) {
		if(newX == currX || newY == currY) {
			System.out.println("Invalid Move:  That knight cannot move there");
			return true;
		}
		
		if(Math.abs((Math.abs(currX - newX) - Math.abs(currY - newY))) == 1) {
			return false;
		}
		System.out.println("Invalid Move:  That knight cannot move there");
		return true;
	}

	@Override
	public boolean checkForValidAttack(int currX, int currY, int newX, int newY, Piece[][] map) {
		if(map[newX][newY].getName() != PName.EMPTY && map[newX][newY].getPlayer() != map[currX][currY].getPlayer()) {
			String attacker = "";
			String victim = "";
			if(map[currX][currY].getPlayer()) {
				attacker = "White's ";
				victim = "Black's ";
			}
			else {
				attacker = "Black's ";
				victim = "White's ";
			}
			System.out.println(attacker + "knight has taken " + victim + map[newX][newY].getName().toString().toLowerCase());
			return true;
		}
		return false;
	}

}

