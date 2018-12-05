package logic;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeScreen extends Application {
	
	private static Questionnaire questionnaire = new Questionnaire();
	private static HikeInfo[] hikes = new HikeInfo[12];
	private Stage stage;
	private Random rand = new Random();
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #e6c58d; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #f7d193; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px; -fx-background-radius: 10; -fx-border-radius: 10;";
	private static final String BACKGROUND_COLOR = "-fx-background-color: #FFEDCF;";
	private static final String BOTTOM_BUTTON_STYLE = "-fx-background-color: #e6c58d; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px;";
	private static final String CURRENT_BOTTOM_BUTTON_STYLE = "-fx-background-color: #f7d193; -fx-border-color: #cca054; " +
			"-fx-border-width: 1px;";
	private static final String HELVETICA = "Helvetica";
	private Label title = new Label("Coastbusters");
	private static Button homeButton = new Button();
	private static Button refreshButton = new Button();
	private static Button qButton = new Button();
	private static Button backButton = new Button();
	private static Button allButtons = new Button();
	private Region r = new Region();
	private static final String SUNSET = "Sunset";
	private static final String SUNRISE = "Sunrise";
	private static final String WEATHERAPI = "http://api.openweathermap.org/data/2.5/weather?zip=93401,us&appid=f63269cfb2876c2790032ef911956ac2";
	
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
	private static HikeInfo createBishopPeakTrail()
	{
		HikeInfo hike = new HikeInfo("Bishop Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.5, 950, 5));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Bishop_Peak.jpg");
		
		return hike;
	}
	
	private static HikeInfo createMadonnaPeakTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Madonna Peak Trail", Boolean.FALSE, Boolean.TRUE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(4, 1100, 4));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2.25));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Madonna_Peak.jpg");
		return hike;
	}
	
	private static HikeInfo createOntarioRidgeTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Ontario Ridge Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3, 675, 4));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2.5));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Ontario_Ridge.jpg");
		return hike;
	}
	
	private static HikeInfo createSerenitySwing()
	{
		HikeInfo hike;
		hike = new HikeInfo("Serenity Swing", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.5, 725, 3));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Serenity_Swing.jpg");
		return hike;
	}
	
	private static HikeInfo createValenciaPeakTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Valencia Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(4.5, 1275, 3));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2.75));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Valencia_Peak.jpg");
		return hike;
	}
	
	private static HikeInfo createPolyCanyonDesignVillage()
	{
		HikeInfo hike;
		hike = new HikeInfo("Poly Canyon Design Village", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(2.5, 300, 2));
		hike.setHours(new Hours(SUNRISE, SUNSET, 1.25));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Design_Village.jpg");
		return hike;
	}
	
	private static HikeInfo createHazardPeakTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Hazard Peak Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(6, 950, 4));
		hike.setHours(new Hours(SUNRISE, SUNSET, 3));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Hazard_Peak.jpg");
		return hike;
	}
	
	private static HikeInfo createBobJonesTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Bob Jones Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE));
		hike.setDifficulty(new Difficulty(5, 50, 1));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2.25));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Bob_Jones.jpg");
		return hike;
	}
	
	private static HikeInfo createPiedrasBlancas()
	{
		HikeInfo hike;
		hike = new HikeInfo("Piedras Blancas Elephant Seal Rookery", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(3.2, 25, 1));
		hike.setHours(new Hours(SUNRISE, SUNSET, 1.25));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Elephant_Seals.jpg");
		return hike;
	}
	
	private static HikeInfo createMoonstoneBeach()
	{
		HikeInfo hike;
		hike = new HikeInfo("Moonstone Beach Boardwalk", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(2.85, 40, 1));
		hike.setHours(new Hours(SUNRISE, SUNSET, 1.25));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Moonstone_Beach.jpg");
		return hike;
	}
	
	private static HikeInfo createHeadlandsTrail()
	{
		HikeInfo hike;
		hike = new HikeInfo("Headlands Trail", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(4.5, 135, 2));
		hike.setHours(new Hours(SUNRISE, SUNSET, 2));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("Headlands_Trail.jpg");
		return hike;
	}
	
	private static HikeInfo createPHike()
	{
		HikeInfo hike;
		hike = new HikeInfo("Cal Poly \"P\"", Boolean.FALSE, Boolean.FALSE);
		hike.setAccess(new Access(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		hike.setDifficulty(new Difficulty(1, 341, 2));
		hike.setHours(new Hours(SUNRISE, SUNSET, 1));
		hike.setWeather(new Weather(WEATHERAPI, 0));
		hike.setImage("The_P.jpg");
		return hike;
	}
	
	
	
	private static void buildHikeDB(){
		hikes[0] = createBishopPeakTrail();

		hikes[1] = createMadonnaPeakTrail();

		hikes[2] = createPHike();

		hikes[3] = createSerenitySwing();

		hikes[4] = createOntarioRidgeTrail();

		hikes[5] = createValenciaPeakTrail();

		hikes[6] = createPolyCanyonDesignVillage();

		hikes[7] = createHazardPeakTrail();

		hikes[8] = createBobJonesTrail();

		hikes[9] = createPiedrasBlancas();

		hikes[10] = createMoonstoneBeach();

		hikes[11] = createHeadlandsTrail();
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
		Scene scene = introduction();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene introduction(){
		VBox vBox = new VBox(10);
		HBox hBox = new HBox();

		Region fill = new Region();
		fill.setPrefWidth(100);
		Region fill1 = new Region();
		fill1.setPrefHeight(25);
		Region fill2 = new Region();
		fill2.setPrefHeight(80);

		Button letsGo = new Button("Let's Go!");
		letsGo.setOnAction(event -> stage.setScene(homeScene()));
		letsGo.setStyle(IDLE_BUTTON_STYLE);
		letsGo.setOnMouseEntered(event -> letsGo.setStyle(HOVERED_BUTTON_STYLE));
		letsGo.setOnMouseExited(event -> letsGo.setStyle(IDLE_BUTTON_STYLE));
		letsGo.setPrefWidth(175);

		VBox vBox1 = new VBox(20);

		Text intro = new Text();
		intro.setText("Welcome to Coastbusters!");
		intro.setFont(Font.font(HELVETICA, 20));

		Text intro1 = new Text();
		intro1.setText("In this app you can:\n\n" +
				       "1. Answer a questionnaire\n" +
					   "   to allow us to suggest\n" +
					   "   a place to hike.\n\n" +
					   "2. Get a random hike.\n\n" +
					   "3. View our curated hikes\n" +
					   "   and select one yourself.");
		intro1.setFont(Font.font(HELVETICA, 16));
		vBox1.getChildren().addAll(intro, intro1);
		vBox1.setAlignment(Pos.CENTER);

		hBox.getChildren().addAll(letsGo);
		hBox.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, fill1, vBox1, fill2, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setStyle(BACKGROUND_COLOR);

		return new Scene(vBox, 300, 500);
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
		names.setFont(Font.font(HELVETICA, 10));

		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().addAll(title, vBox, r, names);


		root.setStyle(BACKGROUND_COLOR);

		return new Scene(root, 300, 500);
	}

	private void createQBottom()
	{

		refreshButton.setDisable(true);
		qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		qButton.setOnMouseExited(event -> qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);
		allButtons.setOnMouseEntered(event -> allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		allButtons.setOnMouseExited(event -> allButtons.setStyle(BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseEntered(event -> homeButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseExited(event -> homeButton.setStyle(BOTTOM_BUTTON_STYLE));
		
	}
	
	private Scene firstQuestion(){
		Label question = new Label(questionnaire.questions[0].getQuestion());
		question.setFont(Font.font(HELVETICA,16));

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
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		createQBottom();
		
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
		question.setFont(Font.font(HELVETICA,16));

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
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		createQBottom();
		
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene thirdQuestion(){
		Label question = new Label(questionnaire.questions[2].getQuestion());
		question.setFont(Font.font(HELVETICA,16));

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
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		createQBottom();
		
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fourthQuestion(){
		Label question = new Label(questionnaire.questions[3].getQuestion());
		question.setFont(Font.font(HELVETICA,16));

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
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		createQBottom();
		
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private Scene fifthQuestion(){
		final String INVALID = "Invalid";
		final String QUESTIONNAIRE = "Questionnaire";
		Label question = new Label(questionnaire.questions[4].getQuestion());
		question.setFont(Font.font(HELVETICA,16));

		HBox hBox = new HBox(25);
		HBox hBox1 = new HBox();
		VBox vBox = new VBox(50);

		Button a1 = new Button(questionnaire.questions[4].getAnswers()[0]);
		a1.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(0);
			HikeInfo selectedHike = computeOptimalHike();
			if(selectedHike.getName().equals(INVALID)){
				stage.setScene(noHikes());
			} else {
				stage.setScene(displayHikeScene(selectedHike, QUESTIONNAIRE));
			}

		});
		a1.setStyle(IDLE_BUTTON_STYLE);
		a1.setOnMouseEntered(e -> a1.setStyle(HOVERED_BUTTON_STYLE));
		a1.setOnMouseExited(e -> a1.setStyle(IDLE_BUTTON_STYLE));
		a1.setPrefWidth(45);

		Button a2 = new Button(questionnaire.questions[4].getAnswers()[1]);
		a2.setOnAction(event ->  {
			questionnaire.questions[4].setAnswer(1);
			HikeInfo selectedHike = computeOptimalHike();
			if(selectedHike.getName().equals(INVALID)){
				stage.setScene(noHikes());
			} else {
				stage.setScene(displayHikeScene(selectedHike, QUESTIONNAIRE));
			}
		});
		a2.setStyle(IDLE_BUTTON_STYLE);
		a2.setOnMouseEntered(e -> a2.setStyle(HOVERED_BUTTON_STYLE));
		a2.setOnMouseExited(e -> a2.setStyle(IDLE_BUTTON_STYLE));
		a2.setPrefWidth(45);

		Button a3 = new Button(questionnaire.questions[4].getAnswers()[2]);
		a3.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(2);
			HikeInfo selectedHike = computeOptimalHike();
			if(selectedHike.getName().equals(INVALID)){
				stage.setScene(noHikes());
			} else {
				stage.setScene(displayHikeScene(selectedHike, QUESTIONNAIRE));
			}
		});
		a3.setStyle(IDLE_BUTTON_STYLE);
		a3.setOnMouseEntered(e -> a3.setStyle(HOVERED_BUTTON_STYLE));
		a3.setOnMouseExited(e -> a3.setStyle(IDLE_BUTTON_STYLE));
		a3.setPrefWidth(45);

		Button a4 = new Button(questionnaire.questions[4].getAnswers()[3]);
		a4.setOnAction(event -> {
			questionnaire.questions[4].setAnswer(3);
			HikeInfo selectedHike = computeOptimalHike();
			if(selectedHike.getName().equals(INVALID)){
				stage.setScene(noHikes());
			} else {
				stage.setScene(displayHikeScene(selectedHike, QUESTIONNAIRE));
			}
		});
		a4.setStyle(IDLE_BUTTON_STYLE);
		a4.setOnMouseEntered(e -> a4.setStyle(HOVERED_BUTTON_STYLE));
		a4.setOnMouseExited(e -> a4.setStyle(IDLE_BUTTON_STYLE));
		a4.setPrefWidth(45);

		hBox.getChildren().addAll(a1, a2, a3, a4);
		hBox.setAlignment(Pos.CENTER);

		backButton.setOnAction(event -> stage.setScene(fourthQuestion()));
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		createQBottom();
		
		hBox1.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox1.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, question, hBox, r, hBox1);
		vBox.setAlignment(Pos.TOP_CENTER);

		vBox.setStyle(BACKGROUND_COLOR);
		return new Scene(vBox, 300, 500);
	}

	private int[] computeFirstQ(){
		int[] temp1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		if(questionnaire.questions[0].getAnswer() == 0){
			for(int i = 0; i < 12; i++){
				if(hikes[i].getAccess().getDog().equals(Boolean.FALSE)){
					temp1[i] = 0;
				}
			}
		}
		return temp1;
	}

	private int[] computeSecondQ(int[] temp){
		int[] temp2 = new int[12];
		for(int i = 0; i < 12; i++){
			if((temp[i] != 0) && (hikes[i].getAccess().getHorse().equals(Boolean.TRUE))){
				temp2[i] = 1;
			}
		}
		return temp2;
	}

	private int[] computeThirdQ(int[] temp){
		int[] temp3 = new int[12];

		for(int i = 0; i < 12; i++){
			if((temp[i] != 0) && (hikes[i].getAccess().getBike().equals(Boolean.TRUE))){
				temp3[i] = 1;
			}
		}
		return temp3;
	}

	private int[] computeFourthQ(int[] temp){
		int[] temp4 = new int[12];

		for(int i = 0; i < 12; i++){
			if((temp[i] != 0) && (hikes[i].getDifficulty().getDiffRating() == (questionnaire.questions[3].getAnswer() + 1))){
				temp4[i] = 1;
			}
		}

		return temp4;
	}

	private int[] computeFifthQ(int[] temp){
		int[] temp5 = new int[12];

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
			if(temp[i] != 0){
				len = hikes[i].getDifficulty().getLength();
				if(len >= desiredLen[0] && len < desiredLen[1]){
					temp5[i] = 1;
				}
			}
		}

		return temp5;
	}

	private HikeInfo computeOptimalHike(){
		int[] temp1;
		int[] temp2;
		int[] temp3;
		int[] temp4;
		int[] temp5;
		ArrayList<HikeInfo> qualifiedHikes = new ArrayList<>();

		temp1 = computeFirstQ();

		if(questionnaire.questions[1].getAnswer() == 0){
			temp2 = computeSecondQ(temp1);
		}else{
			temp2 = temp1;
		}

		if(questionnaire.questions[2].getAnswer() == 0){
			temp3 = computeThirdQ(temp2);
		}else{
			temp3 = temp2;
		}

		temp4 = computeFourthQ(temp3);

		temp5 = computeFifthQ(temp4);

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
			return new HikeInfo();
		}else{
			int val = rand.nextInt(qualifiedHikes.size());
			return qualifiedHikes.get(val);
		}
	}

	private Scene noHikes(){
		HBox hBox = new HBox();
		VBox vBox = new VBox(50);

		Label label = new Label("No Matching Hikes, Sorry!");
        label.setFont(Font.font(HELVETICA,16));

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
		hFiller.setPrefHeight(20);
		Region hFiller2 = new Region();
		hFiller2.setPrefHeight(20);

		Button viewHikeInfo = new Button("View Hike Info");
		viewHikeInfo.setOnAction(event -> stage.setScene(viewHike(hike, parent)));
		viewHikeInfo.setStyle(IDLE_BUTTON_STYLE);
		viewHikeInfo.setOnMouseEntered(event -> viewHikeInfo.setStyle(HOVERED_BUTTON_STYLE));
		viewHikeInfo.setOnMouseExited(event -> viewHikeInfo.setStyle(IDLE_BUTTON_STYLE));
		viewHikeInfo.setPrefWidth(200);

		Button viewWeather = new Button("View Weather");
		viewWeather.setOnAction(event -> stage.setScene(viewWeather(hike, parent)));
		viewWeather.setStyle(IDLE_BUTTON_STYLE);
		viewWeather.setOnMouseEntered(event -> viewWeather.setStyle(HOVERED_BUTTON_STYLE));
		viewWeather.setOnMouseExited(event -> viewWeather.setStyle(IDLE_BUTTON_STYLE));
		viewWeather.setPrefWidth(200);


		Label hikeName = new Label(hike.getName());
		hikeName.setFont(Font.font(HELVETICA,16));


		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		qButton.setOnMouseEntered(event -> qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		qButton.setOnMouseExited(event -> qButton.setStyle(BOTTOM_BUTTON_STYLE));
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);
		allButtons.setOnMouseEntered(event -> allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		allButtons.setOnMouseExited(event -> allButtons.setStyle(BOTTOM_BUTTON_STYLE));
		backButton.setStyle(BOTTOM_BUTTON_STYLE);
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		homeButton.setStyle(BOTTOM_BUTTON_STYLE);
		homeButton.setOnMouseEntered(event -> homeButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseExited(event -> homeButton.setStyle(BOTTOM_BUTTON_STYLE));
		refreshButton.setDisable(false);
		refreshButton.setStyle(BOTTOM_BUTTON_STYLE);
		refreshButton.setOnMouseEntered(event -> refreshButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		refreshButton.setOnMouseExited(event -> refreshButton.setStyle(BOTTOM_BUTTON_STYLE));

		switch(parent){
			case "Random":
				backButton.setOnAction(event -> stage.setScene(homeScene()));
				break;
			case "All":
				backButton.setOnAction(event -> stage.setScene(listAllHikes()));
				break;
			default:
				backButton.setOnAction(event -> stage.setScene(fifthQuestion()));
				break;

		}

        hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
        hBox.setAlignment(Pos.CENTER);

		ImageView img;
		img = hike.getImageView();
		img.setFitHeight(125);
		img.setFitWidth(250);

		Button imageButton = new Button();
		imageButton.setGraphic(img);
		imageButton.setOnAction(event -> stage.setScene(imageScene(hike, parent)));
		imageButton.setStyle(BACKGROUND_COLOR);

		vBox.getChildren().addAll(title, hFiller, hikeName, imageButton, hFiller2, viewHikeInfo, viewWeather, r, hBox);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setStyle(BACKGROUND_COLOR);

		return new Scene(vBox, 300, 500);
	}

	private void genBottomButtons(HikeInfo hike, String parent)
	{
		refreshButton.setDisable(true);
		backButton.setOnAction(event -> stage.setScene(displayHikeScene(hike, parent)));
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		allButtons.setStyle(BOTTOM_BUTTON_STYLE);
		allButtons.setOnMouseEntered(event -> allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		allButtons.setOnMouseExited(event -> allButtons.setStyle(BOTTOM_BUTTON_STYLE));
		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		qButton.setOnMouseEntered(event -> qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		qButton.setOnMouseExited(event -> qButton.setStyle(BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseEntered(event -> homeButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseExited(event -> homeButton.setStyle(BOTTOM_BUTTON_STYLE));
	}
	
	private Scene imageScene(HikeInfo hike, String parent){
		VBox root = new VBox();
		HBox hBox = new HBox();

		hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox.setAlignment(Pos.CENTER);

		genBottomButtons(hike, parent);

		ImageView img = hike.getImageView();
		img.setFitHeight(512);
		img.setFitWidth(1024);

		root.getChildren().addAll(title, img, hBox);
		root.setStyle(BACKGROUND_COLOR);
		root.setAlignment(Pos.CENTER);

		return new Scene(root, 1050, 625);
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
		backButton.setOnMouseEntered(event -> backButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		backButton.setOnMouseExited(event -> backButton.setStyle(BOTTOM_BUTTON_STYLE));
		allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE);
		allButtons.setOnMouseExited(event -> allButtons.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		qButton.setStyle(BOTTOM_BUTTON_STYLE);
		qButton.setOnMouseEntered(event -> qButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		qButton.setOnMouseExited(event -> qButton.setStyle(BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseEntered(event -> homeButton.setStyle(CURRENT_BOTTOM_BUTTON_STYLE));
		homeButton.setOnMouseExited(event -> homeButton.setStyle(BOTTOM_BUTTON_STYLE));
		
		hBox5.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox5.setAlignment(Pos.CENTER);

		vBox.getChildren().addAll(title, filler, hBox1, hBox2, hBox3, hBox4, r, hBox5);
		vBox.setStyle(BACKGROUND_COLOR);
		vBox.setAlignment(Pos.CENTER);

		return new Scene(vBox, 300, 500);
	}

	private Scene viewHike(HikeInfo hike, String parent){
		VBox root = new VBox(20);
		VBox answers = new VBox(5);
		VBox questions = new VBox(5);
		HBox hBox = new HBox();
		HBox results = new HBox(20);
		Region fill = new Region();
		fill.setPrefHeight(25);

		Text name = new Text(hike.getName());
		name.setFont(Font.font(HELVETICA, 20));

		Text diff = new Text();
		diff.setText("" + hike.getDifficulty().getLength() + " miles long. " + hike.getDifficulty().getElevGain() + " ft elevation gain.\n" +
				"Estimated completion time is " + hike.getHours().getTime() + " hours.");
		diff.setFont(Font.font(HELVETICA, 14));

		Text h1 = new Text("Horse Friendly?");
		h1.setFont(Font.font(HELVETICA, 14));
		Text b1 = new Text("Bike Friendly?");
		b1.setFont(Font.font(HELVETICA, 14));
		Text d1 = new Text("Dog Friendly?");
		d1.setFont(Font.font(HELVETICA, 14));
		Text p1 = new Text("Pass Required?");
		p1.setFont(Font.font(HELVETICA, 14));
		Text ba1 = new Text("Bathrooms Available?");
		ba1.setFont(Font.font(HELVETICA, 14));
		Text w1 = new Text("Water Available?");
		w1.setFont(Font.font(HELVETICA, 14));
		Text ho1 = new Text("Hours Open:");
		ho1.setFont(Font.font(HELVETICA, 14));

		Text h2 = ((hike.getAccess().getHorse()) ? new Text("Yes.") : new Text("No."));
		h2.setFont(Font.font(HELVETICA, 14));
		Text b2 = ((hike.getAccess().getBike()) ? new Text("Yes.") : new Text("No."));
		b2.setFont(Font.font(HELVETICA, 14));
		Text d2 = ((hike.getAccess().getDog()) ? new Text("Yes.") : new Text("No."));
		d2.setFont(Font.font(HELVETICA, 14));
		Text p2 = ((hike.getAccess().getPass()) ? new Text("Yes.") : new Text("No."));
		p2.setFont(Font.font(HELVETICA, 14));
		Text ba2 = ((hike.getBathrooms()) ? new Text("Yes.") : new Text("No."));
		ba2.setFont(Font.font(HELVETICA, 14));
		Text w2 = ((hike.getWater()) ? new Text("Yes.") : new Text("No."));
		w2.setFont(Font.font(HELVETICA, 14));
		Text ho2 = new Text("" + hike.getHours().getOpen() + " to " + hike.getHours().getClose());
		ho2.setFont(Font.font(HELVETICA, 14));

		genBottomButtons(hike, parent);
		
		hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox.setAlignment(Pos.CENTER);

		answers.getChildren().addAll(h1, b1, d1, p1, ba1, w1, ho1);
		questions.getChildren().addAll(h2, b2, d2, p2, ba2, w2, ho2);
		results.getChildren().addAll(answers, questions);
		results.setAlignment(Pos.CENTER);

		root.getChildren().addAll(title, fill, name, diff, results, r, hBox);
		root.setStyle(BACKGROUND_COLOR);
		root.setAlignment(Pos.CENTER);

		return new Scene(root, 300, 500);
	}

	private Scene viewWeather(HikeInfo hike, String parent){
		Label label = new Label(hike.getName());
		label.setFont(Font.font(HELVETICA, 20));
		VBox root = new VBox(10);
		VBox vBox = new VBox(5);
		HBox hBox = new HBox();

		try{
			weather(hike.getWeather());

			ImageView image = new ImageView(new Image(getClass().getResourceAsStream(hike.getWeather().getForecast())));
			image.setFitWidth(100);
			image.setFitHeight(100);

			Text t = new Text();
			t.setText("Current Weather");
			t.setFont(Font.font(HELVETICA, 20));

			Text t1 = new Text();
			t1.setText("Temperature: " + hike.getWeather().getCurrTemp());
			t1.setFont(Font.font(HELVETICA, 16));

			Text t2 = new Text();
			t2.setText("Daily High: " + hike.getWeather().getHigh());
			t2.setFont(Font.font(HELVETICA, 16));

			Text t3 = new Text();
			t3.setText("Daily Low: " + hike.getWeather().getLow());
			t3.setFont(Font.font(HELVETICA, 16));

			Text t4 = new Text();
			t4.setText("Windspeeds: " + hike.getWeather().getWind());
			t4.setFont(Font.font(HELVETICA, 16));

			vBox.getChildren().addAll(t, image, t1, t2, t3, t4);
			vBox.setAlignment(Pos.CENTER);

		} catch(IOException e){
			Text t = new Text("Weather cannot be displayed.\n" +
							  "Please check your internet connection.");
			vBox.getChildren().addAll(t);
			vBox.setAlignment(Pos.CENTER);
		}

		genBottomButtons(hike, parent);
		
		hBox.getChildren().addAll(refreshButton, backButton, qButton, allButtons, homeButton);
		hBox.setAlignment(Pos.CENTER);

		root.getChildren().addAll(title, label, vBox, r, hBox);
		root.setAlignment(Pos.TOP_CENTER);
		root.setStyle(BACKGROUND_COLOR);

		return new Scene(root, 300, 500);
	}

	private static void weather(Weather hikeWeather) throws IOException {
		StringBuilder temp = new StringBuilder();
		try
		{
			URL url = new URL(hikeWeather.getURL());

			URLConnection con = url.openConnection();

			InputStream is =con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line = "";
			if(line == "")
			{
				while ((line = br.readLine()) != null) {
					temp.append(line);
				}
				line = temp.toString();
			}
			
			Logger log = Logger.getGlobal();
			log.log(Level.INFO,line);
			
			
		}
		catch(IOException e)
		{
			hikeWeather.setForecast(null);
			hikeWeather.setCurrTemp(null);
			hikeWeather.setHigh(null);
			hikeWeather.setLow(null);
			hikeWeather.setWind(null);
			return;
		}

		Random r = new Random();
		int low = 10;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		int num = (result % 100) / 10;
		
		final String FIFTYF = "50 ºF";
		final String RAIN = "Rain.jpg";
		if (num == 1)
		{
			hikeWeather.setForecast("Cloudy.jpg");
			hikeWeather.setCurrTemp("55 ºF");
			hikeWeather.setHigh("57 ºF");
			hikeWeather.setLow(FIFTYF);
			hikeWeather.setWind("1 mph");
		}
		else if (num == 2)
		{
			hikeWeather.setForecast(RAIN);
			hikeWeather.setCurrTemp("49 ºF");
			hikeWeather.setHigh("51 ºF");
			hikeWeather.setLow("43 ºF");
			hikeWeather.setWind("3 mph");
		}
		else if (num == 3)
		{
			hikeWeather.setForecast("Partly Cloudy.jpg");
			hikeWeather.setCurrTemp("63 ºF");
			hikeWeather.setHigh("70 ºF");
			hikeWeather.setLow("60 ºF");
			hikeWeather.setWind("0 mph");
		}
		else if (num == 4)
		{
			hikeWeather.setForecast("Sunny.jpg");
			hikeWeather.setCurrTemp("52 ºF");
			hikeWeather.setHigh("57 ºF");
			hikeWeather.setLow(FIFTYF);
			hikeWeather.setWind("4 mph");
		}
		else if (num == 5)
		{
			hikeWeather.setForecast(RAIN);
			hikeWeather.setCurrTemp("49 ºF");
			hikeWeather.setHigh(FIFTYF);
			hikeWeather.setLow("39 ºF");
			hikeWeather.setWind("4 mph");
		}
		else if (num == 6)
		{
			hikeWeather.setForecast("Sunny.jpg");
			hikeWeather.setCurrTemp("58 ºF");
			hikeWeather.setHigh("61 ºF");
			hikeWeather.setLow("55 ºF");
			hikeWeather.setWind("2 mph");
		}
		else
		{
			hikeWeather.setForecast(RAIN);
			hikeWeather.setCurrTemp("62 ºF");
			hikeWeather.setHigh("65 ºF");
			hikeWeather.setLow("52 ºF");
			hikeWeather.setWind("5 mph");
		}
	}
}
