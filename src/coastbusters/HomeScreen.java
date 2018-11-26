package coastbusters;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class HomeScreen extends Application {
	
	protected static Questionnaire questionnaire = new Questionnaire();
	protected static HikeInfo[] hikes = new HikeInfo[12];

	private Stage stage;
	protected Random rand = new Random();
	
	Label title;

	public static void main(String[] args) {
		/* Rafi is going to hardcode hikes into Hike Database array */
		buildQuestionnaire();
		buildHikeDB();
		
		launch(args);
	}

	/*
		HIKEINFO: "Name", Bathrooms, Water
		ACCESS: Bike, Pass, Dog, Horse
		DIFFICULTY: Length (mi), Elevation Gain (ft), Difficulty Rating (1-5)
		HOURS: "open", "close", time to complete (hrs)

	 */

	private static void buildHikeDB(){
		Boolean T = Boolean.TRUE;
		Boolean F = Boolean.FALSE;

		HikeInfo hike = new HikeInfo("Bishop Peak Trail", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(3.5, 950, 5));
		hike.setHours(new Hours("Sunrise", "Sunset", 2));
		hikes[0] = hike;

		hike = new HikeInfo("Cerro San Luis Trail", F, T);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(4, 1100, 5));
		hike.setHours(new Hours("Sunrise", "Sunset", 2.25));
		hikes[1] = hike;

		hike = new HikeInfo("Cal Poly \"P\"", F, F);
		hike.setAccess(new Access(T, F, T, F));
		hike.setDifficulty(new Difficulty(1, 341, 2));
		hike.setHours(new Hours("Sunrise", "Sunset", 1));
		hikes[2] = hike;

		hike = new HikeInfo("Serenity Swing", F, F);
		hike.setAccess(new Access(T, F, T, F));
		hike.setDifficulty(new Difficulty(3.5, 725, 3));
		hike.setHours(new Hours("Sunrise", "Sunset", 2));
		hikes[3] = hike;

		hike = new HikeInfo("Ontario Ridge Trail", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(3, 675, 4));
		hike.setHours(new Hours("Sunrise", "Sunset", 2.5));
		hikes[4] = hike;

		hike = new HikeInfo("Valencia Peak Trail", F, F);
		hike.setAccess(new Access(F, F, F, T));
		hike.setDifficulty(new Difficulty(4.5, 1275, 3));
		hike.setHours(new Hours("Sunrise", "Sunset", 2.75));
		hikes[5] = hike;

		hike = new HikeInfo("Poly Canyon Design Village", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(2.5, 300, 2));
		hike.setHours(new Hours("Sunrise", "Sunset", 1.25));
		hikes[6] = hike;

		hike = new HikeInfo("Hazard Peak Trail", F, F);
		hike.setAccess(new Access(T, F, F, F));
		hike.setDifficulty(new Difficulty(6, 950, 4));
		hike.setHours(new Hours("Sunrise", "Sunset", 3));
		hikes[7] = hike;

		hike = new HikeInfo("Bob Jones Trail", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(5, 50, 1));
		hike.setHours(new Hours("Sunrise", "Sunset", 2.25));
		hikes[8] = hike;

		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", F, F);
		hike.setAccess(new Access(T, F, F, F));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours("Sunrise", "Sunset", 1.25));
		hikes[9] = hike;

		hike = new HikeInfo("Moonstone Beach Boardwalk", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours("Sunrise", "Sunset", 1.25));
		hikes[10] = hike;

		hike = new HikeInfo("Headlands Trail", F, F);
		hike.setAccess(new Access(F, F, F, F));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		hike.setHours(new Hours("Sunrise", "Sunset", 2));
		hikes[11] = hike;
	}

	private static void buildQuestionnaire(){
		String[] a1 = {"Yes", "No"};
		String[] a2 = {"1", "2", "3", "4", "5"}; /* Difficulty scale: 1-5 */
		String[] a3 = {"1-2", "3-4", "5-6", "7+"}; /* Length of hike in miles */

		questionnaire.questions[0] = new Question("Dog Friendly?", a1); /* Dog Friendly Y/N */
		questionnaire.questions[1] = new Question("Horse Friendly?", a1); /* Horse Friendly Y/N */
		questionnaire.questions[2] = new Question("Bike Friendly?", a1); /* Bike Friendly Y/N */
		questionnaire.questions[3] = new Question("Difficulty?", a2); /* Difficulty Scale: 1-5 */
		questionnaire.questions[4] = new Question("Ideal Hike Length?", a3); /* Hike Length in miles */
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		stage.setTitle("Coastbusters");
		Scene scene = homeScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene homeScene(){
		Pane root = new Pane();
		title = new Label("Coastbusters");

		/* Prompts the user with a questionnaire to select an ideal hike */
		Button questionnaireButton = new Button("Find A Hike");
		questionnaireButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(firstQuestion());
			}
		});

		/* Randomly selects a hike for the user */
		Button randomButton = new Button("Get Random Hike");
		randomButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(pickRandomHike());
			}
		});

		/* Lists all of the hardcoded hikes */
		Button allButton = new Button("View All Hikes");
		allButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(listAllHikes());
				// Listing of all hikes
			}
		});

		title.setLayoutX(100);
		title.setLayoutY(0);
		questionnaireButton.setMaxWidth(Double.MAX_VALUE);
		questionnaireButton.setLayoutX(100);
		questionnaireButton.setLayoutY(75);
		randomButton.setMaxWidth(Double.MAX_VALUE);
		randomButton.setLayoutX(100);
		randomButton.setLayoutY(110);
		allButton.setMaxWidth(Double.MAX_VALUE);
		allButton.setLayoutX(100);
		allButton.setLayoutY(145);

		root.getChildren().addAll(title, questionnaireButton, randomButton, allButton);

		Scene scene = new Scene(root, 300, 500);

		return scene;
	}

	private Scene firstQuestion(){

		Pane root = new Pane();
		Label question = new Label(questionnaire.questions[0].getQuestion());

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		Button a1 = new Button(questionnaire.questions[0].getAnswers()[0]);
		a1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[0].setAnswer(0);
				stage.setScene(secondQuestion());
			}
		});

		Button a2 = new Button(questionnaire.questions[0].getAnswers()[1]);
		a2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[0].setAnswer(1);
				stage.setScene(secondQuestion());
			}
		});

		question.setLayoutX(100);
		question.setLayoutY(30);
		a1.setLayoutX(75);
		a1.setLayoutY(100);
		a2.setLayoutX(150);
		a2.setLayoutY(100);

		root.getChildren().addAll(homeButton, question, a1, a2);

		return new Scene(root, 300, 500);
	}

	private Scene secondQuestion(){
		Pane root = new Pane();
		Label question = new Label(questionnaire.questions[1].getQuestion());

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		Button a1 = new Button(questionnaire.questions[1].getAnswers()[0]);
		a1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[1].setAnswer(0);
				stage.setScene(thirdQuestion());
			}
		});

		Button a2 = new Button(questionnaire.questions[1].getAnswers()[1]);
		a2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[1].setAnswer(1);
				stage.setScene(thirdQuestion());
			}
		});

		question.setLayoutX(100);
		question.setLayoutY(30);
		a1.setLayoutX(75);
		a1.setLayoutY(100);
		a2.setLayoutX(150);
		a2.setLayoutY(100);

		root.getChildren().addAll(homeButton, question, a1, a2);

		return new Scene(root, 300, 500);
	}

	private Scene thirdQuestion(){
		Pane root = new Pane();
		Label question = new Label(questionnaire.questions[2].getQuestion());

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		Button a1 = new Button(questionnaire.questions[2].getAnswers()[0]);
		a1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[2].setAnswer(0);
				stage.setScene(fourthQuestion());
			}
		});

		Button a2 = new Button(questionnaire.questions[2].getAnswers()[1]);
		a2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[2].setAnswer(1);
				stage.setScene(fourthQuestion());
			}
		});

		question.setLayoutX(100);
		question.setLayoutY(30);
		a1.setLayoutX(75);
		a1.setLayoutY(100);
		a2.setLayoutX(150);
		a2.setLayoutY(100);

		root.getChildren().addAll(homeButton, question, a1, a2);

		return new Scene(root, 300, 500);
	}

	private Scene fourthQuestion(){
		Pane root = new Pane();
		Label question = new Label(questionnaire.questions[3].getQuestion());

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		Button a1 = new Button(questionnaire.questions[3].getAnswers()[0]);
		a1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[3].setAnswer(0);
				stage.setScene(fifthQuestion());
			}
		});

		Button a2 = new Button(questionnaire.questions[3].getAnswers()[1]);
		a2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[3].setAnswer(1);
				stage.setScene(fifthQuestion());
			}
		});

		Button a3 = new Button(questionnaire.questions[3].getAnswers()[2]);
		a3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[3].setAnswer(2);
				stage.setScene(fifthQuestion());
			}
		});

		Button a4 = new Button(questionnaire.questions[3].getAnswers()[3]);
		a4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[3].setAnswer(3);
				stage.setScene(fifthQuestion());
			}
		});

		Button a5 = new Button(questionnaire.questions[3].getAnswers()[4]);
		a5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[3].setAnswer(4);
				stage.setScene(fifthQuestion());
			}
		});


		question.setLayoutX(100);
		question.setLayoutY(30);
		a1.setLayoutX(50);
		a1.setLayoutY(100);
		a2.setLayoutX(100);
		a2.setLayoutY(100);
		a3.setLayoutX(150);
		a3.setLayoutY(100);
		a4.setLayoutX(200);
		a4.setLayoutY(100);
		a5.setLayoutX(250);
		a5.setLayoutY(100);

		root.getChildren().addAll(homeButton, question, a1, a2, a3, a4, a5);

		return new Scene(root, 300, 500);
	}

	private Scene fifthQuestion(){
		Pane root = new Pane();
		Label question = new Label(questionnaire.questions[4].getQuestion());

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		Button a1 = new Button(questionnaire.questions[4].getAnswers()[0]);
		a1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[4].setAnswer(0);
				stage.setScene(computeOptimalHike());
			}
		});

		Button a2 = new Button(questionnaire.questions[4].getAnswers()[1]);
		a2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[4].setAnswer(1);
				stage.setScene(computeOptimalHike());
			}
		});

		Button a3 = new Button(questionnaire.questions[4].getAnswers()[2]);
		a3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[4].setAnswer(2);
				stage.setScene(computeOptimalHike());
			}
		});

		Button a4 = new Button(questionnaire.questions[4].getAnswers()[3]);
		a4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				questionnaire.questions[4].setAnswer(3);
				stage.setScene(computeOptimalHike());
			}
		});

		question.setLayoutX(100);
		question.setLayoutY(30);
		a1.setLayoutX(62.5);
		a1.setLayoutY(100);
		a2.setLayoutX(125);
		a2.setLayoutY(100);
		a3.setLayoutX(187.5);
		a3.setLayoutY(100);
		a4.setLayoutX(250);
		a4.setLayoutY(100);

		root.getChildren().addAll(homeButton, question, a1, a2, a3, a4);

		return new Scene(root, 300, 500);
	}

	private Scene computeOptimalHike(){
		HikeInfo hike;
		int[] temp1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] temp2 = new int[12];
		int[] temp3 = new int[12];
		int[] temp4 = new int[12];
		int[] temp5 = new int[12];
		ArrayList<HikeInfo> qualifiedHikes = new ArrayList<>();

		if(questionnaire.questions[0].getAnswer() == 0){
			for(int i = 0; i < 12; i++){
				if(hikes[i].getAccess().getDog().equals(Boolean.FALSE)){
					temp1[i] = 0;
				}
			}
		}

		if(questionnaire.questions[1].getAnswer() == 0){
			for(int i = 0; i < 12; i++){
				if(temp1[i] != 0){
					if(hikes[i].getAccess().getHorse().equals(Boolean.TRUE)){
						temp2[i] = 1;
					}
				}
			}

		}else{
			temp2 = temp1;
		}

		if(questionnaire.questions[2].getAnswer() == 0){
			for(int i = 0; i < 12; i++){
				if(temp2[i] != 0){
					if(hikes[i].getAccess().getBike().equals(Boolean.TRUE)){
						temp3[i] = 1;
					}
				}
			}
		}else{
			temp3 = temp2;
		}

		for(int i = 0; i < 12; i++){
			if(temp3[i] != 0){
				if(hikes[i].getDifficulty().getDiffRating() == (questionnaire.questions[3].getAnswer() + 1)){
					temp4[i] = 1;
				}
			}
		}

		double len;
		double[] desiredLen = new double[2];

		if(questionnaire.questions[4].getAnswer() == 0){
			desiredLen[0] = 0;
			desiredLen[1] = 3;
		}else if(questionnaire.questions[4].getAnswer() == 1){
			desiredLen[0] = 3;
			desiredLen[1] = 5;
		}else if(questionnaire.questions[4].getAnswer() == 2){
			desiredLen[0] = 5;
			desiredLen[1] = 7;
		}else{
			desiredLen[0] = 7;
			desiredLen[1] = Double.POSITIVE_INFINITY;
		}

		for(int i = 0; i < 12; i++){
			if(temp4[i] != 0){
				len = hikes[i].getDifficulty().getLength();
				if(len >= desiredLen[0] && len < desiredLen[1]){
					temp5[i] = 1;
				}

			}
		}

		for(int i = 0; i < 12; i++){
			if(temp5[i] == 1){
				qualifiedHikes.add(hikes[i]);
			}
		}

		if(qualifiedHikes.size() == 0){
			for(int i = 0; i < 12; i++){
				if(temp4[i] == 1){
					qualifiedHikes.add(hikes[i]);
				}
			}
		}


		/*System.out.println(Arrays.toString(temp1));
		System.out.println(Arrays.toString(temp2));
		System.out.println(Arrays.toString(temp3));
		System.out.println(Arrays.toString(temp4));
		System.out.println(Arrays.toString(temp5));*/


		if(qualifiedHikes.size() == 0){
			return noHikes();
		}else{
			int val = rand.nextInt(qualifiedHikes.size());
			return displayHikeScene(qualifiedHikes.get(val));
		}
	}

	private Scene noHikes(){
		Pane root = new Pane();

		Label label = new Label("No Matching Hikes, Sorry!");
		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		label.setLayoutX(100);
		label.setLayoutY(30);
		root.getChildren().addAll(homeButton, label);

		return new Scene(root, 300, 500);
	}

	/* Randomly selects a hike */
	private Scene pickRandomHike(){
		int val = rand.nextInt(9);
		return displayHikeScene(hikes[val]);
	}

	/* Displays the information for the hike that is being passed in as a parameter */
	private Scene displayHikeScene(HikeInfo hike){
		VBox Vroot = new VBox();
		Pane root = new Pane();
		//title = new Label("Coastbusters");
		Label hikeName = new Label(hike.getName());
		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		/* Goes to all hikes screen */
		Button displayAllHikesButton = new Button("All Hikes");
		displayAllHikesButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(listAllHikes());
			}
		});

		hikeName.setLayoutY(30);
		hikeName.setLayoutX(100);

		Vroot.getChildren().addAll(homeButton, displayAllHikesButton);
		root.getChildren().addAll(Vroot, hikeName);
		return new Scene(root, 300, 500);
	}

	private void initializeHikeButtons(Button button, HikeInfo hike){
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(displayHikeScene(hike));
			}
		});
	}

	private Scene listAllHikes(){
		VBox VRoot = new VBox();
		HBox HRoot = new HBox();
		Button[] hikeButtons = new Button[hikes.length];
		HikeInfo temp;

		for(int i = 0; i < 12; i++){
			temp = hikes[i];
			hikeButtons[i] = new Button(temp.getName());
			initializeHikeButtons(hikeButtons[i], hikes[i]);
		}

		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});

		for(int i = 0; i < 12; i++){
			VRoot.getChildren().add(hikeButtons[i]);
		}

		HRoot.getChildren().addAll(homeButton, VRoot);

		return new Scene(HRoot, 300, 500);
	}
}
