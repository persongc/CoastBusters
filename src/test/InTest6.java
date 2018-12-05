//Eli
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest6 {

	@Test
	public void test() {
		HikeInfo hike;
		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours("sunrise", "sunset", 1.25));
		hike.setWeather(new Weather("weatherapi", 0));
		String s = hike.getWeather().getURL();
		assertEquals("weatherapi", s);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours("sunrise", "sunset", 1.25));
		hike.setWeather(new Weather("weatherapi", 0));
		int i = hike.getWeather().getSet();
		assertEquals(0, i);
	}

}
