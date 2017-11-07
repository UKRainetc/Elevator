package application;

import java.util.concurrent.TimeUnit;

import javafx.concurrent.Task;
import javafx.scene.layout.VBox;

public class MoveUser extends Task<Void> {

	VBox build;

	private Floor[] floors=new Floor[8];
	private int countUser=10;
	private int countFloor;
	private int currentFloor;
	private int destinationFloor =7;
	
	
	public MoveUser(VBox build) {
		this.build=build;
		for (int i = 0; i <floors.length; i++) {
			floors[i]=new Floor((floors.length-i)-1);
			
			
		}
	}




	@Override
	protected Void call() throws Exception {
		
//			TimeUnit.SECONDS.sleep(((int) Math.random()*10)+3);
//			addUser((Floor) build.getChildren().get(countFloor));
			addUser();
			
		
	
		return null;
	}
	
	
	

	public Floor[] getFloors() {
		return floors;
	}




	public void addUser(){
		for (int i = 0; i < countUser; i++) {
			System.out.println("Start Use move");
		System.out.println("getCurrentFloor: "+getCurrentFloorRandom()+" destinationFloor: "+destinationFloor);
//		try {
//			System.out.println(((int) Math.random()*10)+3);
//			TimeUnit.SECONDS.sleep(((int) Math.random()*10)+3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		floors[(floors.length-1)-countFloor].toString();
		floors[(floors.length-1)-countFloor].addUsers(new User(getCurrentFloorRandom(), destinationFloor));
		System.out.println("ADD user to floor");
	}
	}
	
	public int getCurrentFloorGoHome(){
		double d = Math.random()*100;
		if((d -= 80)<0) return countFloor=0;
		if((d -= 2)<0) return countFloor=1;
		if((d -= 2)<0) return countFloor=2;
		if((d -= 2)<0) return countFloor=3;
		if((d -= 2)<0) return countFloor=4;
		if((d -= 2)<0) return countFloor=5;
		if((d -= 2)<0) return countFloor=6;
		if((d -= 2)<0) return countFloor=7;
		
		return countFloor=0;
		
	}
	public int getCurrentFloorRandom(){
		
		return countFloor=((int) (Math.random() * 8));
		
	}
	
	
}
