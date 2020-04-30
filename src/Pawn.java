public class Pawn extends Piece {
	int mMoveCount;
	int mX;
	int mY;
	PName mName;
	boolean mPlayer;
	
	public Pawn(PName name, int x, int y, boolean player) {
		mMoveCount = 0;
		mX = x;
		mY = y;
		mName = name;
		mPlayer = player;
	}

	@Override
	public int getMoveCount() {
		// TODO Auto-generated method stub
		return mMoveCount;
	}

	@Override
	public void setMoveCount(int moveCount) {
		// TODO Auto-generated method stub
		mMoveCount = moveCount;
	}

	@Override
	public PName getName() {
		// TODO Auto-generated method stub
		return mName;
	}

	@Override
	public void setName(PName name) {
		// TODO Auto-generated method stub
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
		//Checks if pawn has moved up or not
		if(newX - mX == 2 || newX - mX == -2) {
			if(!canMoveUpTwo(map[mX][mY])) {
				System.out.println("This pawn can not move up by two");
				System.out.println(map[mX][mY].getMoveCount());
				return map;
			}
		}
		
		//Validation for pawn moves; return map if either validation method return true
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
		
		//If command is to attack, make sure enemy piece is diagonal to current pawn
		boolean validAttack = checkForValidAttack(mX, mY, newX, newY, map);
		if(validAttack) {
			//Switches the places of the empty piece and where the piece is moving to
			Piece temp = new Empty(PName.EMPTY);
			map[newX][newY] = map[mX][mY];
			map[mX][mY] = temp;	
			
			//Updates the piece's x and y coordinates
			mX = newX;
			mY = newY;
			
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
			if(map[currX][currY].getPlayer() == map[newX][newY].getPlayer() ||
				map[currX][currY].getPlayer() != map[newX][newY].getPlayer() && newY - currY == 0) {
				System.out.println("Invalid Move:  You cannot move to your a spot occupied by one of your pieces");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkForInvalidMoves(int currX, int currY, int newX, int newY, Piece[][] map) {
		if(Math.abs(newY - currY) >= 1 && newX - currX == 0 || map[newX][newY].getName() == PName.EMPTY && currY != newY) {
			System.out.println("Invalid Move:  You can only move pawn forward and attack diagonally");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkForValidAttack(int currX, int currY, int newX, int newY, Piece[][] map) {
		PName name = map[newX][newY].getName();
		if(name == PName.EMPTY && Math.abs(newY - currY) != 0) {
			System.out.println("Invalid Move:  You cannot move this pawn diagonally unless there is an enemy piece there");
			return false;
		}
		else {
			if(Math.abs(newX - currX) == 1 && Math.abs(newY - currY) == 1) {
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
				System.out.println(attacker + "pawn has taken " + victim + map[newX][newY].getName().toString().toLowerCase());
				return true;
			}
		}
		return false;
	}
	
	//Helper function to determine if a pawn can move up two spaces or not
	private boolean canMoveUpTwo(Piece p) {
		if((p.getMoveCount() == 0)) {
			return true;
		}
		
		return false;
	}


}
