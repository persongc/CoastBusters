package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Features;

public class UTest5 {

	@Test
	public void testWaterfall() {
		Features f = new Features(true, false);
		assertEquals(true, f.getWaterfall());
	}

}
