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
		assertEquals(true, )
	}
	
	@Test
	public void testLongerEndpointToEndpoint(){
		//a longer road from a cloister to a city
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE, Tile.CASTLE), 5, 5);
		assertEquals(true, );
	}
	
	@Test
	public void testEndpointToCrossroad(){
		//a short road from a cloister to a t-shaped crossroad
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.XROAD), 3, 4);
		assertEquals(true, );
	}
	
	@Test
	public void testIncompleteRoad(){
		//a road that is not complete
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.CLOISTER), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		assertEquals(false, )
	}
	
	@Test
	public void testCrossroadToCrossroad(){
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 3, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.FIELD, Tile.ROAD, Tile.ROAD), 4, 4);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 5, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.XROAD), 5, 5);
		assertEquals(true, );
	}
	
	@Test
	public void testSelfLoop(){
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 3, 3);
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.ROAD, Tile.XROAD), 3, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 4, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD), 4, 4);
		assertEquals(true,);
	}
	
	@Test
	public void testSelfLoop2(){
		b.placeTile(new Tile(Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD), 3, 3);
		b.placeTile(new Tile(Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.ROAD, Tile.FIELD), 3, 4);
		b.placeTile(new Tile(Tile.ROAD, Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD), 4, 3);
		b.placeTile(new Tile(Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.ROAD, Tile.FIELD), 4, 4);
		assertEquals(true,);
	}
}
