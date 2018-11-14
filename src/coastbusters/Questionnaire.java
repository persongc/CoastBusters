package coastbusters;

import javafx.scene.control.Button;

public class Questionnaire
{
	Button home;
	Button done;
	
	private class Question
	{
		public String question;
		public String[] answers;
		Button next;
		Button back;
	}
}
