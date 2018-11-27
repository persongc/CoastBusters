package coastbusters;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class HomeScreen extends Application {
	
	protected static Questionnaire questionnaire = new Questionnaire();
	protected static HikeInfo[] hikes = new HikeInfo[12];

	private Stage stage;
	protected Random rand = new Random();

	private final String IDLE_BUTTON_STYLE = "-fx-background-color: #e6c58d; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private final String HOVERED_BUTTON_STYLE = "-fx-background-color: #f7d193; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private final String BACKGROUND_COLOR = "-fx-background-color: #FFEDCF;";

	private Label title = new Label("Coastbusters");

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
		String sunset = "Sunset";
		String sunrise = "Sunrise";

		HikeInfo hike = new HikeInfo("Bishop Peak Trail", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(3.5, 950, 5));
		hike.setHours(new Hours(sunrise, sunset, 2));
		hikes[0] = hike;

		hike = new HikeInfo("Cerro San Luis Trail", F, T);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(4, 1100, 5));
		hike.setHours(new Hours(sunrise, sunset, 2.25));
		hikes[1] = hike;

		hike = new HikeInfo("Cal Poly \"P\"", F, F);
		hike.setAccess(new Access(T, F, T, F));
		hike.setDifficulty(new Difficulty(1, 341, 2));
		hike.setHours(new Hours(sunrise, sunset, 1));
		hikes[2] = hike;

		hike = new HikeInfo("Serenity Swing", F, F);
		hike.setAccess(new Access(T, F, T, F));
		hike.setDifficulty(new Difficulty(3.5, 725, 3));
		hike.setHours(new Hours(sunrise, sunset, 2));
		hikes[3] = hike;

		hike = new HikeInfo("Ontario Ridge Trail", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(3, 675, 4));
		hike.setHours(new Hours(sunrise, sunset, 2.5));
		hikes[4] = hike;

		hike = new HikeInfo("Valencia Peak Trail", F, F);
		hike.setAccess(new Access(F, F, F, T));
		hike.setDifficulty(new Difficulty(4.5, 1275, 3));
		hike.setHours(new Hours(sunrise, sunset, 2.75));
		hikes[5] = hike;

		hike = new HikeInfo("Poly Canyon Design Village", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(2.5, 300, 2));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hikes[6] = hike;

		hike = new HikeInfo("Hazard Peak Trail", F, F);
		hike.setAccess(new Access(T, F, F, F));
		hike.setDifficulty(new Difficulty(6, 950, 4));
		hike.setHours(new Hours(sunrise, sunset, 3));
		hikes[7] = hike;

		hike = new HikeInfo("Bob Jones Trail", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(5, 50, 1));
		hike.setHours(new Hours(sunrise, sunset, 2.25));
		hikes[8] = hike;

		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", F, F);
		hike.setAccess(new Access(T, F, F, F));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hikes[9] = hike;

		hike = new HikeInfo("Moonstone Beach Boardwalk", F, F);
		hike.setAccess(new Access(F, F, T, F));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hikes[10] = hike;

		hike = new HikeInfo("Headlands Trail", F, F);
		hike.setAccess(new Access(F, F, F, F));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		hike.setHours(new Hours(sunrise, sunset, 2));
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
		title.setFont(Font.font("Futura", FontPosture.ITALIC, 40));
		Scene scene = homeScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene homeScene(){
		Text names = new Text();

		VBox root = new VBox(45);

		VBox vBox = new VBox(10);

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

		questionnaireButton.setStyle(IDLE_BUTTON_STYLE);
		questionnaireButton.setOnMouseEntered(e -> questionnaireButton.setStyle(HOVERED_BUTTON_STYLE));
		questionnaireButton.setOnMouseExited(e -> questionnaireButton.setStyle(IDLE_BUTTON_STYLE));
		questionnaireButton.setPrefWidth(200);

		randomButton.setStyle(IDLE_BUTTON_STYLE);
		randomButton.setOnMouseEntered(e -> randomButton.setStyle(HOVERED_BUTTON_STYLE));
		randomButton.setOnMouseExited(e -> randomButton.setStyle(IDLE_BUTTON_STYLE));
		randomButton.setPrefWidth(200);

		allButton.setStyle(IDLE_BUTTON_STYLE);
		allButton.setOnMouseEntered(e -> allButton.setStyle(HOVERED_BUTTON_STYLE));
		allButton.setOnMouseExited(e -> allButton.setStyle(IDLE_BUTTON_STYLE));
		allButton.setPrefWidth(200);

		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(questionnaireButton, randomButton, allButton);

		names.setText("Designed and built by Adam Havstad,\n" +
				      "Rafael Cohn-Gruenwald, Gavin Chao,\n" +
					  "James Kao, Elijah Pinson, and\n" +
					  "Arun Ulagappan.");
		names.setTextAlignment(TextAlignment.CENTER);
		names.setFont(Font.font("Helvetica", 10));

		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().addAll(title, vBox, names);

		root.setStyle(BACKGROUND_COLOR);

		return new Scene(root, 300, 500);
	}

	private Scene firstQuestion(){
		Label question = new Label(questionnaire.questions[0].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		VBox vBox = new VBox(50);

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

		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);


		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);


		//root.getChildren().addAll(homeButton, question, a1, a2);

		//return new Scene(root, 300, 500);
	}

	private Scene secondQuestion(){
		Label question = new Label(questionnaire.questions[1].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		VBox vBox = new VBox(50);

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

		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);


		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene thirdQuestion(){
		Label question = new Label(questionnaire.questions[2].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		VBox vBox = new VBox(50);

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

		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);


		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fourthQuestion(){
		Label question = new Label(questionnaire.questions[3].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(25);
		VBox vBox = new VBox(50);

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

		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(25);

		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(25);

		a3.setStyle(IDLE_BUTTON_STYLE);
		a3.setOnMouseEntered(e -> a3.setStyle(HOVERED_BUTTON_STYLE));
		a3.setOnMouseExited(e -> a3.setStyle(IDLE_BUTTON_STYLE));
		a3.setPrefWidth(25);

		a4.setStyle(IDLE_BUTTON_STYLE);
		a4.setOnMouseEntered(e -> a4.setStyle(HOVERED_BUTTON_STYLE));
		a4.setOnMouseExited(e -> a4.setStyle(IDLE_BUTTON_STYLE));
		a4.setPrefWidth(25);

		a5.setStyle(IDLE_BUTTON_STYLE);
		a5.setOnMouseEntered(e -> a5.setStyle(HOVERED_BUTTON_STYLE));
		a5.setOnMouseExited(e -> a5.setStyle(IDLE_BUTTON_STYLE));
		a5.setPrefWidth(25);

		hBox.getChildren().addAll(a1, a2, a3, a4, a5);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fifthQuestion(){
		Label question = new Label(questionnaire.questions[4].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(25);
		VBox vBox = new VBox(50);

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

		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(45);

		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(45);

		a3.setStyle(IDLE_BUTTON_STYLE);
		a3.setOnMouseEntered(e -> a3.setStyle(HOVERED_BUTTON_STYLE));
		a3.setOnMouseExited(e -> a3.setStyle(IDLE_BUTTON_STYLE));
		a3.setPrefWidth(45);

		a4.setStyle(IDLE_BUTTON_STYLE);
		a4.setOnMouseEntered(e -> a4.setStyle(HOVERED_BUTTON_STYLE));
		a4.setOnMouseExited(e -> a4.setStyle(IDLE_BUTTON_STYLE));
		a4.setPrefWidth(45);

		hBox.getChildren().addAll(a1, a2, a3, a4);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene computeOptimalHike(){
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
				if((temp1[i] != 0) && (hikes[i].getAccess().getHorse().equals(Boolean.TRUE))){
						temp2[i] = 1;
				}
			}

		}else{
			temp2 = temp1;
		}

		if(questionnaire.questions[2].getAnswer() == 0){
			for(int i = 0; i < 12; i++){
				if((temp2[i] != 0) && (hikes[i].getAccess().getBike().equals(Boolean.TRUE))){
						temp3[i] = 1;
				}
			}
		}else{
			temp3 = temp2;
		}

		for(int i = 0; i < 12; i++){
			if((temp3[i] != 0) && (hikes[i].getDifficulty().getDiffRating() == (questionnaire.questions[3].getAnswer() + 1))){
					temp4[i] = 1;
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

		if(qualifiedHikes.isEmpty()){
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


		if(qualifiedHikes.isEmpty()){
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
		VBox vRoot = new VBox();
		Pane root = new Pane();
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

		vRoot.getChildren().addAll(homeButton, displayAllHikesButton);
		root.getChildren().addAll(vRoot, hikeName);
		return new Scene(root, 300, 500);
	}

	private void initializeHikeButtons(Button button, HikeInfo hike){
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(displayHikeScene(hike));
			}
		});

		button.setWrapText(true);
	}

	private Scene listAllHikes(){
		VBox vRoot = new VBox();
		HBox hRoot = new HBox();
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
			vRoot.getChildren().add(hikeButtons[i]);
		}

		hRoot.getChildren().addAll(homeButton, vRoot);

		return new Scene(hRoot, 300, 500);
	}
}
