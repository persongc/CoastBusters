package coastbusters;

import javafx.scene.control.Button;

public class Question{
		public String question;
		public String[] answers;
		Button next;
		Button back;

		public Question(String question, String[] answers){
			this.question = question;
			this.answers = answers;
		}
}

