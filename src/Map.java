
public class Map {
	int X = 8;
	int Y = 8;
	
	public Map() {
		
	}
	
	public Piece[][] makeObjectiveMap(){
		Piece[][] map = new Piece[X][Y];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(i == 1) {
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
	
	public String[][] makeFreshMap(Piece[][] objMap) {
		String[][] map = new String[X][Y];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(objMap[i][j].getName() == PName.PAWN) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wP";
					}else {
						map[i][j] = "bP";
					}
				}
				else if(objMap[i][j].getName() == PName.ROOK) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wR";
					}else {
						map[i][j] = "bR";
					}
				}
				else if(objMap[i][j].getName() == PName.KNIGHT) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wH";
					}else {
						map[i][j] = "bH";
					}
				}
				else if(objMap[i][j].getName() == PName.BISHOP) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wB";
					}else {
						map[i][j] = "bB";
					}
				}
				else if(objMap[i][j].getName() == PName.QUEEN) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wQ";
					}else {
						map[i][j] = "bQ";
					}
				}
				else if(objMap[i][j].getName() == PName.KING) {
					if(objMap[i][j].getPlayer()) {
						map[i][j] = "wK";
					}else {
						map[i][j] = "bK";
					}
				}
				else {
					map[i][j] = "--";

				}
			}
		}
		
		return map;
	}
	
	public void printMap(String[][] map) {
    	System.out.println("    A   B   C   D   E   F   G   H");
    	System.out.println("   --------------------------------");
		for(int i = 0; i < map.length; i++) {
			System.out.print(map.length - i + " |");
			for(int j = 0; j < map.length; j++) {
				System.out.print(" " + map[i][j] + " ");
			}
			System.out.print("|");
			System.out.println("");
		}
    	System.out.println("   --------------------------------");
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
