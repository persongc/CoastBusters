//Arun
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest3 {

	@Test
	public void test1() {
		HikeInfo hike;
		hike = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		double d = hike.getDifficulty().getLength();
		assertEquals(4.5, d, 0);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		double d = hike.getDifficulty().getElevGain();
		assertEquals(135, d, 0);
	}

}
