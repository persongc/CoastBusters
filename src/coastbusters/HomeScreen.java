package coastbusters;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


public class HomeScreen extends Application {
	
	private static Questionnaire questionnaire = new Questionnaire();
	private static HikeInfo[] hikes = new HikeInfo[12];
	private Stage stage;
	private Random rand = new Random();
	private final String IDLE_BUTTON_STYLE = "-fx-background-color: #e6c58d; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private final String HOVERED_BUTTON_STYLE = "-fx-background-color: #f7d193; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private final String BACKGROUND_COLOR = "-fx-background-color: #FFEDCF;";
	private final String BOTTOM_BUTTON_STYLE = "-fx-background-color: #e6c58d; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px;";
	private final String CURRENT_BOTTOM_BUTTON_STYLE = "-fx-background-color: #f7d193; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px;";
	private Label title = new Label("Coastbusters");
	private static Button homeButton = new Button();
	private static Button refreshButton = new Button();
	private static Button qButton = new Button();
	private static Button backButton = new Button();
	private static Button allButtons = new Button();
	private Region r = new Region();

	public static void main(String[] args) {
		/* Rafi is going to hardcode hikes into Hike Database array */
		buildQuestionnaire();
		buildHikeDB();

		launch(args);
	}

	/*
	 *	HIKEINFO: "Name", Bathrooms, Water
	 *	ACCESS: Bike, Pass, Dog, Horse
	 *	DIFFICULTY: Length (mi), Elevation Gain (ft), Difficulty Rating (1-5)
	 *	HOURS: "open", "close", time to complete (hrs)
	 */
	private static void buildHikeDB(){
		String sunset = "Sunset";
		String sunrise = "Sunrise";

		HikeInfo hike = new HikeInfo("Bishop Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.5, 950, 5));
		hike.setHours(new Hours(sunrise, sunset, 2));
		hike.setImage("Bishop_Peak.jpg");
		hikes[0] = hike;

		hike = new HikeInfo("Madonna Peak Trail", Boolean.FALSE, Boolean.TRUE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(4, 1100, 4));
		hike.setHours(new Hours(sunrise, sunset, 2.25));
		hike.setImage("Madonna_Peak.jpg");
		hikes[1] = hike;

		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(1, 341, 2));
		hike.setHours(new Hours(sunrise, sunset, 1));
		hike.setImage("The_P.jpg");
		hikes[2] = hike;

		hike = new HikeInfo("Serenity Swing", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.5, 725, 3));
		hike.setHours(new Hours(sunrise, sunset, 2));
		hike.setImage("Serenity_Swing.jpg");
		hikes[3] = hike;

