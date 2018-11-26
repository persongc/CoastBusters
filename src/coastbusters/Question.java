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
			//this.answers = answers;
		}

		private void initializeButtonEvent(Button button, int i){
			button.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					answer = i;
					return;
				}
			});
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

