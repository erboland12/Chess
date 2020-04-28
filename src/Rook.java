
public class Rook extends Piece {
	int mMoveCount;
	PName mName;
	int mX;
	int mY;
	boolean mPlayer;
	
	public Rook(PName name, int x, int y, boolean player) {
		mMoveCount = 0;
		mName = name;
		mX = x;
		mY = y;
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
	public Piece[][] move(Piece[][] map, int newX, int newY,  boolean player) {
		return map;
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public boolean getPlayer() {
		// TODO Auto-generated method stub
		return mPlayer;
	}

	@Override
	public void setPlayer(boolean player) {
		// TODO Auto-generated method stub
		
	}

}
