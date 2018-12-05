package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Access;

public class UTest1 {

	@Test
	public void testBike() {
		Access a = new Access(true,true,true,true);
		assertEquals(true, a.getBike());
	}

}
