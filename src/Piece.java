
abstract class Piece {
	
	public abstract PName getName();
	
	public abstract void setName(PName name);
	
	public abstract int getMoveCount();
	
	public abstract void setMoveCount(int moveCount);
	
	public abstract boolean getPlayer();
	
	public abstract void setPlayer(boolean player);
	
	public abstract Piece[][] move(Piece[][] map, int newX, int newY, boolean player);
	
	public abstract boolean checkForCollision(int currX, int currY, int newX, int newY, Piece[][] map);
	
	public abstract boolean checkForInvalidMoves(int currX, int currY, int newX, int newY, Piece[][] map);
	
	public abstract boolean checkForValidAttack(int currX, int currY, int newX, int newY, Piece[][] map);

}
