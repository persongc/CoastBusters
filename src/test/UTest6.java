package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Features;

public class UTest6 {

	@Test
	public void testView() {
		Features f = new Features(true, false);
		assertEquals(false, f.getViewpoint());
	}

}
