//Rafi
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest2 {

	@Test
	public void test1() {
		HikeInfo hike;
		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		boolean b = hike.getAccess().getDog();
		assertEquals(true, b);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		boolean b = hike.getAccess().getHorse();
		assertEquals(false, b);
	}

}
