import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class RoadCompletionTest {
	
	private Board b;
	@Before
	public void setup(){
		b = new Board();
	}
	
	@Test
	public void testEndpointToEndpoint(){
		//a short complete road from a cloister to a city
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE), 3, 4);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testLongerEndpointToEndpoint(){
		//a longer road from a cloister to a city
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE), 5, 5);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testEndpointToCrossroad(){
		//a short road from a cloister to a t-shaped crossroad
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.XROAD), 3, 4);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testIncompleteRoad(){
		//a road that is not complete
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		assertFalse(b.roadCompleted());
	}
	
	@Test
	public void testCrossroadToCrossroad(){
		//tests a segment of road between two crossroads
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.XROAD), 5, 5);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testSelfLoop(){
		//tests a loop made with two crossroads
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 4, 3);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testSelfLoop2(){
		//tests a loop made out of corner pieces only
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD), 3, 3);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 4, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD), 4, 4);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testConnectPiecesOfRoad(){
		//tests a piece of road connecting two pieces of existing road
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE), 5, 5);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		assertTrue(b.roadCompleted());
	}
	
	@Test
	public void testCrossroadConnectsTwoRoads(){
		//crossroad completes two roads, but there is also an incomplete road
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.CLOISTER), 4, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD), 3, 5);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.XROAD), 3, 4);
		assertTrue(b.roadCompleted());
	}
}