		hike = new HikeInfo("Ontario Ridge Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3, 675, 4));
		hike.setHours(new Hours(sunrise, sunset, 2.5));
		hike.setImage("Ontario_Ridge.jpg");
		hikes[4] = hike;

		hike = new HikeInfo("Valencia Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(4.5, 1275, 3));
		hike.setHours(new Hours(sunrise, sunset, 2.75));
		hike.setImage("Valencia_Peak.jpg");
		hikes[5] = hike;

		hike = new HikeInfo("Poly Canyon Design Village", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(2.5, 300, 2));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hike.setImage("Design_Village.jpg");
		hikes[6] = hike;

		hike = new HikeInfo("Hazard Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(6, 950, 4));
		hike.setHours(new Hours(sunrise, sunset, 3));
		hike.setImage("Hazard_Peak.jpg");
		hikes[7] = hike;

		hike = new HikeInfo("Bob Jones Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(5, 50, 1));
		hike.setHours(new Hours(sunrise, sunset, 2.25));
		hike.setImage("Bob_Jones.jpg");
		hikes[8] = hike;

		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hike.setImage("Elephant_Seals.jpg");
		hikes[9] = hike;

		hike = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours(sunrise, sunset, 1.25));
		hike.setImage("Moonstone_Beach.jpg");
		hikes[10] = hike;

		hike = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		hike.setHours(new Hours(sunrise, sunset, 2));
		hike.setImage("Headlands_Trail.jpg");
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

	private void initializeBottomButtons(Stage stage){
		ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Home.png")));
		image.setFitWidth(35);
		image.setFitHeight(35);
		homeButton.setGraphic(image);
		homeButton.setOnAction(event -> stage.setScene(homeScene()));
		homeButton.setStyle(BOTTOM_BUTTON_STYLE);

		ImageView refresh = new ImageView(new Image(getClass().getResourceAsStream("Refresh.png")));
		ColorAdjust blackout = new ColorAdjust();
		blackout.setBrightness(-1.0);
		refresh.setEffect(blackout);
		refresh.setFitWidth(35);
		refresh.setFitHeight(35);
		refreshButton.setGraphic(refresh);
		refreshButton.setStyle(BOTTOM_BUTTON_STYLE);
		refreshButton.setOnAction(event -> stage.setScene(pickRandomHike()));

		ImageView q = new ImageView(new Image(getClass().getResourceAsStream("questionnaire.png")));
		q.setFitHeight(35);
		q.setFitWidth(35);
		qButton.setGraphic(q);
		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		qButton.setOnAction(event -> stage.setScene(firstQuestion()));

		ImageView back = new ImageView(new Image(getClass().getResourceAsStream("back.png")));
		back.setFitWidth(35);
		back.setFitHeight(35);
		backButton.setGraphic(back);
		backButton.setStyle(BOTTOM_BUTTON_STYLE);

		ImageView all = new ImageView(new Image(getClass().getResourceAsStream("viewAll.png")));
		all.setFitHeight(35);
		all.setFitWidth(35);
		allButtons.setGraphic(all);
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);
		allButtons.setOnAction(event -> stage.setScene(listAllHikes()));
	}

	public void start(Stage primaryStage){
		stage = primaryStage;
		stage.setTitle("Coastbusters");
		title.setFont(Font.font("Futura", FontPosture.ITALIC, 40));
		HBox.setHgrow(r, Priority.ALWAYS);
		VBox.setVgrow(r, Priority.ALWAYS);
		initializeBottomButtons(stage);
		Scene scene = homeScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene homeScene(){
		Text names = new Text();
		VBox root = new VBox(50);
		VBox vBox = new VBox(10);

		/* Prompts the user with a questionnaire to select an ideal hike */
		Button questionnaireButton = new Button("Find A Hike");
		questionnaireButton.setOnAction(event ->stage.setScene(firstQuestion()));
		questionnaireButton.setStyle(IDLE_BUTTON_STYLE);
		questionnaireButton.setOnMouseEntered(event -> questionnaireButton.setStyle(HOVERED_BUTTON_STYLE));
		questionnaireButton.setOnMouseExited(event -> questionnaireButton.setStyle(IDLE_BUTTON_STYLE));
		questionnaireButton.setPrefWidth(200);

		/* Randomly selects a hike for the user */
		Button randomButton = new Button("Get Random Hike");
		randomButton.setOnAction(event -> stage.setScene(pickRandomHike()));
		randomButton.setStyle(IDLE_BUTTON_STYLE);
		randomButton.setOnMouseEntered(event -> randomButton.setStyle(HOVERED_BUTTON_STYLE));
		randomButton.setOnMouseExited(event -> randomButton.setStyle(IDLE_BUTTON_STYLE));
		randomButton.setPrefWidth(200);

		/* Lists all of the hardcoded hikes */
		Button allButton = new Button("View All Hikes");
		allButton.setOnAction(event -> stage.setScene(listAllHikes()));
		allButton.setStyle(IDLE_BUTTON_STYLE);
		allButton.setOnMouseEntered(event -> allButton.setStyle(HOVERED_BUTTON_STYLE));
		allButton.setOnMouseExited(event -> allButton.setStyle(IDLE_BUTTON_STYLE));
		allButton.setPrefWidth(200);

		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(questionnaireButton, randomButton, allButton);

		names.setText("Designed and built by Adam Havstad,\n" +
				      "Rafael Cohn-Gruenwald, Gavin Chao,\n" +
					  "James Kao, Elijah Pinson, and\n" +
					  "Arun Ulagappan.\n" +
					  "2018.");
		names.setTextAlignment(TextAlignment.CENTER);
		names.setFont(Font.font("Helvetica", 10));

		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().addAll(title, vBox, r, names);


		root.setStyle(BACKGROUND_COLOR);

		return new Scene(root, 300, 500);
	}

	private Scene firstQuestion(){
		Label question = new Label(questionnaire.questions[0].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[0].getAnswers()[0]);
		a1.setOnAction(event -> {
				questionnaire.questions[0].setAnswer(0);
				stage.setScene(secondQuestion());
		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(event -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(event -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		Button a2 = new Button(questionnaire.questions[0].getAnswers()[1]);
		a2.setOnAction(event -> {
			questionnaire.questions[0].setAnswer(1);
			stage.setScene(secondQuestion());
		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(event -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(event -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);

		backButton.setOnAction(event -> stage.setScene(homeScene()));

		refreshButton.setDisable(true);
		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);

		return new Scene(vBox, 300, 500);
	}

	private Scene secondQuestion(){
		Label question = new Label(questionnaire.questions[1].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[1].getAnswers()[0]);
		a1.setOnAction(event -> {
			questionnaire.questions[1].setAnswer(0);
			stage.setScene(thirdQuestion());
		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(event -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(event -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		Button a2 = new Button(questionnaire.questions[1].getAnswers()[1]);
		a2.setOnAction(event -> {
			questionnaire.questions[1].setAnswer(1);
			stage.setScene(thirdQuestion());
		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(event -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(event -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);

		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		backButton.setOnAction(event -> stage.setScene(firstQuestion()));

		refreshButton.setDisable(true);
		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene thirdQuestion(){
		Label question = new Label(questionnaire.questions[2].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(50);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[2].getAnswers()[0]);
		a1.setOnAction(event -> {
			questionnaire.questions[2].setAnswer(0);
			stage.setScene(fourthQuestion());
		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(75);

		Button a2 = new Button(questionnaire.questions[2].getAnswers()[1]);
		a2.setOnAction(event -> {
			questionnaire.questions[2].setAnswer(1);
			stage.setScene(fourthQuestion());
		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(75);

		hBox.getChildren().addAll(a1, a2);
		hBox.setAlignment(Pos.CENTER);

		backButton.setOnAction(event -> stage.setScene(secondQuestion()));
		refreshButton.setDisable(true);

		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fourthQuestion(){
		Label question = new Label(questionnaire.questions[3].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(25);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[3].getAnswers()[0]);
		a1.setOnAction(event -> {
			questionnaire.questions[3].setAnswer(0);
			stage.setScene(fifthQuestion());
		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(25);

		Button a2 = new Button(questionnaire.questions[3].getAnswers()[1]);
		a2.setOnAction(event -> {
			questionnaire.questions[3].setAnswer(1);
			stage.setScene(fifthQuestion());

		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(25);

		Button a3 = new Button(questionnaire.questions[3].getAnswers()[2]);
		a3.setOnAction(event -> {
			questionnaire.questions[3].setAnswer(2);
			stage.setScene(fifthQuestion());
		});
		a3.setStyle(IDLE_BUTTON_STYLE);
		a3.setOnMouseEntered(e -> a3.setStyle(HOVERED_BUTTON_STYLE));
		a3.setOnMouseExited(e -> a3.setStyle(IDLE_BUTTON_STYLE));
		a3.setPrefWidth(25);

		Button a4 = new Button(questionnaire.questions[3].getAnswers()[3]);
		a4.setOnAction(event ->  {
			questionnaire.questions[3].setAnswer(3);
			stage.setScene(fifthQuestion());
		});
		a4.setStyle(IDLE_BUTTON_STYLE);
		a4.setOnMouseEntered(e -> a4.setStyle(HOVERED_BUTTON_STYLE));
		a4.setOnMouseExited(e -> a4.setStyle(IDLE_BUTTON_STYLE));
		a4.setPrefWidth(25);

		Button a5 = new Button(questionnaire.questions[3].getAnswers()[4]);
		a5.setOnAction(event ->  {
			questionnaire.questions[3].setAnswer(4);
			stage.setScene(fifthQuestion());

		});
		a5.setStyle(IDLE_BUTTON_STYLE);
		a5.setOnMouseEntered(e -> a5.setStyle(HOVERED_BUTTON_STYLE));
		a5.setOnMouseExited(e -> a5.setStyle(IDLE_BUTTON_STYLE));
		a5.setPrefWidth(25);

		hBox.getChildren().addAll(a1, a2, a3, a4, a5);
		hBox.setAlignment(Pos.CENTER);

		backButton.setOnAction(event -> stage.setScene(thirdQuestion()));
		refreshButton.setDisable(true);
		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fifthQuestion(){
		Label question = new Label(questionnaire.questions[4].getQuestion());
		question.setFont(Font.font("Helvetica",16));

		HBox hBox = new HBox(25);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[4].getAnswers()[0]);
		a1.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(0);
			stage.setScene(computeOptimalHike());
		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(45);

		Button a2 = new Button(questionnaire.questions[4].getAnswers()[1]);
		a2.setOnAction(event ->  {
			questionnaire.questions[4].setAnswer(1);
			stage.setScene(computeOptimalHike());
		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(45);

		Button a3 = new Button(questionnaire.questions[4].getAnswers()[2]);
		a3.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(2);
			stage.setScene(computeOptimalHike());
		});
		a3.setStyle(IDLE_BUTTON_STYLE);
		a3.setOnMouseEntered(e -> a3.setStyle(HOVERED_BUTTON_STYLE));
		a3.setOnMouseExited(e -> a3.setStyle(IDLE_BUTTON_STYLE));
		a3.setPrefWidth(45);

		Button a4 = new Button(questionnaire.questions[4].getAnswers()[3]);
		a4.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(3);
			stage.setScene(computeOptimalHike());
		});
		a4.setStyle(IDLE_BUTTON_STYLE);
		a4.setOnMouseEntered(e -> a4.setStyle(HOVERED_BUTTON_STYLE));
		a4.setOnMouseExited(e -> a4.setStyle(IDLE_BUTTON_STYLE));
		a4.setPrefWidth(45);

		hBox.getChildren().addAll(a1, a2, a3, a4);
		hBox.setAlignment(Pos.CENTER);

		backButton.setOnAction(event -> stage.setScene(fourthQuestion()));
		refreshButton.setDisable(true);
		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
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

		if(qualifiedHikes.isEmpty()){
			return noHikes();
		}else{
			int val = rand.nextInt(qualifiedHikes.size());
			return displayHikeScene(qualifiedHikes.get(val), "Questionnaire");
		}
	}

	private Scene noHikes(){
		HBox hBox = new HBox(10);
		VBox vBox = new VBox(50);

		Label label = new Label("No Matching Hikes, Sorry!");
        label.setFont(Font.font("Helvetica",16));

        refreshButton.setDisable(true);
        backButton.setOnAction(event -> stage.setScene(fifthQuestion()));
		hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(title, label, r, hBox);
		vBox.setStyle(BACKGROUND_COLOR);
		vBox.setAlignment(Pos.TOP_CENTER);

		return new Scene(vBox, 300, 500);
	}

	/* Randomly selects a hike */
	private Scene pickRandomHike(){
		int val = rand.nextInt(9);
		return displayHikeScene(hikes[val], "Random");
	}

	/* Displays the information for the hike that is being passed in as a parameter */
	private Scene displayHikeScene(HikeInfo hike, String parent){
		VBox vBox = new VBox(10);
		HBox hBox = new HBox();
		Region hFiller = new Region();
		hFiller.setPrefHeight(40);

		ImageView img;

		Label hikeName = new Label(hike.getName());
		hikeName.setFont(Font.font("Helvetica",16));


		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);

		refreshButton.setDisable(false);
		if(parent.equals("Random")){
			backButton.setOnAction(event -> stage.setScene(homeScene()));
		}else if(parent.equals("All")){
			backButton.setOnAction(event -> stage.setScene(listAllHikes()));
		}else{
			backButton.setOnAction(event -> stage.setScene(fifthQuestion()));
		}

        hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
        hBox.setAlignment(Pos.CENTER);

		img = hike.getImageView();
		img.setFitHeight(125);
		img.setFitWidth(250);

		vBox.getChildren().addAll(title, hFiller, hikeName, img, r, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setStyle(BACKGROUND_COLOR);

		return new Scene(vBox, 300, 500);
	}

	private void initializeHikeButtons(Button button, HikeInfo hike){
		button.setOnAction(event -> stage.setScene(displayHikeScene(hike, "All")));
		button.setOnMouseEntered(event -> button.setStyle(HOVERED_BUTTON_STYLE));
		button.setOnMouseExited(event -> button.setStyle(IDLE_BUTTON_STYLE));
		button.setWrapText(true);
	}

	private Scene listAllHikes(){
		VBox vBox = new VBox(7.5);
		HBox hBox1 = new HBox(7.5);
		HBox hBox2 = new HBox(7.5);
		HBox hBox3 = new HBox(7.5);
		HBox hBox4 = new HBox(7.5);
		HBox hBox5 = new HBox();

		Region filler = new Region();
		filler.setPrefHeight(40);

		Button[] hikeButtons = new Button[hikes.length];
		HikeInfo temp;

		for(int i = 0; i < 12; i++){
			temp = hikes[i];
			hikeButtons[i] = new Button(temp.getName());
			initializeHikeButtons(hikeButtons[i], hikes[i]);
		}

		for(int i = 0; i < 12; i++){
		    hikeButtons[i].setStyle(IDLE_BUTTON_STYLE);
		    hikeButtons[i].setPrefWidth(85);
		    hikeButtons[i].setPrefHeight(60);
		    hikeButtons[i].setTextAlignment(TextAlignment.CENTER);
        }

		hBox1.getChildren().addAll(hikeButtons[0], hikeButtons[1], hikeButtons[2]);
		hBox1.setAlignment(Pos.CENTER);

		hBox2.getChildren().addAll(hikeButtons[3], hikeButtons[4], hikeButtons[5]);
		hBox2.setAlignment(Pos.CENTER);

		hBox3.getChildren().addAll(hikeButtons[6], hikeButtons[7], hikeButtons[8]);
		hBox3.setAlignment(Pos.CENTER);

		hBox4.getChildren().addAll(hikeButtons[9], hikeButtons[10], hikeButtons[11]);
		hBox4.setAlignment(Pos.CENTER);

		refreshButton.setDisable(true);
		backButton.setOnAction(event -> stage.setScene(homeScene()));
		allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		hBox5.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox5.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, filler, hBox1, hBox2, hBox3, hBox4, r, hBox5);
		vBox.setStyle(BACKGROUND_COLOR);
		vBox.setAlignment(Pos.CENTER);

		return new Scene(vBox, 300, 500);
	}
}
