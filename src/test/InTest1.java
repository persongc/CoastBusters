//Adam
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class InTest1 {

	@Test
	public void test1() {
		HikeInfo hike;
		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		boolean b = hike.getAccess().getBike();
		assertEquals(true, b);
	}
	
	@Test
	public void test2() {
		HikeInfo hike;
		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		boolean b = hike.getAccess().getPass();
		assertEquals(false, b);
	}
	
	

}
