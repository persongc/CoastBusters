package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Question;

public class UTest12 {

	@Test
	public void test() {
		String[] answers = new String[2];
		answers[0] = "one";
		answers[1] = "two";
		Question q = new Question("How many holes does a straw have?", answers);
		assertEquals("How many holes does a straw have?", q.getQuestion());
		//the answer is one and you know it
	}

}
