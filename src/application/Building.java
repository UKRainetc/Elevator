package application;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class Building extends VBox {
	private Floor floor;
	private Floor[] floors = new Floor[8];

	public Building() {
		for (int i = 0; i < floors.length; i++) {
			floors[i] = new Floor((floors.length - i) - 1);
		}
		getChildren().addAll(floors);

	}

	public Floor[] getFloors() {
		System.out.println("Build getFloors");
		return floors;
	}

}
