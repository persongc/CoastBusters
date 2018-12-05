package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.HikeInfo;

public class UTest8 {

	@Test
	public void testBathrooms() {
		HikeInfo h = new HikeInfo("secondhike", false, true);
		assertEquals(false, h.getBathrooms());
	}

}
