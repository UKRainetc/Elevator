package application;

import java.awt.Panel;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private Stage primaryStage;
	private User user;
	private VBox building;
	private Floor[] flors;


	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Elevator v1.3 @autor Maksimenko Aleksandr");
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
		Pane panel = new Pane();
		Building build = new Building();
		Elevator elevator = new Elevator(0);
		
//		for (int i = 7; i >= 0; i--) {
//			build.getChildren().add(new Floor(i));
//			
//		}
//		Floor f0 = new Floor(0);
//		Floor f1 = new Floor(1);
//		Floor f2 = new Floor(2);
//		Floor f3 = new Floor(3);
//		Floor f4 = new Floor(4);
//		Floor f5 = new Floor(5);
//		Floor f6 = new Floor(6);
//		Floor f7 = new Floor(7);
		
//		build.getChildren().addAll(f7,f6,f5,f4,f3,f2,f1,f0);
		new Thread(new MoveUser(build)).start();
//		build.getChildren().addAll(mu.getFloors());
//		mu.addUser(f0);
//		try {
//			mu.call();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		elevator.setLayoutX(300.0);
//		elevator.setLayoutY(345.0);
		elevator.setCurentFloor(5);
		elevator.startTask(1);


		panel.getChildren().addAll(build,elevator);
		border.setCenter(panel);
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
