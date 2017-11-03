package application;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private Stage primaryStage;
	private User user;
	private VBox building;
	private Floor[] flors;


	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Elevator v1.3");
			setStartViewBorderPain(primaryStage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStartViewGridPane(Stage primaryStage) throws FileNotFoundException {

		GridPane grid = new GridPane();
//		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(grid, 1000, 680);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		setUser();
		Floor f = new Floor(1);
		grid.add(f, 0, 0);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setStartViewBorderPain(Stage primaryStage) throws FileNotFoundException {

		BorderPane border = new BorderPane();
		VBox build = new VBox();
		for (int i = 7; i >= 0; i--) {
			build.getChildren().add(new Floor(i));
			
		}
		border.setBottom(build);
		border.setPadding(new Insets(25, 25, 25, 25));
		border.setId("border");
		Scene scene = new Scene(border,500,border.getMaxHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		setUser();
	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setUser(){
		user = new User(0, 0);
		user.setAlignment(Pos.BASELINE_CENTER);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
