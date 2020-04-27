
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
	
	//Move function for P2 (Should only be necessary for Pawn)
	@Override
	public Piece[][] moveBlack(Piece[][] map, int newX, int newY) {
		return null;
	}
	
	//Helper function to determine if a pawn can move up two spaces or not
	private boolean canMoveUpTwo(Piece p) {
		if((p.getMoveCount() == 0)) {
			return true;
		}
		
		return false;
	}


}
