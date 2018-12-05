//James
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest5 {

	@Test
	public void test() {
		HikeInfo hike;
		hike = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours("sunrise", "sunset", 1.25));
		String s = hike.getHours().getClose();
		assertEquals("sunset", s);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours("sunrise", "sunset", 1.25));
		double d = hike.getHours().getTime();
		assertEquals(1.25, d, 0);
	}

}
