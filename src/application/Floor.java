package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Floor extends HBox {

	private Label numFloor;
	private ArrayList<User> users;
	private User user;
	private int number = 0;
	private Button butUp;
	private Button butDown;
	private Button butPuf;

	public Floor(int number) {
		this.number = number;
		setPadding(new Insets(15, 12, 15, 12));
//		setMargin(this, new Insets(12,12,12,12));
		setId("hbox");
		addNumFloor();
		getChildren().add(numFloor);
		addButton();
		addUsers();

		// setAlignment(Pos.BOTTOM_RIGHT);

	}

	public void addButton() {
		butUp = new Button("\uf01b");
		butDown = new Button("\uf01a");
		butPuf= new Button();
		butPuf.isDisable();
		
		if (number == 0) {
			getChildren().addAll(butUp,butPuf);
		} else if(number == 7) {
			getChildren().addAll(butPuf,butDown);
		}else{
			getChildren().addAll(butUp, butDown);
		}
		// добавить условие для последнего етажа
	}

	public void addNumFloor() {
		numFloor = new Label(Integer.toString(number));

	}
	
	public void addUsers(){
		users = new ArrayList<User>();
		users.add(new User(0, 1));
		users.add(new User(0, 2));
		users.add(new User(0, 3));
		users.add(new User(0, 4));
		users.add(new User(0, 5));
		users.add(new User(0, 3));
		users.add(new User(0, 3));
		getChildren().addAll(users);
	}

}
