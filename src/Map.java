
public class Map {
	int X = 8;
	int Y = 8;
	
	public Map() {
		
	}
	
	public Piece[][] makeObjectiveMap(){
		Piece[][] map = new Piece[X][Y];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(i == 6 || i == 1) {
					map[i][j] = new Pawn(PName.PAWN, i, j, false);
				}
				else if(i == 6) {
					map[i][j] = new Pawn(PName.PAWN, i, j, true);
				}
				else if(j == 0 && i == 0 || j == 7 && i == 7 || i == 0 && j == 7 || i == 7 && j == 0) {
					map[i][j] = new Rook(PName.ROOK);
				}
				else if(j == 1 && i == 0 || j == 6 && i == 7 || j == 6 && i == 0 || j == 1 && i == 7) {
					map[i][j] = new Knight(PName.KNIGHT);
				}
				else if(j == 2 && i == 0 || j == 5 && i == 7 || j == 5 && i == 0 || j == 2 && i == 7) {
					map[i][j] = new Bishop(PName.BISHOP);
				}
				else if(j == 3 && i == 0 || j == 3 && i == 7 || j == 3 && i == 0 || j == 3 && i == 7) {
					map[i][j] = new Queen(PName.QUEEN);
				}
				else if(j == 4 && i == 0 || j == 4 && i == 7 || j == 4 && i == 0 || j == 4 && i == 7) {
					map[i][j] = new King(PName.KING);
				}
				else {
					map[i][j] = new Empty(PName.EMPTY);

				}
			}
		}
		
		return map;
	}
	
	public char[][] makeFreshMap() {
		char[][] map = new char[X][Y];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(i == 6|| i == 1) {
					map[i][j] = 'P';
				}
				else if(j == 0 && i == 0 || j == 7 && i == 7 || i == 0 && j == 7 || i == 7 && j == 0) {
					map[i][j] = 'R';
				}
				else if(j == 1 && i == 0 || j == 6 && i == 7 || j == 6 && i == 0 || j == 1 && i == 7) {
					map[i][j] = 'H';
				}
				else if(j == 2 && i == 0 || j == 5 && i == 7 || j == 5 && i == 0 || j == 2 && i == 7) {
					map[i][j] = 'B';
				}
				else if(j == 3 && i == 0 || j == 3 && i == 7 || j == 3 && i == 0 || j == 3 && i == 7) {
					map[i][j] = 'Q';
				}
				else if(j == 4 && i == 0 || j == 4 && i == 7 || j == 4 && i == 0 || j == 4 && i == 7) {
					map[i][j] = 'K';
				}
				else {
					map[i][j] = '-';

				}
			}
		}
		
		return map;
	}
	
	public void printMap(char[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(" " + map[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void printObjectiveMap(Piece[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(" " + map[i][j].getName() + " ");
			}
			System.out.println("");
		}
	}
}
