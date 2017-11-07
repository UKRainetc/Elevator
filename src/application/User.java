package application;

import javafx.scene.control.Label;


public class User extends Label {

	private int currentFloor;
	private int destinationFloor;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [currentFloor=" + currentFloor + ", destinationFloor=" + destinationFloor + "]";
	}
	
	

}
