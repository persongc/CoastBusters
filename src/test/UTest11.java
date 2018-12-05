package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Question;

public class UTest11 {

	@Test
	public void test() {
		String[] answers = new String[3];
		answers[0] = "Bad Boy Pistons";
		answers[1] = "MJ's Bulls";
		answers[2] = "Stupid Warriors";
		Question q = new Question("What is the best NBA team ever assembled?", answers);
		q.setAnswer(0);
		assertEquals(0, q.getAnswer());
		//Isiah Thomas should have been on the Dream Team
	}

}
