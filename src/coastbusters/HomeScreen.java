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
	
	Button questionnaire;
	Button random;
	Button all;
	
	Label title;
	/*VBox root = new VBox();*/
	
	
	public static void main(String[] args) {
		/* Rafi is going to hardcode hikes in */
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Coastbusters");
		
		Pane root = new Pane();
		
		title = new Label("Coastbusters");
		
		questionnaire = new Button("Find A Hike");
		questionnaire.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* go questionnaire */
			}
		});
		
		random = new Button("Get Random Hike");
		random.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* randomly generate a hike */
			}
		});
		
		all = new Button("View All Hikes");
		all.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				/* Listing of all hikes */
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
	}
	
}
