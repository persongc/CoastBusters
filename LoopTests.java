package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import javafx.scene.Scene;
import logic.*;

public class LoopTests extends HomeScreen{

	Questionnaire questionnaire = new Questionnaire();
	HikeInfo[] hikes = new HikeInfo[12];
	
	public void makeQ() {
		String[] a1 = {"Yes", "No"};
		String[] a2 = {"1", "2", "3", "4", "5"}; /* Difficulty scale: 1-5 */
		String[] a3 = {"1-2", "3-4", "5-6", "7+"}; /* Length of hike in miles */
		questionnaire.questions[0] = new Question("Dog Friendly?", a1); /* Dog Friendly Y/N */
		questionnaire.questions[1] = new Question("Horse Friendly?", a1); /* Horse Friendly Y/N */
		questionnaire.questions[2] = new Question("Bike Friendly?", a1); /* Bike Friendly Y/N */
		questionnaire.questions[3] = new Question("Difficulty?", a2); /* Difficulty Scale: 1-5 */
		questionnaire.questions[4] = new Question("Ideal Hike Length?", a3); /* Hike Length in miles */
	}
	
	public void makeHikes() {
		//name bathroom water
		//bike pass dog horse
		//length elev diff
		
		hikes[1] = new HikeInfo("Bishop Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[1].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hikes[1].setDifficulty(new Difficulty(3.5, 950, 5));
		
		hikes[2] = new HikeInfo("Madonna Peak Trail", Boolean.FALSE, Boolean.TRUE);
		hikes[2].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hikes[2].setDifficulty(new Difficulty(4, 1100, 4));
		
		hikes[3] = new HikeInfo("Ontario Ridge Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[3].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hikes[3].setDifficulty(new Difficulty(3, 675, 4));
		
		hikes[4] = new HikeInfo("Serenity Swing", Boolean.FALSE, Boolean.FALSE);
		hikes[4].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hikes[4].setDifficulty(new Difficulty(3.5, 725, 3));
		
		hikes[5] = new HikeInfo("Valencia Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[5].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
		hikes[5].setDifficulty(new Difficulty(4.5, 1275, 3));
		
		hikes[6] = new HikeInfo("Poly Canyon Design Village", Boolean.FALSE, Boolean.FALSE);
		hikes[6].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hikes[6].setDifficulty(new Difficulty(2.5, 300, 2));
		
		hikes[7] = new HikeInfo("Hazard Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[7].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hikes[7].setDifficulty(new Difficulty(6, 950, 4));
		
		hikes[8] = new HikeInfo("Bob Jones Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[8].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hikes[8].setDifficulty(new Difficulty(5, 50, 1));
		
		
		hikes[9] = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
		hikes[9].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hikes[9].setDifficulty(new Difficulty(3.2, 25, 1));
		
		hikes[10] = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hikes[10].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hikes[10].setDifficulty(new Difficulty(2.85, 40, 1));
		
		hikes[11] = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hikes[11].setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hikes[11].setDifficulty(new Difficulty(4.5, 135, 2));
		
		hikes[12] = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hikes[12].setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hikes[12].setDifficulty(new Difficulty(1, 341, 2));
	}
	
	@Test
	public void test1() {
		makeQ();
		makeHikes();
		
		questionnaire.questions[0].setAnswer(0);
		questionnaire.questions[1].setAnswer(0);
		questionnaire.questions[2].setAnswer(0);
		questionnaire.questions[3].setAnswer(0);
		questionnaire.questions[4].setAnswer(0);
		
		HikeInfo h = computeOptimalHike();
		
		assertEquals("Bob Jones Trail", h.getName());
		
	}
	
	/*@Test
	public void test2() {
		HomeScreen h = new HomeScreen();
		h.buildQuestionnaire();
		h.buildHikeDB();
		
		questionnaire.questions[0].setAnswer(0);
		questionnaire.questions[1].setAnswer(0);
		questionnaire.questions[2].setAnswer(0);
		questionnaire.questions[3].setAnswer(0);
		questionnaire.questions[4].setAnswer(0);
		
		//if you change optimal hike to protected (i made it public for above test)
		h.computeOptimalHike();		
	}*/

}
