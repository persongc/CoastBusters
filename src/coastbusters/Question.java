package coastbusters;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Question{
		private String question;
		private String[] answers;
		private int answer;

		public Question(String question, String[] answers){
			this.question = question;
			this.answers = answers;
		}

		public String getQuestion(){
			return question;
		}

		public String[] getAnswers(){
			return answers;
		}

		public void setAnswer(int answer){
			this.answer = answer;
		}

		public int getAnswer(){
			return answer;
		}
}

