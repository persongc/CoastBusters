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


public class HomeScreen extends Application {
	
	protected static Questionnaire questionnaire = new Questionnaire();
	//protected String[] questions = {""}
	//Button random;
	//Button all;

	private Stage stage;
	
	Label title;
	/*VBox root = new VBox();*/
	
	
	public static void main(String[] args) {
		/* Rafi is going to hardcode hikes into Hike Database class */

		buildQuestionnaire();
		
		launch(args);
	}

	protected static void buildQuestionnaire(){
		String[] a1 = {"Yes", "No"};
		String[] a2 = {"1", "2", "3", "4", "5"};

		questionnaire.questions.add(new Question("Pet Friendly?", a1));
		questionnaire.questions.add(new Question("Horse Friendly?", a1));
		questionnaire.questions.add(new Question("Bike Friendly?", a1));
		questionnaire.questions.add(new Question("Difficulty?", a2));



	}
	
	/*@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Coastbusters");
		
		Pane root = new Pane();
		
		title = new Label("Coastbusters");
		
		questionnaire = new Button("Find A Hike");
		questionnaire.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				 //go questionnaire
			}
		});
		
		random = new Button("Get Random Hike");
		random.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//randomly generate a hike
			}
		});
		
		all = new Button("View All Hikes");
		all.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Listing of all hikes
			}
		});
		
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		title.setLayoutX(100);
		title.setLayoutY(10);
		questionnaire.setLayoutX(100);
		questionnaire.setLayoutY(75);
		random.setLayoutX(100);
		random.setLayoutY(150);
		all.setLayoutX(100);
		all.setLayoutY(225);
		
		
		root.getChildren().addAll(title, questionnaire, random, all);
		
		stage.show();
	}*/

	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		stage.setTitle("Coastbusters");
		Scene scene = homeScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Scene homeScene(){
		VBox root = new VBox();
		title = new Label("Coastbusters");

		Button questionnaireButton = new Button("Find A Hike");
		questionnaireButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//go to questionnaire
				stage.setScene(QuestionnaireScene());
			}
		});

		Button randomButton = new Button("Get Random Hike");
		randomButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//randomly generate a hike
			}
		});

		Button allButton = new Button("View All Hikes");
		allButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Listing of all hikes
			}
		});

		/*title.setLayoutX(100);
		title.setLayoutY(10);
		questionnaireButton.setLayoutX(100);
		questionnaireButton.setLayoutY(75);
		randomButton.setLayoutX(100);
		randomButton.setLayoutY(150);
		allButton.setLayoutX(100);
		allButton.setLayoutY(225);
		*/

		root.getChildren().addAll(title, questionnaireButton, randomButton, allButton);

		Scene scene = new Scene(root, 300, 300);

		return scene;
	}

	protected Scene QuestionnaireScene(){

	}
	
}
