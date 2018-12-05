package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.HikeInfo;

public class UTest7 {

	@Test
	public void testName() {
		HikeInfo h = new HikeInfo("hike1", true, false);
		assertEquals("hike1", h.getName());
	}

}
