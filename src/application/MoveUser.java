package application;

import java.util.concurrent.TimeUnit;

import javafx.concurrent.Task;
import javafx.scene.layout.VBox;

public class MoveUser extends Task<Void> {

	private Building build;
	private int countUser = 10;
	private int countFloor;
	private int currentFloor;
	private int destinationFloor = 7;

	public MoveUser(Building build) {
		this.build = build;

	}

	@Override
	protected Void call() throws Exception {
System.out.println("Start move USER");
		addUser();

		return null;
	}

	public void addUser() {
		for (int i = 0; i < countUser; i++) {
			System.out.println("Start Use move");
			System.out
					.println("getCurrentFloor: " + getCurrentFloorRandom() + " destinationFloor: " + destinationFloor);
//			try {
//				System.out.println(((int) Math.random() * 10) + 3);
//				TimeUnit.SECONDS.sleep(((int) Math.random() * 10) + 3);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println((build.getFloors().length - 1) - countFloor);
			System.out.println("--------"+((build.getFloors().length - 1) - getCurrentFloorRandom()));
			System.out.println(build.getFloors()[1].toString());
            build.getFloors()[(build.getFloors().length - 1) - getCurrentFloorRandom()].addUsers(new User(getCurrentFloorRandom(), destinationFloor));
			System.out.println("ADD user to floor on class MoveUser");
		}
	}

	public int getCurrentFloorGoHome() {
		double d = Math.random() * 100;
		if ((d -= 80) < 0)
			return countFloor = 0;
		if ((d -= 2) < 0)
			return countFloor = 1;
		if ((d -= 2) < 0)
			return countFloor = 2;
		if ((d -= 2) < 0)
			return countFloor = 3;
		if ((d -= 2) < 0)
			return countFloor = 4;
		if ((d -= 2) < 0)
			return countFloor = 5;
		if ((d -= 2) < 0)
			return countFloor = 6;
		if ((d -= 2) < 0)
			return countFloor = 7;

		return countFloor = 0;

	}

	public int getCurrentFloorRandom() {

		return countFloor = ((int) (Math.random() * 8));

	}

}
