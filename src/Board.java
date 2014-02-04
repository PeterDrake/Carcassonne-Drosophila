public class Board {
	Tile[][] table;
	//these hold the location of the most recent tile placed, for road completion
	private int lastX;
	private int lastY;

	// constructor for Board, just sets up the grid array
	public Board() {
		table = new Tile[143][143];
	}

	// places the given tile at the given coordinates
	public void placeTile(Tile tile, int x, int y) {
		table[x][y] = tile;
		lastX = x;
		lastY = y;
	}

	// gets tile from the given coordinates
	public Tile getTile(int x, int y) {
		return table[x][y];
	}
	
	//this method returns true if there is at least one completed road
	public boolean roadCompleted(){
		Tile t = getTile(lastX, lastY);
		boolean complete = false;
		if(t.getNorth() == Tile.ROAD && getTile(lastX, lastY-1) != null){
			if(searchRoad(getTile(lastX, lastY-1), t, 2, lastX, lastY-1)){
				complete = true;
			}
		}else if(t.getEast() == Tile.ROAD && getTile(lastX+1, lastY) != null){
			if(searchRoad(getTile(lastX+1, lastY), t, 3, lastX+1, lastY)){
				complete = true;
			}
		}else if(t.getSouth() == Tile.ROAD && getTile(lastX, lastY+1) != null){
			if(searchRoad(getTile(lastX, lastY+1), t, 0, lastX, lastY+1)){
				complete = true;
			}
		}else if(t.getWest() == Tile.ROAD && getTile(lastX-1, lastY) != null){
			if(searchRoad(getTile(lastX-1, lastY), t, 1, lastX-1, lastY)){
				complete = true;
			}
		}
		return complete;
	}
	
	//recursive helper method for searching for road completion
	//from is which direction this tile was entered from - north 0, east 1, south 2, west 3
	protected boolean searchRoad(Tile current, Tile original, int from, int x, int y){
		if((current.getCenter() == Tile.CASTLE)||(current.getCenter() == Tile.CLOISTER)
				||(current.getCenter() == Tile.XROAD)){
			return true;
		}else if(current == original){
			return true;
		}
		if(current.getNorth() == Tile.ROAD && from != 0 && getTile(x, y-1) != null){
			return searchRoad(getTile(x, y-1), original, 2, x, y-1);
		}else if(current.getEast() == Tile.ROAD && from != 1 && getTile(x+1, y) != null){
			return searchRoad(getTile(x+1, y), original, 3, x+1, y);
		}else if(current.getSouth() == Tile.ROAD && from != 2 && getTile(x, y+1) != null){
			return searchRoad(getTile(x, y+1), original, 0, x, y+1);
		}else if(current.getWest() == Tile.ROAD && from != 3 && getTile(x-1, y) != null){
			return searchRoad(getTile(x-1, y), original, 1, x-1, y);
		}
		return false;
	}
	
	
}
