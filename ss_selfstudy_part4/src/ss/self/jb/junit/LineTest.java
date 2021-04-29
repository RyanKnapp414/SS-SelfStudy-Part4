/**
 * 
 */
package ss.self.jb.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class LineTest {
	private Line l;

	@Test
	public void getSlopeTest() {
		l = new Line(1, 1, 5, 5);
		assertEquals(1, l.getSlope(), .0001);
		
		l = new Line(1, 5, 3, 10);
		assertEquals(2.5, l.getSlope(), .0001);
		
		l = new Line(3, 6, 1, 8);
		assertEquals(-1, l.getSlope(), .0001);
		
		l = new Line(1, 2, 3, 4);
		assertNotEquals(2, l.getSlope(), .0001);
	}

	@Test
	public void getDistanceTest() {
		l = new Line(1, 6, 3, 8);
		assertEquals(2.8284, l.getDistance(), .0001);
		
		l = new Line(4, 5, 1, 3);
		assertEquals(3.6055, l.getDistance(), .0001);
		
		l = new Line(1, 2, 7, 6);
		assertEquals(7.2111, l.getDistance(), .0001);	
		
		l = new Line(5, 2, 4, 6);
		assertNotEquals(4.5761, l.getDistance(), .0001);
	}
	
	@Test
	public void parallelToTest() {
		Line j = new Line(1, 2, 2, 4);
		
		l = new Line(3, 6, 6, 12);
		assertEquals(true, l.parallelTo(j));
		
		l = new Line(1, 5, 4, 8);
		assertEquals(false, l.parallelTo(j));
		
		l = new Line(1, 1, 2, 3);
		assertEquals(true, l.parallelTo(j));
		
		l = new Line(2, 1, 7, 4);
		assertNotEquals(true, l.parallelTo(j));
	}
}
