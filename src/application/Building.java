package application;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class Building extends VBox {
	private Floor floor;
	
	public Building() {
		for (int i = 7; i >= 0; i--) {
			getChildren().add(new Floor(i));
			
		}
	}
	
	
}
