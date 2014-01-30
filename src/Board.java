
public class Board {
	Tile[][] table;
	public Board(){
		table= new Tile[143][143];
	}
	public void placeTile(Tile tile, int x, int y){
		table[x][y]=tile;
	}
	public Tile getTile(int x, int y){
		return table[x][y];
	}
}
