package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
		
	private Stage primaryStage = new Stage();
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene primary = new Scene(root, 1000, 650);
			Button search = new Button("Search");
			search.setOnAction(e -> {
				displaySearchForm(primary);
			});
			primary.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("UNF Apartments");
			primaryStage.setScene(primary);
			primaryStage.show();
			this.primaryStage = primaryStage;
		} catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void displaySearchForm (Scene primary) {
		SearchForm formPage = new SearchForm();   
		VBox form = (VBox) formPage.getNode();
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(e -> {
			Question q = createQuestion(formPage);
			System.out.println(q.getQuestion());
			db.addQ(q.getTopic(), q);
		});
		submitButton.setId("question");
		form.getChildren().add(submitButton);
		Scene newScene = new Scene(form, 600, 200);
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		//dialog.initOwner(primaryStage);
		dialog.setHeight(500.0);
		dialog.setScene(newScene);
		dialog.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
