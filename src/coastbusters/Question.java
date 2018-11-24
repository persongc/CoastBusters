package coastbusters;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Question{
		private String question;
		private Button[] answers;
		private int answer;

		public Question(String question, String[] answers){
			this.question = question;
			this.answers = initializeAnswerButtons(answers);
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


		private Button[] initializeAnswerButtons(String[] answers){
			Button[] buttons = new Button[answers.length];
			for(int i = 0; i < answers.length; i++){
				buttons[i] = new Button(answers[i]);
				initializeButtonEvent(buttons[i], i);
			}
			return buttons;
		}

		public String getQuestion(){
			return question;
		}

		public Button[] getAnswers(){
			return answers;
		}

		public void setAnswer(int answer){
			this.answer = answer;
		}

		public int getAnswer(){
			return answer;
		}
}

