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

import java.util.Random;


public class HomeScreen extends Application {
	
	protected static Questionnaire questionnaire = new Questionnaire();
	protected static HikeInfo[] hikes = new HikeInfo[12];
	//protected String[] questions = {""}
	//Button random;
	//Button all;

	private Stage stage;
	
	Label title;
	/*VBox root = new VBox();*/
	
	
	public static void main(String[] args) {
		/* Rafi is going to hardcode hikes into Hike Database array */
		buildQuestionnaire();
		buildHikeDB();
		
		launch(args);
	}

	/*
		HIKEINFO: "Name", Bathrooms, Water
		ACCESS: Bike, Pass, Dog, Horse
		DIFFICULTY: Length, Elevation Gain, Difficulty Rating
		HOURS: "open", "close", time

	 */

	protected static void buildHikeDB(){
		Boolean T = new Boolean("TRUE");
		Boolean F = new Boolean("FALSE");

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
		hike.setAccess(new Access(T, F, T, T));
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

		hike = new HikeInfo("Holder 1", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(0, 0, 0));
		hike.setHours(new Hours("Sunrise", "Sunset", 0));
		hikes[9] = hike;

		hike = new HikeInfo("Holder 2", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(0, 0, 0));
		hike.setHours(new Hours("Sunrise", "Sunset", 0));
		hikes[10] = hike;

		hike = new HikeInfo("Holder 3", F, F);
		hike.setAccess(new Access(T, F, T, T));
		hike.setDifficulty(new Difficulty(0, 0, 0));
		hike.setHours(new Hours("Sunrise", "Sunset", 0));
		hikes[11] = hike;
	}

	protected static void buildQuestionnaire(){
		String[] a1 = {"Yes", "No"};
		String[] a2 = {"1", "2", "3", "4", "5"};

		questionnaire.questions.add(new Question("Dog Friendly?", a1));
		questionnaire.questions.add(new Question("Horse Friendly?", a1));
		questionnaire.questions.add(new Question("Bike Friendly?", a1));
		questionnaire.questions.add(new Question("Difficulty?", a2));

	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		stage.setTitle("Coastbusters");
		Scene scene = homeScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Scene homeScene(){
		Pane root = new Pane();
		title = new Label("Coastbusters");

		Button questionnaireButton = new Button("Find A Hike");
		questionnaireButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//go to questionnaire
				//stage.setScene(QuestionnaireScene());
			}
		});

		Button randomButton = new Button("Get Random Hike");
		randomButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(pickRandomHike());
			}
		});

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

	protected Scene pickRandomHike(){
		Random rand = new Random();
		int val = rand.nextInt(9);
		System.out.println("Random val" + val);
		return displayHikeScene(hikes[val]);
	}

	protected Scene displayHikeScene(HikeInfo hike){
		Pane root = new Pane();
		//title = new Label("Coastbusters");
		Label hikeName = new Label(hike.getName());
		Button homeButton = new Button("Home");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(homeScene());
			}
		});
		hikeName.setLayoutY(30);
		hikeName.setLayoutX(100);

		root.getChildren().addAll(hikeName, homeButton);
		return new Scene(root, 300, 500);
	}

	private void initializeHikeButtons(Button button, HikeInfo hike){
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(displayHikeScene(hike));
			}
		});
	}

	protected Scene listAllHikes(){
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
