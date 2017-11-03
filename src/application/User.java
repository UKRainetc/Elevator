package application;

import javafx.scene.control.Label;


public class User extends Label {

	private int currentFloor = 0;
	private int destinationFloor = 0;
	private static String MALE = "\uf182";
	private static String FAMELE = "\uf183";

	public User(int currentFloor, int destinationFloor) {

		this.currentFloor = currentFloor;
		this.destinationFloor = destinationFloor;
		setFontUser();
	}

	public void setFontUser() {

		setFont(new MyFont().getfontAwesome());
		if (((int) (Math.random() * 2)) == 1) {
			setText(MALE);
		} else {
			setText(FAMELE);
		}
		setId("user");
	}

}
