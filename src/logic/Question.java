package logic;

public class Question{
		private String q;
		private String[] answers;
		private int answer;

		public Question(String question, String[] answers){
			this.q = question;
			this.answers = answers;
		}

		public String getQuestion(){
			return q;
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

