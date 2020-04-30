public class Queen extends Piece {
	int mMoveCount;
	PName mName;
	int mX;
	int mY;
	boolean mPlayer;
	
	public Queen(PName name, int x, int y, boolean player) {
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
	public Piece[][] move(Piece[][] map, int newX, int newY, boolean player) {
		return map;
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
	public boolean checkForCollision(int currX, int currY, int newX, int newY, Piece[][] map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForInvalidMoves(int currX, int currY, int newX, int newY, Piece[][] map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForValidAttack(int currX, int currY, int newX, int newY, Piece[][] map) {
		// TODO Auto-generated method stub
		return false;
	}

}
