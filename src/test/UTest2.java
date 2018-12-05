package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Access;

public class UTest2 {

	@Test
	public void testPass() {
		Access a = new Access(false,false,false,false);
		assertEquals(false, a.getPass());
	}

}
