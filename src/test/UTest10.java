package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Hours;

public class UTest10 {

	@Test
	public void test() {
		Hours hr = new Hours("10", "11", 12);
		assertEquals(12, hr.getTime(), 0);
	}

}
