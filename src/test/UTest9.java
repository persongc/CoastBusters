package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Hours;

public class UTest9 {

	@Test
	public void test() {
		Hours hr = new Hours("7", "8", 9);
		assertEquals("7", hr.getOpen());
	}

}
