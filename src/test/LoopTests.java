package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class LoopTests extends HomeScreen {

	/*Questionnaire questions = new Questionnaire();
	HikeInfo[] allhikes = new HikeInfo[12];
	
	public void makeQ() {
		String[] a1 = {"Yes", "No"};
		String[] a2 = {"1", "2", "3", "4", "5"}; 
		String[] a3 = {"1-2", "3-4", "5-6", "7+"}; 

		questions.questions[0] = new Question("Dog Friendly?", a1); 
		questions.questions[1] = new Question("Horse Friendly?", a1); 
		questions.questions[2] = new Question("Bike Friendly?", a1); 
		questions.questions[3] = new Question("Difficulty?", a2); 
		questions.questions[4] = new Question("Ideal Hike Length?", a3); 
	}
	
	public void makeH() {
			allhikes[0] = new HikeInfo("Bishop Peak Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[0].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
			allhikes[0].setDifficulty(new Difficulty(3.5, 950, 5));
			
			allhikes[1] = new HikeInfo("Madonna Peak Trail", Boolean.FALSE, Boolean.TRUE);
			allhikes[1].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
			allhikes[1].setDifficulty(new Difficulty(4, 1100, 4));
			
			allhikes[2] = new HikeInfo("Ontario Ridge Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[2].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
			allhikes[2].setDifficulty(new Difficulty(3, 675, 4));
			
			allhikes[3] = new HikeInfo("Serenity Swing", Boolean.FALSE, Boolean.FALSE);
			allhikes[3].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
			allhikes[3].setDifficulty(new Difficulty(3.5, 725, 3));
			
			allhikes[4] = new HikeInfo("Valencia Peak Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[4].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
			allhikes[4].setDifficulty(new Difficulty(4.5, 1275, 3));
			
			allhikes[5] = new HikeInfo("Poly Canyon Design Village", Boolean.FALSE, Boolean.FALSE);
			allhikes[5].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
			allhikes[5].setDifficulty(new Difficulty(2.5, 300, 2));
			
			allhikes[6] = new HikeInfo("Hazard Peak Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[6].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
			allhikes[6].setDifficulty(new Difficulty(6, 950, 4));
			
			allhikes[7] = new HikeInfo("Bob Jones Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[7].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
			allhikes[7].setDifficulty(new Difficulty(5, 50, 1));
			
			allhikes[8] = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
			allhikes[8].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
			allhikes[8].setDifficulty(new Difficulty(3.2, 25, 1));
			
			allhikes[9] = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
			allhikes[9].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
			allhikes[9].setDifficulty(new Difficulty(2.85, 40, 1));
			
			allhikes[10] = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
			allhikes[10].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
			allhikes[10].setDifficulty(new Difficulty(4.5, 135, 2));
			
			allhikes[11] = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
			allhikes[11].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
			allhikes[11].setDifficulty(new Difficulty(1, 341, 2));
			
	}
	
	@Test
	public void test() {
		
		questions.questions[0].setAnswer(0);
		questions.questions[1].setAnswer(0);
		questions.questions[2].setAnswer(0);
		questions.questions[3].setAnswer(0);
		questions.questions[4].setAnswer(0);
		
		HikeInfo hi = computeOptimalHike();
		System.out.println(hi.getName());
		assertEquals("Bob Jones Trail", hi.getName());
	}*/
	
	@Test
	public void test() {

		questionnaire.questions[0].setAnswer(0);
		questionnaire.questions[1].setAnswer(0);
		questionnaire.questions[2].setAnswer(0);
		questionnaire.questions[3].setAnswer(0);
		questionnaire.questions[4].setAnswer(0);
		HikeInfo hi = computeOptimalHike();
		assertEquals("Bob Jones Trail", hi.getName());
		
	}

}
