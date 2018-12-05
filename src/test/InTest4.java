//Gavin
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest4 {

	@Test
	public void test() {
		HikeInfo hike;
		hike = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		double d = hike.getDifficulty().getDiffRating();
		assertEquals(2, d, 0);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours("sunrise", "sunset", 1.25));
		String s = hike.getHours().getOpen();
		assertEquals("sunrise", s);
	}

}
