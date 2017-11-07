package application;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Floor extends HBox {

	private Label numFloor;
	private ArrayList<User> users;
	private User user;
	private int number;
	private Button butUp;
	private Button butDown;
	private Button butPuf;

	public Floor(int number) {
		this.number = number;
		setPadding(new Insets(15, 12, 15, 12));
//		setMargin(this, new Insets(12,12,12,12));
		setId("floor");
		addNumFloor();
		getChildren().add(numFloor);
		addButton();
//		addUsers();
		numFloor.setId("numFlor");

		// setAlignment(Pos.BOTTOM_RIGHT);

	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Floor [number=" + number + "]";
	}



	public int getNumber() {
		return number;
	}



	public void addButton() {
		butUp = new Button("\uf01b");
		butDown = new Button("\uf01a");
		butPuf= new Button();
		butPuf.isDisable();
		
		if (number == 0) {
			butPuf.setMaxSize(27,23);
			butPuf.setMinSize(27, 23);
			butPuf.setPrefSize(27, 23);
			getChildren().addAll(butUp,butPuf);
		} else if(number == 7) {
//			butPuf.setPadding(new Insets(15));
			butPuf.setMaxSize(27,23);
			butPuf.setMinSize(27, 23);
			butPuf.setPrefSize(27, 23);
			getChildren().addAll(butPuf,butDown);
		}else{
			
			getChildren().addAll(butUp, butDown);
		}
		// добавить условие для последнего етажа
	}

	public void addNumFloor() {
		numFloor = new Label(Integer.toString(number));

	}
	
	public void addUsers(User user){
		System.out.println("Start add User on class Floor");
	users = new ArrayList<User>();
	users.add(user);
	System.out.println("Add in ArrayList");
	for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
		Object type = (Object) iterator.next();
		System.out.println("1"+type);
	}
	
	for (User us : users) {
		System.out.println("2"+us);
		this.getChildren().add(us);
		System.out.println("3"+us);
	}	
//		users.add(new User(0, 1));
//		users.add(new User(0, 2));
//		users.add(new User(0, 3));
//		users.add(new User(0, 4));
//		users.add(new User(0, 5));
//		users.add(new User(0, 3));
//		users.add(new User(0, 3));
	
//		getChildren().add(new User(1, 3));
		System.out.println("User add on class Floor");
	}

}
