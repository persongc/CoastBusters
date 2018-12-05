package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Difficulty;

public class UTest4 {

	@Test
	public void testDifficulty() {
		Difficulty d = new Difficulty(4, 400, 4);
		assertEquals(4, d.getDiffRating(), 0);
	}

}
