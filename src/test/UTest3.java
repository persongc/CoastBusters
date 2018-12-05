package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Difficulty;

public class UTest3 {

	@Test
	public void testElevation() {
		Difficulty d = new Difficulty(1,1000,1);
		assertEquals(1000, d.getElevGain(), 0);
	}

}
