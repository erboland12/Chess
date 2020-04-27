

public class King extends Piece {
	int mMoveCount;
	PName mName;
	
	public King(PName name) {
		mMoveCount = 0;
		mName = name;
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
	public Piece[][] move(Piece[][] map, int newX, int newY, boolean player) {
		return map;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Piece[][] moveBlack(Piece[][] map, int newX, int newY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPlayer(boolean player) {
		// TODO Auto-generated method stub
		
	}

}
